package com.ec.clases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class PicoYplacaTest {

	@Test
	void testLicenseType1() {
		ServiceVehicleVerification vehicle=new ServiceVehicleVerification();
		boolean result=vehicle.isValidLicensePlateNumber("pbp-1222");
		assertEquals(true, result);
		
	}

	@Test
	void testLicenseType2() {
		ServiceVehicleVerification vehicle=new ServiceVehicleVerification();
		boolean result=vehicle.isValidLicensePlateNumber("pb-1222");
		assertEquals(true, result);
	}
	
	@Test
	void testDate() {
		ServiceVehicleVerification vehicle=new ServiceVehicleVerification();
		boolean result=vehicle.isValidDate("31/12/2018"); 
		assertEquals(true, result);
	}
	
	@Test
	void testTime() {
		ServiceVehicleVerification vehicle=new ServiceVehicleVerification();
		boolean result=vehicle.isValidTime("1:59"); 
		assertEquals(true, result);
	}
	
	@Test
	void testDayRestriction() {
		ServiceVehicleVerification vehicle=new ServiceVehicleVerification();
		boolean result=vehicle.checkDayRestriction("14/08/2018","3"); 
		assertEquals(true, result);
	}
	
	@Test
	void testTimeRestriction() {
		ServiceVehicleVerification vehicle=new ServiceVehicleVerification();
		boolean result=vehicle.checkTimeRestriction("7:20"); 
		assertEquals(true, result);
	}
	
	
	
	@Test
	void testConversionStringToCalendar() {
		ServiceVehicleVerification vehicle=new ServiceVehicleVerification();
		Calendar cal=Calendar.getInstance();
		cal=vehicle.stringToCalendar("15/08/2018"); 
		assertEquals(15,cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(7,cal.get(Calendar.MONTH));
		assertEquals(2018,cal.get(Calendar.YEAR));
	}
}
