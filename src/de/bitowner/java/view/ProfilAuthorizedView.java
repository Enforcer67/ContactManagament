package de.bitowner.java.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.bitowner.java.model.Profil;
import java.awt.Insets;
import java.awt.Color;

public class ProfilAuthorizedView extends JFrame {
	
	private Profil profil;
	public ProfilAuthorizedView(Profil profil) {
	this.profil = profil;
	
	
	setTitle("Contact Management " + profil.getName());
	setSize(1024,1000);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{98, 126, 193, 224, 200, 0};
	gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
	gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
	getContentPane().setLayout(gridBagLayout);
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.ORANGE);
	GridBagConstraints gbc_panel = new GridBagConstraints();
	gbc_panel.gridheight = 4;
	gbc_panel.fill = GridBagConstraints.BOTH;
	gbc_panel.gridx = 4;
	gbc_panel.gridy = 1;
	
	getContentPane().add(panel, gbc_panel);
	GridBagLayout gbl_panel = new GridBagLayout();
	gbl_panel.columnWidths = new int[]{0};
	gbl_panel.rowHeights = new int[]{0};
	gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
	gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
	panel.setLayout(gbl_panel);
	
	
	
	setVisible(true);
	}

}
