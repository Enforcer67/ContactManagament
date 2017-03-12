package de.bitowner.java.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore.PasswordProtection;
import java.util.Properties;

import org.apache.log4j.Logger;

import de.bitowner.java.handler.ContactListHandler;
import de.bitowner.java.main.MainView;

public class Profil {

	private String name;
	private String password;
	private ContactList contactList;
	private ContactListHandler contactListHaendler;
	private boolean authorized;
	private static Logger logger = Logger.getLogger(MainView.class);
	
	
	//Login
	public Profil(String name, String password) {
		this.name = name;
		this.password = password;

		// TODO Speichere Passwort

	}
	// Create New Profil
	public Profil(String name, String password, boolean itsNew) {
		this.name = name;
		this.password = password;
		initDir();
		savePassword();

		// TODO Speichere Passwort

	}

	private void savePassword() {

		// TODO Passwort Verschlüsseln
		// Zum Lesen:

//		Properties p = new Properties();
//		p.loadFromXML(new FileInputStream(new File("user.pass")));

		Properties p = new Properties();
		p.setProperty(password, name);
		try {
			p.storeToXML(
					new FileOutputStream(new File(MainView.HOMEPATH + File.separator + "Password\\" + name + "pw")),
					"nocomment");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Prüft ob Dateistruktur vorhanden ist. Falls nötig wird diese erstellt.
	 */
	private void initDir() {
		File stats = new File(MainView.HOMEPATH); // Maindirectory
		File pw = new File(MainView.HOMEPATH + File.separator + "Password"); // Pwdir

		if (!stats.exists()) {

			try {
				File contactmana = new File(MainView.HOMEPATH);

				contactmana.mkdir();
				contactmana.canExecute();
				contactmana.canExecute();

				logger.info("Pfad wurde erfolgreich agelegt.");
			} catch (Exception e) {
				logger.error(e);
			}
		}

		if (!pw.exists() && stats.exists()) {
			File passw = new File(MainView.HOMEPATH + File.separator + "Password");
			passw.mkdir();
			passw.canExecute();
		}
	}
	
	
	
	
	
	
	
	
	
	//GETTER
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public ContactList getContactList() {
		return contactList;
	}
	public ContactListHandler getContactListHaendler() {
		return contactListHaendler;
	}
	public boolean isAuthorized() {
		return authorized;
	}
	public static Logger getLogger() {
		return logger;
	}

}
