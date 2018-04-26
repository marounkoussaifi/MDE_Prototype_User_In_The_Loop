/*
 * Nom de classe : LogService
 *
 * Description   : trace dans des fichiers de logs:
                   l’apparition et la disparition des composants repérés par la sonde
                   les connexions et déconnexions données par le relais
 *
 * Version       : 2.0
 *
 * Date          : 11/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : Seb on 03/02/17
 * Modified      : Sondes
 */

package interceptorCompo;

import java.io.File;
import java.text.Format;
import logService.LogService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import OCPlateforme.OCComponent;
import OCPlateforme.OCService;
import log.Interfaces.ILogComposant;
import log.Interfaces.ILogDecision;
import log.Interfaces.ILogRestitution;

public class LogComp implements ILogComposant, ILogDecision, ILogRestitution {

	private LogService logService = new LogService();

	public void logApparitionComposant(OCComponent Component) {

		String log = String.format("%s Provided=%s Required=%s - Apparition", this.getDateToString(),
				Component.getProvidedServices(), Component.getRequiredServices());
		this.logService.setLog(log);
	}

	public void logDisparitionComposant(OCComponent Component) {
		String log = String.format("%s Provided=%s Required=%s- Disparition", this.getDateToString(),
				Component.getProvidedServices(), Component.getRequiredServices());
		this.logService.setLog(log);
	}

	public void logBinding(OCService service1, OCService service2) {
		String log = String.format("%s %s %s - bind", this.getDateToString(), service1.getLinkedServices(),
				service2.getLinkedServices());
		this.logService.setLog(log);
	}

	public void logUnbinding(OCService service1, OCService service2) {
		String log = String.format("%s %s %s - unbind", this.getDateToString(), service1.getLinkedServices(),
				service2.getLinkedServices());
		this.logService.setLog(log);
	}

	/**
	 * Retourne la date actuelle sous forme yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 **/

	private String getDateToString() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		return formatter.format(new Date());
	}

	public File getLogFile() {
		return logService.getLog();
	}

	public FileHandler getLogFilehandler() {
		return logService.getFilehandler();
	}

}
