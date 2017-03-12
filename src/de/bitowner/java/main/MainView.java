package de.bitowner.java.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position.Bias;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.appender.FileAppender;

import javax.swing.text.View;

import de.bitowner.java.model.Profil;
import de.bitowner.java.view.ProfilAuthorizedView;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4897045755474033202L;
    private static final Logger LOGGER = LogManager.getLogger(MainView.class.getName());	
    public static final String HOMEPATH = System.getenv("appdata") + File.separator + "ContactManagement";
    private JTextField textField_Name;
	private JTextField textField_Pw;
	Profil prof = new Profil("test2321", "test"); 
		
	public MainView() {
		
    	LOGGER.info("Software Start.");
    	
    	
		getContentPane().setBackground(new Color(222, 184, 135));

		this.setTitle("Contact Manager");
		this.setBackground(Color.darkGray);
		this.setSize(808,602);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initMenu();
		initItems();
		
		
	
		this.setVisible(true);
		repaint();
		
	}

	
	
	public static void main(String[] args) {
		MainView mv = new MainView();
		
	}

	private void initMenu() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		
		JMenuItem mntmProfil = new JMenuItem("Profil");
		mnNew.add(mntmProfil);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 200, 200, 100, 0};
		gridBagLayout.rowHeights = new int[]{0, 102, 234, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
	}

	private void initItems() {
		
		JTextArea txtWelcome = new JTextArea();
		txtWelcome.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtWelcome.setWrapStyleWord(true);
		txtWelcome.setLineWrap(true);
		txtWelcome.setText("Danke das Sie sich f\u00FCr diese Software entschieden haben.\r\n\r\nBitte erstellen Sie ein neues Profil oder loggen sie sich ein.");
		txtWelcome.setBackground(new Color(222, 184, 135));
		txtWelcome.setEditable(false);
		
		
		GridBagConstraints gbcWelcomeTxt = new GridBagConstraints();
		gbcWelcomeTxt.fill = GridBagConstraints.HORIZONTAL;
		gbcWelcomeTxt.gridwidth = 2;
		gbcWelcomeTxt.ipadx = 2;
		gbcWelcomeTxt.insets = new Insets(0, 0, 5, 5);
		gbcWelcomeTxt.gridx = 1;
		gbcWelcomeTxt.gridy = 0;
		
		
		getContentPane().add(txtWelcome, gbcWelcomeTxt);
		
		
		
		//Create New Profil Button
		JButton btnNewProfil = new JButton("New Profil");
		btnNewProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textField_Name.getText().equals("") && !textField_Pw.getText().equals("")){
					if(textField_Pw.getText().length() >=8){
						 
						Profil profil = new Profil(textField_Name.getText(), textField_Pw.getText(),true);
						setVisible(false);
						ProfilAuthorizedView Pav = new ProfilAuthorizedView(profil);
						
						//TODO Doppelte Namen Verhindern
						
						
						
					}else
					{
						JOptionPane.showMessageDialog(null, "Passwort muss mindestens acht Zeichen Lang sein.","Warnung", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 121, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 20, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("BilldLbl");
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		GridBagConstraints gbc_textField_Name = new GridBagConstraints();
		gbc_textField_Name.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Name.gridx = 1;
		gbc_textField_Name.gridy = 2;
		panel.add(textField_Name, gbc_textField_Name);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 4;
		panel.add(lblPassword, gbc_lblPassword);
		
		textField_Pw = new JTextField();
		GridBagConstraints gbc_textField_Pw = new GridBagConstraints();
		gbc_textField_Pw.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Pw.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Pw.gridx = 1;
		gbc_textField_Pw.gridy = 4;
		panel.add(textField_Pw, gbc_textField_Pw);
		textField_Pw.setColumns(10);
		
		btnNewProfil.setForeground(new Color(0, 0, 139));
		btnNewProfil.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewProfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewProfil.setToolTipText("Create new Profil.");
		GridBagConstraints gbcNewProfilButton = new GridBagConstraints();
		gbcNewProfilButton.fill = GridBagConstraints.BOTH;
		gbcNewProfilButton.insets = new Insets(0, 0, 0, 5);
		gbcNewProfilButton.gridx = 1;
		gbcNewProfilButton.gridy = 3;
		getContentPane().add(btnNewProfil, gbcNewProfilButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setForeground(new Color(0, 0, 139));
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 3;
		getContentPane().add(btnLogin, gbc_btnLogin);
				
	}
	
	
}
