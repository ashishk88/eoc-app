package edu.asu.wpcarey.eoc.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.asu.wpcarey.eoc.service.JobGrowthService;

public class JobGrowthPanel extends JPanel implements ActionListener {

	public static JPanel createPanel() {
		return new JobGrowthPanel();
	}

	private final JButton initiateJG;
	private final JLabel panelLabel;
	private final JCheckBox loadMetaData;
	private final Boolean loadMetaDataFlag = Boolean.FALSE;
	private final JobGrowthService jobGrowthService;

	public JobGrowthPanel() {
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
		jobGrowthService = JobGrowthService.createInstance();
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, "Job growth has been initiated.");
		final boolean metaDataFlag = loadMetaData.isSelected();

		final String response = jobGrowthService.initiateJobGrowth(true, metaDataFlag);
		JOptionPane.showMessageDialog(this, response);
	}

}
