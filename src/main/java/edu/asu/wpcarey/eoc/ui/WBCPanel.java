package edu.asu.wpcarey.eoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import edu.asu.wpcarey.eoc.service.WBCService;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class WBCPanel extends JPanel implements ActionListener {

	public static JPanel createPanel(MainUI mainUI) {
		return new WBCPanel(mainUI);
	}

	private final JButton initiateWBC;
	private final JButton loadWBCContacts;
	private final JLabel panelLabel;
	private final WBCService wBCService;
	private final WBCPanelAdd wbcPanelAdd;
	private final WBCPanelUpdate wbcPanelUpdate;

	public WBCPanel(MainUI mainUI) {
		wBCService = WBCService.createInstance();
		this.setSize(640, 160);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(EOCAppConstants.WBC);
		setBorder(title);

		panelLabel = new JLabel(EOCAppConstants.WBC_LABEL_TEXT);

		initiateWBC = new JButton(EOCAppConstants.WBC_BUTTON_TEXT);
		initiateWBC.addActionListener(this);
		setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 0;
		this.add(panelLabel, c);
		
		loadWBCContacts = new JButton("Load WBC Contacts to Qualtrics");
		loadWBCContacts.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 1;
		this.add(loadWBCContacts, c);
		
		
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 2;
		this.add(initiateWBC, c);

		wbcPanelAdd = WBCPanelAdd.createInstance(wBCService);
		wbcPanelUpdate = WBCPanelUpdate.createInstance(wBCService);
		JTabbedPane jtp = new JTabbedPane();
	    jtp.addTab("Add a panelist", wbcPanelAdd);
	    jtp.addTab("Edit a panelist", wbcPanelUpdate);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(jtp, c);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if(e.getSource().equals(this.initiateWBC)) {
			CommandUI commandUI  = CommandUI.createInstance();
			commandUI.setFile(EOCAppConstants.WBC_UPDATE_FILE);
			commandUI.setMessage("WBC update initiated.");
			commandUI.start();
		} else if(e.getSource().equals(this.loadWBCContacts)) {
			CommandUI commandUI  = CommandUI.createInstance();
			commandUI.setFile(EOCAppConstants.WBC_UPLOAD_CONTACTS);
			commandUI.setMessage("WBC upload contacts initiated.");
			commandUI.start();
		} 
	}

}
