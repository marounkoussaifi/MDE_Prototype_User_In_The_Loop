/*
 * Nom de classe : PopUpFr�quenceSondege
 *
 * Description   : permettre � la sonde de faire l�acquisition d�une mani�re p�riodique
 *
 * Version       : 2.0
 *
 * Date          : 11/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : Jaafar on 03/02/2017
 * Modified      : Sondes
 */

package sonde.composants;

import javax.swing.*;

import FacadeAdapter.IAcquisition;
import log.Interfaces.ILogComposant;
import sonde.services.INotification;

import java.awt.*;

public class PopUpPeriodicite extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JLabel labelPeriodicite;
	private JTextField fieldPeriodicite;
	private JButton btnOK;
	private int periodicite = 2000; // 2000ms par default
	
	public PopUpPeriodicite() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();

		labelPeriodicite = new JLabel("Periodicite (ms)");

		fieldPeriodicite = new JTextField(10);

		btnOK = new JButton("OK");

		btnOK.addActionListener(e -> {
			acquerirPeriodicite();
		});

		panel.add(labelPeriodicite);
		panel.add(fieldPeriodicite);
		panel.add(btnOK);

		Dimension dimension = panel.getPreferredSize();
		dimension.width = 300;
		dimension.height = 150;
		panel.setPreferredSize(dimension);

		frame.add(panel);
		frame.setLocation(dimension.width / 2 - frame.getWidth() / 2, dimension.height / 2 - frame.getHeight() / 2);

		frame.pack();
		frame.setVisible(true);
	}

	private void acquerirPeriodicite() {
		boolean parsable = true;
		int value = 0;
		try {
			value = Integer.parseInt(fieldPeriodicite.getText());
		} catch (NumberFormatException e) {
			parsable = false;
		}
		if (!parsable || value <= 0) {
			JOptionPane.showMessageDialog(frame, "Invalid input!");
		} else {
			frame.dispose();
			this.periodicite = value;
		}
	}

	public int getPeriodicite(int periodicite) {
		return this.periodicite;
	}
}
