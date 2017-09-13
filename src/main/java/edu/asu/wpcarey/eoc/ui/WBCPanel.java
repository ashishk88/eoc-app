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
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import edu.asu.wpcarey.eoc.service.WBCService;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class WBCPanel extends JPanel implements ActionListener {

	public static JPanel createPanel() {
		return new WBCPanel();
	}

	private final JButton initiateWBC;
	private final JLabel panelLabel;
	private final WBCService wBCService;
	private final WBCPanelAdd wbcPanelAdd;
	private final WBCPanelUpdate wbcPanelUpdate;

	public WBCPanel() {
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

		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 1;
		this.add(initiateWBC, c);

		wbcPanelAdd = WBCPanelAdd.createInstance(wBCService);
		wbcPanelUpdate = WBCPanelUpdate.createInstance(wBCService);
		JTabbedPane jtp = new JTabbedPane();
	    jtp.addTab("Add a panelist", wbcPanelAdd);
	    jtp.addTab("Edit a panelist", wbcPanelUpdate);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(jtp, c);
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, EOCAppConstants.WBC_INITIATED);
		String msg = wBCService.initiateUpdate();
		JOptionPane.showMessageDialog(this, msg);
	}

}
