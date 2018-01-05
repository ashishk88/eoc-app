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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import edu.asu.wpcarey.eoc.service.GPBCService;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class GPBCPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2709029311957918538L;

	public static JPanel createPanel(MainUI mainUI) {
		return new GPBCPanel(mainUI);
	}

	private final JButton initiateEconomicUpdate;
	private final JButton loadWBCContacts;
	private final JButton initiateConstructionUpdate;
	private final JLabel panelLabel;
	private final GPBCService gpbcService;
	private final GPBCPanelAdd gpbcPanelAdd;
	private final GPBCPanelUpdate gpbcPanelUpdate;

	public GPBCPanel(MainUI mainUI) {
		this.setSize(640, 160);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(EOCAppConstants.BORDER_GPBC_TITLE);
		setBorder(title);

		gpbcService = GPBCService.createInstance();
		panelLabel = new JLabel(EOCAppConstants.GPBC_LABEL_TEXT);

		initiateEconomicUpdate = new JButton(EOCAppConstants.GPBC_BUTTON_EF);
		initiateEconomicUpdate.addActionListener(this);

		initiateConstructionUpdate = new JButton(EOCAppConstants.GPBC_BUTTON_CF);
		initiateConstructionUpdate.addActionListener(this);

		setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 0;
		this.add(panelLabel, c);
		
		loadWBCContacts = new JButton("Load GPBC Contacts to Qualtrics");
		loadWBCContacts.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 1;
		this.add(loadWBCContacts, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(initiateConstructionUpdate, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(initiateEconomicUpdate, c);

		gpbcPanelAdd = GPBCPanelAdd.createInstance(gpbcService);
		gpbcPanelUpdate = GPBCPanelUpdate.createInstance(gpbcService);
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Add a panelist", gpbcPanelAdd);
		jtp.addTab("Edit a panelist", gpbcPanelUpdate);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		this.add(jtp, c);
		
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource().equals(initiateEconomicUpdate)) {
			CommandUI commandUI  = CommandUI.createInstance();
			commandUI.setFile(EOCAppConstants.GPBC_UPDATE_FILE);
			commandUI.setMessage("GPBC update initiated.");
			commandUI.start();
		} else if (e.getSource().equals(initiateConstructionUpdate)) {
			GPBCConstructionForecastsPanel constructionForecastsPanel = GPBCConstructionForecastsPanel.createInstance();
			UIManager.put("OptionPane.okButtonText", "Save");
			int result = JOptionPane.showConfirmDialog(null, constructionForecastsPanel, "Please fill up the data tables",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {				
				String response = gpbcService.saveData(constructionForecastsPanel);
				UIManager.put("OptionPane.okButtonText", "OK");
				JOptionPane.showMessageDialog(this, response);
			}
		} else if (e.getSource().equals(loadWBCContacts)) {
			CommandUI commandUI  = CommandUI.createInstance();
			commandUI.setFile(EOCAppConstants.GPBC_UPLOAD_CONTACTS);
			commandUI.setMessage("GPBC upload contacts initiated.");
			commandUI.start();
		}
	}
}
