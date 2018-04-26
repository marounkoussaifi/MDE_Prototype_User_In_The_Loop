package interceptorCompo;

import java.util.ArrayList;

import com.m2dl.sma.infrastructure.Infrastructure;

import MockupCompo.MockupComponent;
import MockupCompo.MockupService;
import MockupCompo.MultiLinkMockupService;
import MockupCompo.Way;
import MockupFacadeAdapter.MockupFacadeAdapter;
import OCPlateforme.OCService;
import medium.Medium;
import sonde.Sonde;

import FacadeAdapter.BindingFailure;
import FacadeAdapter.IBinding;
import FacadeAdapter.UnbindingFailure;

import log.Interfaces.ILogDecision;

public class MiseJaneUseCase {

	public static void main(String[] args) {

		MockupFacadeAdapter mockupFacadeAdapter = new MockupFacadeAdapter();

		// Infrastructure infrastructure = new Infrastructure();
		// Matching alwaysTrueMatching = new Matching();
		// Medium medium = new Medium(infrastructure, alwaysTrueMatching);
		LogComp logger = new LogComp(); // Lot Log
		RelaisImpl ambientEnv = new RelaisImpl((IBinding) mockupFacadeAdapter, (ILogDecision) logger);

		// Sonde sonde = new Sonde(mockupFacadeAdapter, logger, medium,
		// infrastructure);
		// sonde.run();

		// **************************************
		// **** Use case of Quiz Service ****

		// Polling Station component : 1 fourni (ReportService) + 2 requis
		// (TeacherCommandService, VoteService)
		ArrayList<OCService> providedByC1 = new ArrayList<OCService>();
		MockupService I1ofC1 = new MultiLinkMockupService("Report Service", "Polling Station", Way.PROVIDED);
		providedByC1.add(I1ofC1);
		ArrayList<OCService> requiredByC1 = new ArrayList<OCService>();
		MockupService I2ofC1 = new MultiLinkMockupService("Master Control Service", "Polling Station", Way.REQUIRED);
		requiredByC1.add(I2ofC1);
		MockupService I3ofC1 = new MultiLinkMockupService("Vote Service", "Polling Station", Way.REQUIRED);
		requiredByC1.add(I3ofC1);
		MockupComponent C1 = new MockupComponent("Polling Station", providedByC1, requiredByC1);
		mockupFacadeAdapter.addComponent(C1);

		// Report Generator component : 1 requis ReportService
		ArrayList<OCService> providedByC2 = new ArrayList<OCService>();
		ArrayList<OCService> requiredByC2 = new ArrayList<OCService>();
		MockupService I1ofC2 = new MultiLinkMockupService("Report Service", "Report Generator", Way.REQUIRED);
		requiredByC2.add(I1ofC2);
		MockupComponent C2 = new MockupComponent("Report Generator", providedByC2, requiredByC2);
		mockupFacadeAdapter.addComponent(C2);

		// Teacher Remote Control component : 1 fourni TeacherCommandService
		ArrayList<OCService> providedByC3 = new ArrayList<OCService>();
		MockupService I1ofC3 = new MultiLinkMockupService("Teacher Command Service", "Teacher Remote Control",
				Way.PROVIDED);
		providedByC3.add(I1ofC3);
		ArrayList<OCService> requiredByC3 = new ArrayList<OCService>();
		MockupComponent C3 = new MockupComponent("Teacher Remote Control", providedByC3, requiredByC3);
		mockupFacadeAdapter.addComponent(C3);

		// Student Remote Control component : 1 fourni (VoteService)
		ArrayList<OCService> providedByC4 = new ArrayList<OCService>();
		MockupService I1ofC4 = new MultiLinkMockupService("Vote Service", "Student Remote Control", Way.PROVIDED);
		providedByC4.add(I1ofC4);
		ArrayList<OCService> requiredByC4 = new ArrayList<OCService>();
		MockupComponent C4 = new MockupComponent("Student Remote Control", providedByC4, requiredByC4);
		mockupFacadeAdapter.addComponent(C4);

		// Student Remote Control component : 1 fourni (VoteService)
		ArrayList<OCService> providedByC4bis = new ArrayList<OCService>();
		MockupService I1ofC4bis = new MultiLinkMockupService("Vote Service", "Student Remote Control", Way.PROVIDED);
		providedByC4bis.add(I1ofC4bis);
		ArrayList<OCService> requiredByC4bis = new ArrayList<OCService>();
		MockupComponent C4bis = new MockupComponent("Student Remote Control", providedByC4bis, requiredByC4bis);
		mockupFacadeAdapter.addComponent(C4bis);
		
		// Student Remote Control component : 1 fourni (VoteService)
		ArrayList<OCService> providedByC4beta = new ArrayList<OCService>();
		MockupService I1ofC4beta = new MultiLinkMockupService("Vote Service", "Student Remote Control", Way.PROVIDED);
		providedByC4bis.add(I1ofC4beta);
		ArrayList<OCService> requiredByC4beta = new ArrayList<OCService>();
		MockupComponent C4beta = new MockupComponent("Student Remote Control", providedByC4beta, requiredByC4beta);
		mockupFacadeAdapter.addComponent(C4beta);

		// Vertical Slider component : 1 fourni (Value Service)
		ArrayList<OCService> providedByC5 = new ArrayList<OCService>();
		MockupService I1ofC5 = new MultiLinkMockupService("Value Service", "Vertical Slider", Way.PROVIDED);
		providedByC5.add(I1ofC5);
		ArrayList<OCService> requiredByC5 = new ArrayList<OCService>();
		MockupComponent C5 = new MockupComponent("Vertical Slider", providedByC5, requiredByC5);
		mockupFacadeAdapter.addComponent(C5);

		// Horizontal Slider component : 1 fourni (Value Service)
		ArrayList<OCService> providedByC6 = new ArrayList<OCService>();
		MockupService I1ofC6 = new MultiLinkMockupService("Value Service", "Horizontal Slider", Way.PROVIDED);
		providedByC6.add(I1ofC6);
		ArrayList<OCService> requiredByC6 = new ArrayList<OCService>();
		MockupComponent C6 = new MockupComponent("Horizontal Slider", providedByC6, requiredByC6);
		mockupFacadeAdapter.addComponent(C6);

		// Dimmer Switch component : 1 fourni (Value Service)
		ArrayList<OCService> providedByC7 = new ArrayList<OCService>();
		MockupService I1ofC7 = new MultiLinkMockupService("Value Service", "Dimmer Switch", Way.PROVIDED);
		providedByC6.add(I1ofC7);
		ArrayList<OCService> requiredByC7 = new ArrayList<OCService>();
		MockupComponent C7 = new MockupComponent("Dimmer Switch", providedByC7, requiredByC7);
		mockupFacadeAdapter.addComponent(C7);

		// step 1 : usual assembly of the Quiz service
		try {
			ambientEnv.bind(I1ofC1, I1ofC2, C1, C2);
			ambientEnv.bind(I2ofC1, I1ofC3, C1, C3);
			ambientEnv.bind(I3ofC1, I1ofC4, C1, C4);
			ambientEnv.bind(I3ofC1, I1ofC4bis, C1, C4bis);
		} catch (BindingFailure e) {
			e.printStackTrace();
		}

		// step 2 : vertical slider binding
		pause(1000);
		try {
			ambientEnv.bind(I3ofC1, I1ofC5, C1, C5);
		} catch (BindingFailure e) {
			e.printStackTrace();
		}

		// step 3 : end of the vote
		pause(3000);
		try {
			ambientEnv.unbind(I1ofC1, I1ofC2);
			ambientEnv.unbind(I2ofC1, I1ofC3);
			ambientEnv.unbind(I3ofC1, I1ofC4);
			ambientEnv.unbind(I3ofC1, I1ofC4bis);
		} catch (UnbindingFailure e) {
			e.printStackTrace();
		}

		// *****************************************
		// **** Components of the Order Service ****

		// Order Generator component
		ArrayList<OCService> providedByC8 = new ArrayList<OCService>();
		MockupService I1ofC8 = new MultiLinkMockupService("Menu Service", "Order Generator", Way.PROVIDED);
		providedByC8.add(I1ofC8);
		ArrayList<OCService> requiredByC8 = new ArrayList<OCService>();
		MockupService I2ofC8 = new MultiLinkMockupService("Order Service", "Order Generator", Way.REQUIRED);
		requiredByC8.add(I2ofC8);
		MockupComponent C8 = new MockupComponent("Order Generator", providedByC8, requiredByC8);
		mockupFacadeAdapter.addComponent(C8);

		// Menu Visualisation component
		ArrayList<OCService> providedByC9 = new ArrayList<OCService>();
		ArrayList<OCService> requiredByC9 = new ArrayList<OCService>();
		MockupService I1ofC9 = new MultiLinkMockupService("Menu Service", "Menu Visualisation", Way.REQUIRED);
		requiredByC9.add(I1ofC9);
		MockupComponent C9 = new MockupComponent("Menu Visualisation", providedByC9, requiredByC9);
		mockupFacadeAdapter.addComponent(C9);

		// Customer Input Interface component
		ArrayList<OCService> providedByC10 = new ArrayList<OCService>();
		MockupService I1ofC10 = new MultiLinkMockupService("Order Service", "Customer Input Interface", Way.PROVIDED);
		providedByC10.add(I1ofC10);
		ArrayList<OCService> requiredByC10 = new ArrayList<OCService>();
		MockupComponent C10 = new MockupComponent("Customer Input Interface", providedByC10, requiredByC10);
		mockupFacadeAdapter.addComponent(C10);

		pause(3000);
		// *********************************************
		// **** Emergence of the new Pub4.0 service ****
		try {
			//Connecting the Order Generator to the Polling Station
			ambientEnv.bind(I2ofC8, I1ofC1, C8, C1);
			//Connecting the Vertical Slider to the Polling Station
			ambientEnv.bind(I2ofC1, I1ofC5, C1, C5);
			//Connecting 3 students remote controls to the Polling Station
			ambientEnv.bind(I3ofC1, I1ofC4, C1, C4);
			ambientEnv.bind(I3ofC1, I1ofC4bis, C1, C4bis);
			ambientEnv.bind(I3ofC1, I1ofC4beta, C1, C4beta);

		} catch (BindingFailure e) {
			e.printStackTrace();
		}
		logger.getLogFilehandler().close();

		//ambientEnv.bind(I1ofC8, I1ofC9, C8, C9);
		System.out.println("-----------Generating MODEL-------------");
		Record.TransformToModelXML();
	}

	public static void pause(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}