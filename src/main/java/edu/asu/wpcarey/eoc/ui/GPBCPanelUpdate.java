package edu.asu.wpcarey.eoc.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import edu.asu.wpcarey.eoc.service.GPBCService;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class GPBCPanelUpdate extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel searchText;
	private JLabel firstName;
	private JLabel lastName;
	private JLabel emailAddress;
	private JLabel organization;

	private JTextField searchTextField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailAddressField;
	private JTextField organizationField;
	private GPBCService gpbcService;


	private JButton searchUser;
	private JButton updateUser;

	public static GPBCPanelUpdate createInstance(GPBCService gPBCService) {
		return new GPBCPanelUpdate(gPBCService);
	}

	public GPBCPanelUpdate(GPBCService gPBCService) {
		gpbcService = gPBCService;
		this.setSize(640, 160);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(EOCAppConstants.WBC_UPDATE_PANEL);
		setBorder(title);

		setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		c.gridx = 1;
		c.gridy = 0;
		this.add(searchTextField, c);

		searchText = new JLabel("Search With Email");
		c.gridx = 0;
		c.gridy = 0;
		this.add(searchText, c);

		searchUser = new JButton("Search User");
		c.gridx = 0;
		c.gridy = 1;
		this.add(searchUser, c);
		searchUser.addActionListener(this);

		firstNameField = new JTextField();
		c.gridx = 1;
		c.gridy = 2;
		this.add(firstNameField, c);

		firstName = new JLabel("First Name");
		c.gridx = 0;
		c.gridy = 2;
		this.add(firstName, c);

		firstNameField = new JTextField();
		c.gridx = 1;
		c.gridy = 0;
		this.add(firstNameField, c);

		lastName = new JLabel("Last Name");
		c.gridx = 0;
		c.gridy = 3;
		this.add(lastName, c);

		lastNameField = new JTextField();
		c.gridx = 1;
		c.gridy = 3;
		this.add(lastNameField, c);

		emailAddress = new JLabel("Email Address");
		c.gridx = 0;
		c.gridy = 4;
		this.add(emailAddress, c);

		emailAddressField = new JTextField();
		c.gridx = 1;
		c.gridy = 4;
		this.add(emailAddressField, c);

		organization = new JLabel("Organization");
		c.gridx = 0;
		c.gridy = 6;
		this.add(organization, c);

		organizationField = new JTextField();
		c.gridx = 1;
		c.gridy = 6;
		this.add(organizationField, c);

		updateUser = new JButton("Update User");
		c.gridx = 0;
		c.gridy = 7;
		this.add(updateUser, c);
		updateUser.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (firstNameField.getText().equals("") || lastNameField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please fill the name field.");
		} else {
			JOptionPane.showMessageDialog(this, gpbcService.addUser(firstNameField.getText(), lastNameField.getText(),
					emailAddressField.getText(), organizationField.getText()));
		}
	}
}
