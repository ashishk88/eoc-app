package edu.asu.wpcarey.eoc.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Workbook;

import edu.asu.wpcarey.eoc.service.GPBCService;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class GPBCPanel extends JPanel implements ActionListener {

	public static JPanel createPanel() {
		return new GPBCPanel();
	}

	private final JButton initiateEconomicUpdate;
	private final JButton initiateConstructionUpdate;
	private final JLabel panelLabel;
	private final GPBCService gpbcService;
	private final GPBCPanelAdd gpbcPanelAdd;
	private final GPBCPanelUpdate gpbcPanelUpdate;

	public GPBCPanel() {
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

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		this.add(initiateConstructionUpdate, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(initiateEconomicUpdate, c);

		gpbcPanelAdd = GPBCPanelAdd.createInstance(gpbcService);
		gpbcPanelUpdate = GPBCPanelUpdate.createInstance(gpbcService);
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Add a panelist", gpbcPanelAdd);
		jtp.addTab("Edit a panelist", gpbcPanelUpdate);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(jtp, c);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource().equals(initiateEconomicUpdate)) {
			JOptionPane.showMessageDialog(this, EOCAppConstants.GPBC_ALERT_ED);
			gpbcService.initiateEFUpdate();
		} else if (e.getSource().equals(initiateConstructionUpdate)) {
			GPBCConstructionForecastsPanel constructionForecastsPanel = GPBCConstructionForecastsPanel.createInstance();
			int result = JOptionPane.showConfirmDialog(null, constructionForecastsPanel, "Please fill up the data tables",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {

			}
		}
	}
}
