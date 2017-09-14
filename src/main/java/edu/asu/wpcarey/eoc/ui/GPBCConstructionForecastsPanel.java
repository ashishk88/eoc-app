package edu.asu.wpcarey.eoc.ui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import edu.asu.wpcarey.eoc.dao.DAOUtils;
import edu.asu.wpcarey.eoc.dao.GPBCDAO;

public class GPBCConstructionForecastsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GPBCDAO gpbcDAO;
	private JTabbedPane jtp;
	private JTable residentialCurrent;
	private JTable residentialNext;
	private JTable residentialNextToNextYear;

	private JTable officeCurrent;
	private JTable officeNext;
	private JTable officeNextToNextYear;

	private JTable retailCurrent;
	private JTable retailNext;
	private JTable retailNextToNextYear;

	private JTable industrialCurrent;
	private JTable industrialNext;
	private JTable industrialNextToNextYear;

	private String[] residentialColumns = new String[] { "Residential", "Single-family permits", "Multi-family permits",
			"Apartment Vacancy (Q4 %)", "Apartment Absorption (Units)", "Enabled", "Is Actual?" };

	private String[] restColumns = new String[] { "Residential", "Construction", "Vacancy (Year End %)", "Absorption",
			"Enabled", "Is Actual?" };

	private GPBCConstructionForecastsPanel() {
		jtp = new JTabbedPane();
		gpbcDAO = GPBCDAO.createInstance();
	}

	private static GPBCConstructionForecastsPanel constructionForecastsPanel;

	public static GPBCConstructionForecastsPanel createInstance() {

		if (constructionForecastsPanel == null) {
			constructionForecastsPanel = new GPBCConstructionForecastsPanel();
			constructionForecastsPanel.initiateTable();
		}

		return constructionForecastsPanel;
	}

	private void initiateTable() {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		residentialCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.RESIDENTIAL,
				this.residentialColumns);
		residentialNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.RESIDENTIAL,
				this.residentialColumns);

		officeCurrent = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.OFFICE, this.restColumns);
		officeNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.OFFICE, this.restColumns);

		retailCurrent = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.RETAIL, this.restColumns);
		retailNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.RETAIL, this.restColumns);

		industrialCurrent = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.INDUSTRIAL,
				this.restColumns);
		industrialNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.INDUSTRIAL,
				this.restColumns);

		if (getQuarter().equals("Q1")) {
			residentialNextToNextYear = prepareTable(currentYear + 2, DAOUtils.GBPCConstructionType.RESIDENTIAL,
					this.residentialColumns);
			officeNextToNextYear = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.OFFICE,
					this.restColumns);
			retailNextToNextYear = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.RETAIL,
					this.restColumns);
			industrialNextToNextYear = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.INDUSTRIAL,
					this.restColumns);
		}

		JTabbedPane residential = new JTabbedPane();
		residential.add(String.valueOf(currentYear),  new JScrollPane(residentialCurrent));
		residential.add(String.valueOf(currentYear + 1),  new JScrollPane(residentialNext));

		JTabbedPane office = new JTabbedPane();
		office.add(String.valueOf(currentYear),  new JScrollPane(officeCurrent));
		office.add(String.valueOf(currentYear + 1), officeNext);

		JTabbedPane retail = new JTabbedPane();
		retail.add(String.valueOf(currentYear),  new JScrollPane(retailCurrent));
		retail.add(String.valueOf(currentYear + 1),  new JScrollPane(retailNext));

		JTabbedPane industrial = new JTabbedPane();
		industrial.add(String.valueOf(currentYear),  new JScrollPane(industrialCurrent));
		industrial.add(String.valueOf(currentYear + 1),  new JScrollPane(industrialNext));

		if (getQuarter().equals("Q1")) {
			residential.add(String.valueOf(currentYear + 2),  new JScrollPane(residentialNextToNextYear));
			office.add(String.valueOf(currentYear + 2),  new JScrollPane(officeNextToNextYear));
			retail.add(String.valueOf(currentYear + 2),  new JScrollPane(retailNextToNextYear));
			industrial.add(String.valueOf(currentYear + 2),  new JScrollPane(industrialNextToNextYear));

		}
		jtp.add("Residential", residential);
		jtp.add("Office", office);
		jtp.add("Retail", retail);
		jtp.add("Industrial", industrial);
		
		this.setLayout(new BorderLayout());
		this.add(jtp, BorderLayout.CENTER);
	}

	private JTable prepareTable(int year, DAOUtils.GBPCConstructionType type, String[] columns) {
		Object[][] data = gpbcDAO.getGBPCConstructionData(year, type);
		JTable table = new JTable(data, columns);
		return table;
	}

	private String getQuarter() {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);

		return (month >= Calendar.JANUARY && month <= Calendar.MARCH) ? "Q1"
				: (month >= Calendar.APRIL && month <= Calendar.JUNE) ? "Q2"
						: (month >= Calendar.JULY && month <= Calendar.SEPTEMBER) ? "Q3" : "Q4";
	}
}
