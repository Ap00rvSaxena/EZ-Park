package parking_system.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import parking_system.data.ParkingDao;
import parking_system.data.ReservationDAO;
import parking_system.data.UserDAO;
import parking_system.model.ReservationErrorMsgs;
import parking_system.model.ParkingSpot;
import parking_system.model.Reservation;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    public int currentDay = calendar.get(Calendar.DAY_OF_WEEK);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		Reservation reservation = new Reservation();
		ReservationErrorMsgs rErrorMsgs = new ReservationErrorMsgs();
		StringBuilder currTime = new StringBuilder(java.time.LocalTime.now().toString());
		currTime.delete(4, currTime.length()-1);
		currTime.deleteCharAt(2);
		
		if(action.equalsIgnoreCase("searchP")) {
			StringBuilder st = new StringBuilder(request.getParameter("starttime"));
			StringBuilder et = new StringBuilder(request.getParameter("endtime"));
			reservation.setCurrTime(currTime.toString());
			reservation.setStarttime(st.deleteCharAt(2).toString());
			reservation.setEndtime(et.deleteCharAt(2).toString());
			System.out.println("Starttime: " + st.toString()+" EndTime: "+ et.toString() + " Diff: " + (Integer.parseInt(et.toString())-Integer.parseInt(st.toString())));
			reservation.validateReservation(action, reservation, rErrorMsgs);
			if(!rErrorMsgs.getErrorMsg().equals("")){
				session.setAttribute("rErrorMsgs", rErrorMsgs);
				url="/searchParking.jsp";
			}
			else{
				session.removeAttribute("rErrorMsgs");
				ArrayList<ParkingSpot> parkingInDB = new ArrayList<>();
				parkingInDB = ParkingDao.getAvailableParking(st.toString(),et.toString());
				session.setAttribute("PARKINGS", parkingInDB);
				session.setAttribute("starttime", st.toString());
				session.setAttribute("endtime", et.toString());
				url="/listParking.jsp";
			}
		}
		else if(action.equalsIgnoreCase("finalPayment")) {
			System.out.println("in final payment");
			String radioBut = request.getParameter("select");
			String reservationDet[] = radioBut.split(",");
			
			session.setAttribute("parkingArea", reservationDet[0]);
			session.setAttribute("resPermit", reservationDet[1]);
			session.setAttribute("floor", reservationDet[2]);
			session.setAttribute("capacity", reservationDet[3]);
			session.setAttribute("avialable", reservationDet[4]);
			
			reservation.setParkingarea(reservationDet[0]);
			reservation.setPermit(reservationDet[1]);
			reservation.setFloor(reservationDet[2]);
			reservation.setUserPermit(session.getAttribute("permit").toString());
			reservation.setCurrTime(currTime.toString());
			reservation.validateReservation(action, reservation, rErrorMsgs);
			if(!rErrorMsgs.getErrorMsg().equals("")){
				session.setAttribute("rErrorMsgs", rErrorMsgs);
				url="/listParking.jsp";
			}
			else{
				session.removeAttribute("rErrorMsgs");
				String [] options = request.getParameterValues("optionsv");
				
				String finamount = reservation.calculatePayment(options, currentDay, session.getAttribute("endtime").toString());;
						
				System.out.println("Current Day: " + calendar.get(Calendar.DAY_OF_WEEK));
				System.out.println("ENdTime: " + session.getAttribute("endtime").toString());
				System.out.println("amount: $"+ (finamount) + " Cart: " + reservation.getCart() + " hist: " +reservation.getHistory()+ " Cam: " +reservation.getCamera());
				session.setAttribute("amount", "$ "+(finamount));
				session.setAttribute("cart", reservation.getCart());
				session.setAttribute("hist", reservation.getHistory());
				session.setAttribute("cam", reservation.getCamera());
				
				String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                    + "0123456789"
	                    + "abcdefghijklmnopqrstuvxyz"; 

				StringBuilder sb = new StringBuilder(); 
				
				for (int i = 0; i < 10; i++) { 
				
				int index = (int)(AlphaNumericString.length()* Math.random()); 
				
				sb.append(AlphaNumericString.charAt(index)); 
				} 																		
				
				int parkingSpot = Integer.parseInt(session.getAttribute("capacity").toString()) - Integer.parseInt(session.getAttribute("avialable").toString()) + 1 ;
				System.out.println("pspot: "+parkingSpot);
				
				String spotId = reservation.generateSpotID(session.getAttribute("parkingArea").toString(), session.getAttribute("floor").toString(), session.getAttribute("resPermit").toString(), parkingSpot);
				
				System.out.println("SpotID: " + spotId);
				
				List<String> list = new ArrayList<String>();
				
				list.add(session.getAttribute("username").toString()); //to be updated
				list.add(sb.toString());
				list.add(session.getAttribute("starttime").toString());
				list.add(session.getAttribute("endtime").toString());
				list.add(session.getAttribute("resPermit").toString());
				list.add(session.getAttribute("parkingArea").toString());
				list.add(session.getAttribute("floor").toString());
				list.add(String.valueOf(parkingSpot));
				list.add(String.valueOf(0));
				list.add("revdate");
				list.add("NULL");
				list.add(session.getAttribute("vehiclenumber").toString());
				list.add(session.getAttribute("cart").toString());
				list.add(session.getAttribute("cam").toString());
				list.add(session.getAttribute("hist").toString());
				list.add(String.valueOf(finamount));
				list.add(spotId);
				
				session.setAttribute("reservationdetails", list);
				url="/payment.jsp";
			}
		}
		
		else if(action.equalsIgnoreCase("EndPage")) {
			String cardNumber = request.getParameter("card");
			String cvv = request.getParameter("cvv");
			reservation.setCardNumber(cardNumber);
			reservation.setCvv(cvv);
			System.out.println("CN: " + cardNumber + " cvv: " + cvv);
			reservation.validateReservation(action, reservation, rErrorMsgs);
			if(!rErrorMsgs.getErrorMsg().equals("")){
				session.setAttribute("rErrorMsgs", rErrorMsgs);
				session.setAttribute("reservation", reservation);
				url="/payment.jsp";
			}
			else{
			List<String> ls = (List<String>) session.getAttribute("reservationdetails");
			
			Reservation reservation2 = new Reservation();
			reservation2.setReservation(ls.get(0), ls.get(1), ls.get(2), ls.get(3), ls.get(4), ls.get(5), ls.get(6), ls.get(7), ls.get(8), ls.get(9), ls.get(10), ls.get(11), ls.get(12), ls.get(13), ls.get(14), ls.get(15), ls.get(16));
			session.setAttribute("ref", ls.get(1));
			session.setAttribute("spotID", ls.get(16));
			ReservationDAO.insertReservation(reservation2);
			ReservationDAO.updateReservationSpot(ls.get(16),ls.get(2), ls.get(3),ls.get(1));
			url="/finalPage.jsp";
			}
		}
		
		else if(action.equalsIgnoreCase("searchSpot")) {
			
			String spotid = request.getParameter("spotId");
			System.out.println("spot id is "+spotid);
			ParkingSpot pspot = new ParkingSpot();
			pspot = ParkingDao.getParticularSpot(spotid);
			System.out.println("here :" + pspot);
			if(!pspot.getParkingAreaName().equals("")){
				session.removeAttribute("sPSErrMsg");
				session.setAttribute("PSPOT", pspot);
				url="/listParkingSpot.jsp";
			}
			else {
				session.setAttribute("sPSErrMsg", "No Parking Spot found");
				url="/searchParkingSpot.jsp";
			}
		}
		
		else {//if(action.equalsIgnoreCase("toggleSpot")) {
			
			String spotid = request.getParameter("pidtoggle");
			System.out.println("spot id to toggle is "+spotid);
			
			ParkingDao.deactivateSpot(spotid);
			
			url="/listManager.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
