/*
 * Nom de classe : LogService
 *
 * Description   : permet la Création des fichiers log
 * 
 * Version       : 2.0
 *
 * Date          : 11/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : Seb on 03/02/17
 * Modified      : Sondes
 */
package logService;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogService {

	private Logger logger;
	private FileHandler fh;
	private File logFile;
	
	public LogService() {
		try {

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HHmmssSSS");
			String dateString = sdf.format(now); // obtention de la date en chaîne de caractère formatée
			String file_name = "MyLog_" + dateString;
			fh = new FileHandler(file_name, true);
			logger = Logger.getLogger("Mes traces");
			// Send logger output to our FileHandler.
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ecrit une ligne dans le fichier de log.
	 * 
	 * @param logLine
	 *            La ligne Ã  ecrire dans le fichier de log.
	 */
	public void setLog(String logLine) {

		try {
			logger.setLevel(Level.ALL);
			logger.info(logLine);
		} catch (Exception e) {
		}
	}

	/**
	 * getLog
	 * 
	 * @return File Le fichier de log.
	 */

	public File getLog() {
		return this.logFile;
	}

	/**
	 * getFilehandler
	 * 
	 * @return FileHandler
	 */
	public FileHandler getFilehandler() {
		return fh;
	}
}
