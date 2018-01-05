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
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import org.apache.commons.lang3.StringUtils;

import edu.asu.wpcarey.eoc.beans.PanelistSearchBean;
import edu.asu.wpcarey.eoc.service.WBCService;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class WBCPanelUpdate extends JPanel implements ActionListener {
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
	private WBCService wbcService;

	private PanelistSearchBean panelistSearchBean;

	private JButton searchUser;
	private JButton updateUser;

	public static WBCPanelUpdate createInstance(WBCService wBCService) {
		return new WBCPanelUpdate(wBCService);
	}

	public WBCPanelUpdate(WBCService wBCService) {
		wbcService = wBCService;
		this.setSize(640, 160);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(EOCAppConstants.WBC_UPDATE_PANEL);
		setBorder(title);

		setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		searchTextField = new JTextField(12);
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

		firstName = new JLabel("First Name");
		c.gridx = 0;
		c.gridy = 2;
		this.add(firstName, c);

		firstNameField = new JTextField();
		c.gridx = 1;
		c.gridy = 2;
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
		updateUser.setEnabled(false);
		c.gridx = 0;
		c.gridy = 7;
		this.add(updateUser, c);
		updateUser.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.updateUser)) {
			if (firstNameField.getText().equals("") || lastNameField.getText().equals("") || emailAddressField.getText().equals("") || organizationField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please fill all the fields.");
			} else {
				int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?");
				if(confirm == JOptionPane.YES_OPTION) {
					panelistSearchBean.setFirstName(firstNameField.getText());
					panelistSearchBean.setLastName(lastNameField.getText());
					panelistSearchBean.setEmailAddress(emailAddressField.getText());
					panelistSearchBean.setOrganization(organizationField.getText());
					String response = wbcService.updateUser(panelistSearchBean);
					JOptionPane.showMessageDialog(this, response);
					firstNameField.setText(StringUtils.EMPTY);
					lastNameField.setText(StringUtils.EMPTY);
					emailAddressField.setText(StringUtils.EMPTY);
					organizationField.setText(StringUtils.EMPTY);
				}
			}
		} else {
			String searchString = this.searchTextField.getText();
			if(searchString.equals(StringUtils.EMPTY)) {
				JOptionPane.showMessageDialog(this, "Please enter a partial email address.");
			} else {
				panelistSearchBean = wbcService.searchUser(searchString);
				if (panelistSearchBean.getResponseState().equals(PanelistSearchBean.ResponseState.OK)) {
					SwingUtilities.invokeLater(new Runnable() {						
						@Override
						public void run() {
							firstNameField.setText(panelistSearchBean.getFirstName());
							firstNameField.repaint();
							lastNameField.setText(panelistSearchBean.getLastName());
							emailAddressField.setText(panelistSearchBean.getEmailAddress());
							organizationField.setText(panelistSearchBean.getOrganization());
							firstNameField.setText(panelistSearchBean.getFirstName());	
							updateUser.setEnabled(true);
						}
					});				
				} else if(panelistSearchBean.getResponseState().equals(PanelistSearchBean.ResponseState.NO_DATA)){
					JOptionPane.showMessageDialog(this, "No data found for the search string");
				} else {
					JOptionPane.showMessageDialog(this, "An error occurred.");
				}
			}
		}
		
	}
}
