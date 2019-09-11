package parking_system.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkingDetailsTest {

	@Test
	public void testSetParking() {
		ParkingDetails pDetails = new ParkingDetails();
		pDetails.setParking("Davis Hall", "BASIC", 1, 150, 1, 149);
		assertTrue(pDetails.getParkingAreaName().equals("Davis Hall"));
		assertTrue(pDetails.getType().equals("BASIC"));
		assertEquals(1, pDetails.getFloor());
		assertEquals(150, pDetails.getCapacity());
		assertEquals(1, pDetails.getReserved());
		assertEquals(149, pDetails.getAvailable());
	}

}
