package edu.asu.wpcarey.eoc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.asu.wpcarey.eoc.dao.DAOUtils;
import edu.asu.wpcarey.eoc.dao.DAOUtils.GBPCConstructionType;
import edu.asu.wpcarey.eoc.dao.GPBCDAO;

public class GPBCConstructionForecastsPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GPBCDAO gpbcDAO;
	private JTabbedPane jtp;

	private Object[] residentialColumns = new Object[] { "Organization", "Single-family permits", "Multi-family permits",
			"Apartment Vacancy (Q4 %)", "Apartment Absorption (Units)", "Enabled", "Is Actual?" };

	private Object[] restColumns = new Object[] { "Organization", "Construction", "Vacancy (Year End %)", "Absorption",
			"Enabled", "Is Actual?" };
	
	private DefaultTableModel dtmResidentialCurrent = new DefaultTableModel(null, residentialColumns);
	private JTable residentialCurrent;
	private DefaultTableModel dtmResidentialNext = new DefaultTableModel(null, residentialColumns);
	private JTable residentialNext;
	private DefaultTableModel dtmResidentialNextToNextYear = new DefaultTableModel(null, residentialColumns);
	private JTable residentialNextToNextYear;

	private DefaultTableModel dtmOfficeCurrent = new DefaultTableModel(null, restColumns);
	private JTable officeCurrent;
	private DefaultTableModel dtmOfficeNext = new DefaultTableModel(null, restColumns);
	private JTable officeNext;
	private DefaultTableModel dtmOfficeNextToNextYear = new DefaultTableModel(null, restColumns);
	private JTable officeNextToNextYear;

	private DefaultTableModel dtmRetailCurrent = new DefaultTableModel(null, restColumns);
	private JTable retailCurrent;
	private DefaultTableModel dtmRetailNext = new DefaultTableModel(null, restColumns);
	private JTable retailNext;
	private DefaultTableModel dtmRetailNextToNextYear = new DefaultTableModel(null, restColumns);
	private JTable retailNextToNextYear;

	private DefaultTableModel dtmIndustrialCurrent = new DefaultTableModel(null, restColumns);
	private JTable industrialCurrent;
	private DefaultTableModel dtmIndustrialNext = new DefaultTableModel(null, restColumns);
	private JTable industrialNext;
	private DefaultTableModel dtmIndustrialNextToNextYear = new DefaultTableModel(null, restColumns);
	private JTable industrialNextToNextYear;
	
	private JButton buttonResidentialCurrent;
	private JButton buttonResidentialNext;
	private JButton buttonResidentialNextToNextYear;
	private JButton buttonOfficeCurrent;
	private JButton buttonOfficeNext;
	private JButton buttonOfficeNextToNextYear;
	private JButton buttonRetailCurrent;
	private JButton buttonRetailNext;
	private JButton buttonRetailNextToNextYear;
	private JButton buttonIndustrialCurrent;
	private JButton buttonIndustrialNext;
	private JButton buttonIndustrialNextToNextYear;
	
	private Map<String, JTable> tableMap;
	
	private Object[] residentialDataColumns = new Object[] { "", "", "",
			"", "", "", "" };

	private Object[] restDataColumns = new Object[] { "", "", "", "",
			"", "" };

	private GPBCConstructionForecastsPanel() {
		jtp = new JTabbedPane();
		gpbcDAO = GPBCDAO.createInstance();
		this.setSize(new Dimension(1024, 768));
		
		 buttonResidentialCurrent = new JButton("Add Rows");
		 buttonResidentialNext = new JButton("Add Rows");
		 buttonResidentialNextToNextYear = new JButton("Add Rows");
		 buttonOfficeCurrent = new JButton("Add Rows");
		 buttonOfficeNext = new JButton("Add Rows");
		 buttonOfficeNextToNextYear = new JButton("Add Rows");
		 buttonRetailCurrent = new JButton("Add Rows");
		 buttonRetailNext = new JButton("Add Rows");
		 buttonRetailNextToNextYear = new JButton("Add Rows");
		 buttonIndustrialCurrent = new JButton("Add Rows");
		 buttonIndustrialNext = new JButton("Add Rows");
		 buttonIndustrialNextToNextYear = new JButton("Add Rows");
		 
		 buttonResidentialCurrent.addActionListener(this);
		 buttonResidentialNext.addActionListener(this);
		 buttonResidentialNextToNextYear.addActionListener(this);
		 buttonOfficeCurrent.addActionListener(this);
		 buttonOfficeNext.addActionListener(this);
		 buttonOfficeNextToNextYear.addActionListener(this);
		 buttonRetailCurrent.addActionListener(this);
		 buttonRetailNext.addActionListener(this);
		 buttonRetailNextToNextYear.addActionListener(this);
		 buttonIndustrialCurrent.addActionListener(this);
		 buttonIndustrialNext.addActionListener(this);
		 buttonIndustrialNextToNextYear.addActionListener(this);
		 tableMap = new HashMap<>();
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

		if (getQuarter().equals("Q1")) {
			currentYear--;
			residentialCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.RESIDENTIAL,
					this.residentialColumns, dtmResidentialCurrent);
			tableMap.put(DAOUtils.GBPCConstructionType.RESIDENTIAL.name()+String.valueOf(currentYear), residentialCurrent);
			residentialNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.RESIDENTIAL,
					this.residentialColumns, dtmResidentialNext);
			tableMap.put(DAOUtils.GBPCConstructionType.RESIDENTIAL.name()+String.valueOf(currentYear+1), residentialNext);

			officeCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.OFFICE, this.restColumns, dtmOfficeCurrent);
			tableMap.put(DAOUtils.GBPCConstructionType.OFFICE.name()+String.valueOf(currentYear), officeCurrent);
			officeNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.OFFICE, this.restColumns, dtmOfficeNext);
			tableMap.put(DAOUtils.GBPCConstructionType.OFFICE.name()+String.valueOf(currentYear+1), officeNext);

			retailCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.RETAIL, this.restColumns, dtmRetailCurrent);
			tableMap.put(DAOUtils.GBPCConstructionType.RETAIL.name()+String.valueOf(currentYear), retailCurrent);
			retailNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.RETAIL, this.restColumns, dtmRetailNext);
			tableMap.put(DAOUtils.GBPCConstructionType.RETAIL.name()+String.valueOf(currentYear+1), retailNext);

			industrialCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.INDUSTRIAL,
					this.restColumns, dtmIndustrialCurrent);
			tableMap.put(DAOUtils.GBPCConstructionType.INDUSTRIAL.name()+String.valueOf(currentYear), industrialCurrent);
			industrialNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.INDUSTRIAL,
					this.restColumns, dtmIndustrialNext);
			tableMap.put(DAOUtils.GBPCConstructionType.INDUSTRIAL.name()+String.valueOf(currentYear+1), industrialNext);
			
			residentialNextToNextYear = prepareTable(currentYear + 2, DAOUtils.GBPCConstructionType.RESIDENTIAL,
					this.residentialColumns, dtmResidentialNextToNextYear);
			tableMap.put(DAOUtils.GBPCConstructionType.RESIDENTIAL.name()+String.valueOf(currentYear+2), residentialNextToNextYear);
			
			
			officeNextToNextYear = prepareTable(currentYear + 2, DAOUtils.GBPCConstructionType.OFFICE,
					this.restColumns, dtmOfficeNextToNextYear);
			tableMap.put(DAOUtils.GBPCConstructionType.OFFICE.name()+String.valueOf(currentYear+2), officeNextToNextYear);
			
			retailNextToNextYear = prepareTable(currentYear + 2, DAOUtils.GBPCConstructionType.RETAIL,
					this.restColumns, dtmRetailNextToNextYear);
			tableMap.put(DAOUtils.GBPCConstructionType.RETAIL.name()+String.valueOf(currentYear+2), retailNextToNextYear);
			
			industrialNextToNextYear = prepareTable(currentYear + 2, DAOUtils.GBPCConstructionType.INDUSTRIAL,
					this.restColumns, dtmIndustrialNextToNextYear);
			tableMap.put(DAOUtils.GBPCConstructionType.INDUSTRIAL.name()+String.valueOf(currentYear+2), industrialNextToNextYear);
		} else {
			residentialCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.RESIDENTIAL,
					this.residentialColumns, dtmResidentialCurrent);
			tableMap.put(DAOUtils.GBPCConstructionType.RESIDENTIAL.name()+String.valueOf(currentYear), residentialCurrent);
			residentialNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.RESIDENTIAL,
					this.residentialColumns, dtmResidentialNext);
			tableMap.put(DAOUtils.GBPCConstructionType.RESIDENTIAL.name()+String.valueOf(currentYear+1), residentialNext);

			officeCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.OFFICE, this.restColumns, dtmOfficeCurrent);
			tableMap.put(DAOUtils.GBPCConstructionType.OFFICE.name()+String.valueOf(currentYear), officeCurrent);
			officeNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.OFFICE, this.restColumns, dtmOfficeNext);
			tableMap.put(DAOUtils.GBPCConstructionType.OFFICE.name()+String.valueOf(currentYear+1), officeNext);

			retailCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.RETAIL, this.restColumns, dtmRetailCurrent);
			tableMap.put(DAOUtils.GBPCConstructionType.RETAIL.name()+String.valueOf(currentYear), retailCurrent);
			retailNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.RETAIL, this.restColumns, dtmRetailNext);
			tableMap.put(DAOUtils.GBPCConstructionType.RETAIL.name()+String.valueOf(currentYear+1), retailNext);

			industrialCurrent = prepareTable(currentYear, DAOUtils.GBPCConstructionType.INDUSTRIAL,
					this.restColumns, dtmIndustrialCurrent);
			tableMap.put(DAOUtils.GBPCConstructionType.INDUSTRIAL.name()+String.valueOf(currentYear), industrialCurrent);
			industrialNext = prepareTable(currentYear + 1, DAOUtils.GBPCConstructionType.INDUSTRIAL,
					this.restColumns, dtmIndustrialNext);
			tableMap.put(DAOUtils.GBPCConstructionType.INDUSTRIAL.name()+String.valueOf(currentYear+1), industrialNext);
		}

		JTabbedPane residential = new JTabbedPane();
		JTabbedPane office = new JTabbedPane();
		JTabbedPane retail = new JTabbedPane();
		JTabbedPane industrial = new JTabbedPane();

		this.addButtonAndTable(residential, String.valueOf(currentYear), residentialCurrent, buttonResidentialCurrent);
		this.addButtonAndTable(residential, String.valueOf(currentYear+1), residentialNext, buttonResidentialNext);	

		this.addButtonAndTable(office, String.valueOf(currentYear), officeCurrent, buttonOfficeCurrent);
		this.addButtonAndTable(office, String.valueOf(currentYear+1), officeNext, buttonOfficeNext);

		this.addButtonAndTable(retail, String.valueOf(currentYear), retailCurrent, buttonRetailCurrent);
		this.addButtonAndTable(retail, String.valueOf(currentYear+1), retailNext, buttonRetailNext);

		this.addButtonAndTable(industrial, String.valueOf(currentYear), industrialCurrent, buttonIndustrialCurrent);
		this.addButtonAndTable(industrial, String.valueOf(currentYear+1), industrialNext, buttonIndustrialNext);

		if (getQuarter().equals("Q1")) {
			this.addButtonAndTable(residential, String.valueOf(currentYear + 2), residentialNextToNextYear, buttonResidentialNextToNextYear);
			this.addButtonAndTable(office, String.valueOf(currentYear + 2), officeNextToNextYear, buttonOfficeNextToNextYear);
			this.addButtonAndTable(retail, String.valueOf(currentYear + 2), retailNextToNextYear, buttonRetailNextToNextYear);
			this.addButtonAndTable(industrial, String.valueOf(currentYear + 2), industrialNextToNextYear, buttonIndustrialNextToNextYear);
		}
		
		jtp.add("Residential", residential);
		jtp.add("Office", office);
		jtp.add("Retail", retail);
		jtp.add("Industrial", industrial);
		
		this.setLayout(new BorderLayout());
		this.add(jtp, BorderLayout.CENTER);
	}
	
	private void addButtonAndTable(JTabbedPane pane, String label, JTable table, JButton button) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JScrollPane(table), BorderLayout.NORTH);
		panel.add(button, BorderLayout.SOUTH);
		pane.add(label, panel);
	}

	private JTable prepareTable(int year, DAOUtils.GBPCConstructionType type, Object[] columns, DefaultTableModel dtm) {
		String[][] data = gpbcDAO.getGBPCConstructionData(year, type);
		JTable table = new JTable(dtm);
		for(String[] row : data) {
			dtm.addRow(row);
		}
		return table;
	}

	public static String getQuarter() {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);

		return (month >= Calendar.JANUARY && month <= Calendar.MARCH) ? "Q1"
				: (month >= Calendar.APRIL && month <= Calendar.JUNE) ? "Q2"
						: (month >= Calendar.JULY && month <= Calendar.SEPTEMBER) ? "Q3" : "Q4";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.buttonResidentialCurrent)) {
			dtmResidentialCurrent.addRow(residentialDataColumns);
		} else if(e.getSource().equals(this.buttonResidentialNext)) {
			dtmResidentialNext.addRow(residentialDataColumns);			
		} else if(e.getSource().equals(this.buttonResidentialNextToNextYear)) {
			dtmResidentialNextToNextYear.addRow(residentialDataColumns);
		} else if(e.getSource().equals(this.buttonOfficeCurrent)) {
			dtmOfficeCurrent.addRow(restDataColumns);
		} else if(e.getSource().equals(this.buttonOfficeNext)) {
			dtmOfficeNext.addRow(restDataColumns);
		} else if(e.getSource().equals(this.buttonOfficeNextToNextYear)) {
			dtmOfficeNextToNextYear.addRow(restDataColumns);
		} else if(e.getSource().equals(this.buttonRetailCurrent)) {
			dtmRetailCurrent.addRow(restDataColumns);
		} else if(e.getSource().equals(this.buttonRetailNext)) {
			dtmRetailNext.addRow(restDataColumns);
		} else if(e.getSource().equals(this.buttonRetailNextToNextYear)) {
			dtmRetailNextToNextYear.addRow(restDataColumns);
		} else if(e.getSource().equals(this.buttonIndustrialCurrent)) {
			dtmIndustrialCurrent.addRow(restDataColumns);
		} else if(e.getSource().equals(this.buttonIndustrialNext)) {
			dtmIndustrialNext.addRow(restDataColumns);
		} else if(e.getSource().equals(this.buttonIndustrialNextToNextYear)) {
			dtmIndustrialNextToNextYear.addRow(restDataColumns);
		}
	}

	public String[][] getData(GBPCConstructionType type, int year) {
		JTable table = this.tableMap.get(type.name()+String.valueOf(year));
		return getTableData(table);
	}
	
	public String[][] getTableData (JTable table) {
		if(table == null)
			return null;
	    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    String[][] tableData = new String[nRow][nCol];
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++)
	            tableData[i][j] = (String)dtm.getValueAt(i,j);
	    return tableData;
	}
}
