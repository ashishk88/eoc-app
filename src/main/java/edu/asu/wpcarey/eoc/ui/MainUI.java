package edu.asu.wpcarey.eoc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import org.apache.commons.lang3.StringUtils;

import edu.asu.wpcarey.eoc.utils.AESCrypt;
import edu.asu.wpcarey.eoc.utils.EOCAppConstants;

public class MainUI extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static MainUI app = new MainUI();

	private static void checkSecurity() {
		final JLabel label = new JLabel("Please enter your password:");
		final JPasswordField jpf = new JPasswordField();
		JOptionPane.showConfirmDialog(null, new Object[] { label, jpf }, "Password:", JOptionPane.OK_CANCEL_OPTION);
		if (!AESCrypt.decrypt(EOCAppConstants.EOC_APP_PASSWORD).equals(new String(jpf.getPassword()))) {
			JOptionPane.showMessageDialog(app, "Incorrect Password!! Try Again.");
			jpf.setText(StringUtils.EMPTY);
			JOptionPane.showConfirmDialog(null, new Object[] { label, jpf }, "Password:", JOptionPane.OK_CANCEL_OPTION);
		}
		if (!AESCrypt.decrypt(EOCAppConstants.EOC_APP_PASSWORD).equals(new String(jpf.getPassword()))) {
			JOptionPane.showMessageDialog(app, "Incorrect Password!! Try Again");
			jpf.setText(StringUtils.EMPTY);
			JOptionPane.showConfirmDialog(null, new Object[] { label, jpf }, "Password:", JOptionPane.OK_CANCEL_OPTION);
		}
		if (!AESCrypt.decrypt(EOCAppConstants.EOC_APP_PASSWORD).equals(new String(jpf.getPassword()))) {
			JOptionPane.showMessageDialog(app, "Incorrect Password!!");
			System.exit(0);
		}
	}

	static {
		checkSecurity();
	}

	private static void createAndDisplayGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final UnsupportedLookAndFeelException e) {

		} catch (final ClassNotFoundException e) {

		} catch (final InstantiationException e) {

		} catch (final IllegalAccessException e) {

		}
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
		app.setLayout(new BorderLayout());
		app.addContent();
		app.setVisible(true);
		app.setResizable(true);
		app.setSize(new Dimension(440, 780));
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndDisplayGUI();
			}
		});
	}

	public MainUI() {
		super(EOCAppConstants.WP_CAREY_EOC);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (EOCAppConstants.MENU_ITEM_CLOSE.equals(e.getActionCommand())) {
			System.exit(EOCAppConstants.SUCCESS);
		} else if (EOCAppConstants.MENU_ITEM_HELP.equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(this, new MessageWithLink(EOCAppConstants.MENU_HELP_TEXT));
		} else if (EOCAppConstants.MENU_ITEM_LINKS.equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(this, new MessageWithLink(EOCAppConstants.MENU_LINKS_TEXT));
		}
	}

	private void addContent() {        
		final JMenuBar appMenu = new JMenuBar();

		final JMenu fileMenu = new JMenu(EOCAppConstants.MENU_FILE);
		final JMenu aboutMenu = new JMenu(EOCAppConstants.MENU_ABOUT);
		final JMenu linkMenu = new JMenu(EOCAppConstants.MENU_LINKS);

		final JMenuItem closeApp = new JMenuItem(EOCAppConstants.MENU_ITEM_CLOSE);
		closeApp.setActionCommand(EOCAppConstants.MENU_ITEM_CLOSE);
		closeApp.addActionListener(this);
		fileMenu.add(closeApp);

		final JMenuItem helpApp = new JMenuItem(EOCAppConstants.MENU_ITEM_HELP);
		helpApp.setActionCommand(EOCAppConstants.MENU_ITEM_HELP);
		helpApp.addActionListener(this);
		aboutMenu.add(helpApp);

		final JMenuItem links = new JMenuItem(EOCAppConstants.MENU_ITEM_LINKS);
		links.setActionCommand(EOCAppConstants.MENU_ITEM_LINKS);
		links.addActionListener(this);
		linkMenu.add(links);

		appMenu.add(fileMenu);
		appMenu.add(aboutMenu);
		appMenu.add(linkMenu);

		setJMenuBar(appMenu);

		this.add(JobGrowthPanel.createPanel(this), BorderLayout.CENTER);
		this.add(GPBCPanel.createPanel(this), BorderLayout.SOUTH);
		this.add(WBCPanel.createPanel(this), BorderLayout.NORTH);
	}
}

/*
 * Used as mentioned on :
 * http://stackoverflow.com/questions/8348063/clickable-links-in-joptionpane
 */
class MessageWithLink extends JEditorPane {
	private static final long serialVersionUID = 1L;

	static StringBuffer getStyle() {
		// for copying style
		final JLabel label = new JLabel();
		final Font font = label.getFont();
		final Color color = label.getBackground();

		// create some css from the label's font
		final StringBuffer style = new StringBuffer("font-family:" + font.getFamily() + ";");
		style.append("font-weight:" + (font.isBold() ? "bold" : "normal") + ";");
		style.append("font-size:" + font.getSize() + "pt;");
		style.append("background-color: rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ");");
		return style;
	}

	public MessageWithLink(final String htmlBody) {
		super("text/html", "<html><body style=\"" + getStyle() + "\">" + htmlBody + "</body></html>");
		addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(final HyperlinkEvent e) {
			}
		});
		setEditable(false);
		setBorder(null);
	}
}
