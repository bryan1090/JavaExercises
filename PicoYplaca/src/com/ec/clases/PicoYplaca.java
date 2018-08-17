package com.ec.clases;

import javax.swing.JOptionPane;

public class PicoYplaca {

	public static void main(String[] args) {

		String licensePlateNumber = "";
		String dateString = "";
		String lastDigit = "";
		String time = "";
		Boolean restringedDay = false;
		Boolean restringedHour = false;

		ServiceVehicleVerification vehicle = new ServiceVehicleVerification();

		// license validation
		licensePlateNumber = JOptionPane.showInputDialog("Ingrese el número de placa. (Ej: PBP-2547)");

		while (!vehicle.isValidLicensePlateNumber(licensePlateNumber) && licensePlateNumber != null) {
			licensePlateNumber = JOptionPane
					.showInputDialog("¡Valor Incorrecto!. Vuelva a ingresar número de placa. (Ej: PBP-2547");
		}

		// date validation

		dateString = JOptionPane.showInputDialog("Ingrese la fecha. (Ej: 12/12/2018)");
		while (!vehicle.isValidDate(dateString) && dateString != null) {
			dateString = JOptionPane
					.showInputDialog("¡Valor Incorrecto!. Vuelva a ingresar la fecha. (Ej: 12/12/2018)");
		}

		// time validation
		time = JOptionPane.showInputDialog("Ingrese la hora. (Ej: 12:45)");
		while (!vehicle.isValidTime(time) && time != null) {
			time = JOptionPane.showInputDialog("¡Valor Incorrecto!. Vuelva a ingresar la hora. (Ej: 12:45)");
		}

		// day and time restriction check
		// >>day
		lastDigit = licensePlateNumber.substring(licensePlateNumber.length() - 1, licensePlateNumber.length());
		restringedDay = vehicle.checkDayRestriction(dateString, lastDigit);

		// >>time
		restringedHour= vehicle.checkTimeRestriction(time);

		if (restringedDay && restringedHour) {
			JOptionPane.showMessageDialog(null, "Forbidden to transit");
		} else if (!restringedDay && !restringedHour) {
			JOptionPane.showMessageDialog(null, "¡Allowed to transit! =)");
		}else {
			JOptionPane.showMessageDialog(null, "¡Allowed to transit! =)");
		}

	}

}
