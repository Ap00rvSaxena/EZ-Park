package parking_system.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ReservationTest {
	
	Reservation resv;
	ReservationErrorMsgs RerrMsgs;

	@Before
	public void setUp() throws Exception {
		resv = new Reservation();
		RerrMsgs = new ReservationErrorMsgs();
	}

	@Test
	@FileParameters("test/Reservation_test_cases.csv")
	public void test(int testcaseNo, String action, String currTime, String starttime, String endtime, String userPermit, 
			String resPermit, String cardNumber, String	cvvNumber, String parkingArea, String floor, String history, String cart, String cam, String currentDay, String errorMsg, String timeError, 
			String permitError, String cardNumberError, String cvvError, String spotid, String payment) {
		List<String> options = new ArrayList<>();
		if (history.equals("1"))
			options.add("hist");
		if (cam.equals("1"))
			options.add("cam");
		if (cart.equals("1"))
			options.add("cart");
		//System.out.println("Option Array: " + Arrays.toString(options.toArray(new String[0])));
		resv.setReservation("", "", starttime, endtime, resPermit, "", "", "", "", "", "",  "", "", "",  "", "", "");
		resv.setUserPermit(userPermit);
		resv.setCardNumber(cardNumber);
		resv.setCvv(cvvNumber);
		resv.setCurrTime(currTime);
		resv.validateReservation(action, resv, RerrMsgs);
		assertTrue(resv.getCart().equals(""));
		assertTrue(resv.getCamera().equals(""));
		assertTrue(resv.getHistory().equals(""));
		assertTrue(spotid.equals(resv.generateSpotID(parkingArea, floor, resPermit, 1)));
		assertEquals(Double.parseDouble(payment), Double.parseDouble(resv.calculatePayment(options.toArray(new String[0]), Integer.parseInt(currentDay), endtime)), 0.01);
		assertTrue(resv.getUsername().equals(""));
		assertTrue(resv.getReservationid().equals(""));
		assertTrue(resv.getParkingarea().equals(""));
		assertTrue(resv.getFloor().equals(""));
		assertTrue(resv.getParkingspot().equals(""));
		assertTrue(resv.getCancelled().equals(""));
		assertTrue(resv.getResvdate().equals(""));
		assertTrue(resv.getViolation().equals(""));
		assertTrue(resv.getVehiclenumber().equals(""));
		assertTrue(resv.getSpotID().equals(""));
		assertTrue(resv.getPayment().equals(""));
		assertTrue(resv.getCart().equals(cart));
		assertTrue(resv.getCamera().equals(cam));
		assertTrue(resv.getHistory().equals(history));
		assertTrue(errorMsg.equals(RerrMsgs.getErrorMsg()));
		assertTrue(timeError.equals(RerrMsgs.getTimeError()));
		assertTrue(permitError.equals(RerrMsgs.getPermitError()));
		assertTrue(cardNumberError.equals(RerrMsgs.getCardNumberError()));
		assertTrue(cvvError.equals(RerrMsgs.getCvvError()));
	}

}
