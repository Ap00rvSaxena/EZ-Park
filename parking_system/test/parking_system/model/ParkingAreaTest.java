package parking_system.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
public class ParkingAreaTest {

	ParkingArea parkingArea;
	ParkingAreaErrorMsgs parkingAreaErrorMsgs;
	
	
	@Before
	public void setUp() throws Exception {
		parkingArea = new ParkingArea();
		parkingAreaErrorMsgs= new ParkingAreaErrorMsgs();	
	}
	
	@Test
	@FileParameters("test/ParkingArea_testcases.csv")
	public void test(int testcaseNo, String action,String parking_area_name, String type, String floor, String capacity,String reserved,String available,String errorMsg,String ParkingAreaNameerrorMsg,String floorerrorMsg,String capacityerrorMsg,String reservederrorMsg,String availableerrorMsg) {
		parkingArea.setParkingArea(parking_area_name, type, floor, capacity, reserved, available);
		parkingArea.validateParkingArea(action, parkingArea, parkingAreaErrorMsgs);
		assertTrue(parkingArea.getType().equals(type));
		assertTrue(errorMsg.equals(parkingAreaErrorMsgs.getErrorMsg()));
		assertTrue(ParkingAreaNameerrorMsg.equals(parkingAreaErrorMsgs.getParkingAreaNameError()));
		assertTrue(floorerrorMsg.equals(parkingAreaErrorMsgs.getFloorError()));
		assertTrue(capacityerrorMsg.equals(parkingAreaErrorMsgs.getCapacityError()));
		assertTrue(reservederrorMsg.equals(parkingAreaErrorMsgs.getReservedErro()));
		assertTrue(availableerrorMsg.equals(parkingAreaErrorMsgs.getAvailableError()));
		}
}