package parking_system.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkingSpotTest {

	@Test
	public void testSetParkingSpotFromDB() {
		ParkingSpot pSpot = new ParkingSpot();
		pSpot.setParkingSpotFromDB("NH1FB1", 1, "Nedderman Hall", "BASIC", 1, "150", 1400, 1600, "xyz123");
		pSpot.setReserved(1);
		assertTrue(pSpot.getParkingSpotID().equals("NH1FB1"));
		assertTrue(pSpot.getParkingAreaName().equals("Nedderman Hall"));
		assertTrue(pSpot.getType().equals("BASIC"));
		assertTrue(pSpot.getAvailability().equals("150"));
		assertTrue(pSpot.getReservationid().equals("xyz123"));
		assertEquals(1, pSpot.getParkingspot());
		assertEquals(1, pSpot.getFloor());
		assertEquals(1, pSpot.getReserved());
		assertEquals(1400, pSpot.getStarttime());
		assertEquals(1600, pSpot.getEndtime());
	}

	@Test
	public void testSetParkingSpot() {
		ParkingSpot pSpot = new ParkingSpot();
		pSpot.setParkingSpot("Davis Hall", "ACCESS", 5, 150, 150);
		assertTrue(pSpot.getParkingAreaName().equals("Davis Hall"));
		assertTrue(pSpot.getType().equals("ACCESS"));
		assertEquals(5, pSpot.getFloor());
		assertEquals(150, pSpot.getCapacity());
		assertEquals(150, pSpot.getAvailable());
	}
}
