package de.bitowner.java.view;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

public class ContactAddin extends JComponent{
	public ContactAddin() {
		//setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.ORANGE));
		setSize(200, 75);
//		setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{107, 45, 45, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblContactPic = new JLabel("Picture");
		lblContactPic.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblContactPic = new GridBagConstraints();
		gbc_lblContactPic.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblContactPic.gridheight = 2;
		gbc_lblContactPic.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactPic.gridx = 0;
		gbc_lblContactPic.gridy = 0;
		add(lblContactPic, gbc_lblContactPic);
		
		JTextPane txtName = new JTextPane();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.BOTH;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		add(txtName, gbc_txtName);
		
		JTextPane txtBirthday = new JTextPane();
		txtBirthday.setText("");
		GridBagConstraints gbc_txtBirthday = new GridBagConstraints();
		gbc_txtBirthday.insets = new Insets(0, 0, 5, 0);
		gbc_txtBirthday.fill = GridBagConstraints.BOTH;
		gbc_txtBirthday.gridx = 2;
		gbc_txtBirthday.gridy = 0;
		add(txtBirthday, gbc_txtBirthday);
		
		JTextPane txtLocation = new JTextPane();
		GridBagConstraints gbc_txtLocation = new GridBagConstraints();
		gbc_txtLocation.gridheight = 2;
		gbc_txtLocation.insets = new Insets(0, 0, 0, 5);
		gbc_txtLocation.fill = GridBagConstraints.BOTH;
		gbc_txtLocation.gridx = 1;
		gbc_txtLocation.gridy = 1;
		add(txtLocation, gbc_txtLocation);
		
		JTextPane txtPhoneNr = new JTextPane();
		GridBagConstraints gbc_txtPhoneNr = new GridBagConstraints();
		gbc_txtPhoneNr.fill = GridBagConstraints.BOTH;
		gbc_txtPhoneNr.gridx = 2;
		gbc_txtPhoneNr.gridy = 2;
		add(txtPhoneNr, gbc_txtPhoneNr);
		this.setVisible(true);
		repaint();
		revalidate();
	}

	
	
}
