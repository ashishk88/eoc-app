package edu.asu.wpcarey.eoc.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class JobGrowthPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3871419017267858569L;

	public static JPanel createPanel(MainUI mainUI) {
		return new JobGrowthPanel(mainUI);
	}
	
	private final JButton initiateJG;
	private final JLabel panelLabel;
	private final JCheckBox loadMetaData;
	
	public JobGrowthPanel(MainUI mainUI) {
		this.setSize(640, 160);
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Job Growth");
		setBorder(title);

		panelLabel = new JLabel("Use the button below to initiate the job growth update.");

		initiateJG = new JButton("Initiate Job Growth Update");
		initiateJG.addActionListener(this);
		setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 0;
		this.add(panelLabel, c);

		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 1;
		this.add(initiateJG, c);

		loadMetaData = new JCheckBox("Load meta data");

		c.fill = GridBagConstraints.HORIZONTAL;

		
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 2;
		c.gridy = 2;
		this.add(loadMetaData, c);
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		final boolean metaDataFlag = loadMetaData.isSelected();
		if(metaDataFlag) {
			CommandUI commandUI  = CommandUI.createInstance();
			commandUI.setFile(EOCAppConstants.JOB_GROWTH_MD_UPDATE_FILE);
			commandUI.setMessage("Job Growth Meta Data Load Initiated.");
			commandUI.start();
		}
		CommandUI commandUI  = CommandUI.createInstance();
		commandUI.setFile(EOCAppConstants.JOB_GROWTH_UPDATE_FILE);
		commandUI.setMessage("Job Growth Update Initiated.");
		commandUI.start();
	}
}
