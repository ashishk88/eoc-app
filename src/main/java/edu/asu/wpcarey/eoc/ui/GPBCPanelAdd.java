package edu.asu.wpcarey.eoc.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import edu.asu.wpcarey.eoc.service.GPBCService;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class GPBCPanelAdd extends JPanel implements ActionListener {

	private JLabel firstName;
	private JLabel lastName;
	private JLabel emailAddress;
	private JLabel organization;
	private JLabel state;

	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailAddressField;
	private JTextField organizationField;
	private GPBCService gpbcService;

	private JButton addUser;

	public static GPBCPanelAdd createInstance(GPBCService gpbcService) {
		return new GPBCPanelAdd(gpbcService);
	}

	public GPBCPanelAdd(GPBCService gpbcService) {
		this.gpbcService = gpbcService;
		this.setSize(640, 160);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(EOCAppConstants.WBC_ADD_PANEL);
		setBorder(title);

		setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		firstName = new JLabel("First Name");
		c.gridx = 0;
		c.gridy = 0;
		this.add(firstName, c);

		firstNameField = new JTextField();
		firstNameField.setColumns(10);
		c.gridx = 1;
		c.gridy = 0;
		this.add(firstNameField, c);

		lastName = new JLabel("Last Name");
		c.gridx = 0;
		c.gridy = 1;
		this.add(lastName, c);

		lastNameField = new JTextField();
		c.gridx = 1;
		c.gridy = 1;
		this.add(lastNameField, c);

		emailAddress = new JLabel("Email Address");
		c.gridx = 0;
		c.gridy = 2;
		this.add(emailAddress, c);

		emailAddressField = new JTextField();
		c.gridx = 1;
		c.gridy = 2;
		this.add(emailAddressField, c);

		organization = new JLabel("Organization");
		c.gridx = 0;
		c.gridy = 3;
		this.add(organization, c);

		organizationField = new JTextField();
		c.gridx = 1;
		c.gridy = 3;
		this.add(organizationField, c);

		addUser = new JButton("Add User");
		c.gridx = 0;
		c.gridy = 4;
		this.add(addUser, c);
		addUser.addActionListener(this);
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
