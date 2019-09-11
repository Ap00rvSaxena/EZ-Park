package parking_system.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import parking_system.model.Reservation;
import parking_system.model.User;
import parking_system.util.SQLConnection;

public class ReservationDAO {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<Reservation> ReturnMatchingReservationList (String queryString) {
		ArrayList<Reservation> reservationListInDB = new ArrayList<>();
		
			Statement stmt = null;
			Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet reservationList = stmt.executeQuery(queryString);
			while (reservationList.next()) {
				Reservation reservation = new Reservation();
				reservation.setReservation(reservationList.getString("username"), reservationList.getString("reservationid"), reservationList.getString("starttime"), reservationList.getString("endtime"), reservationList.getString("permit"), reservationList.getString("parkingarea"), reservationList.getString("floor"), reservationList.getString("parkingspot"), reservationList.getString("cancelled"), reservationList.getString("resvdate"), reservationList.getString("violation"), reservationList.getString("vehiclenumber"), reservationList.getString("cart"), reservationList.getString("camera"), reservationList.getString("history"), reservationList.getString("payment"), reservationList.getString("spotID"));
				reservationListInDB.add(reservation);	
			}
			conn.close();
			stmt.close();
		} catch (SQLException e) {
		}
		return reservationListInDB;
	}
	
	public static Reservation getReservationByID(String reservationID){
		Reservation reservation = null;
		
		Statement  statement = null;
		Connection con = SQLConnection.getDBConnection();
		try {
			
			statement = con.createStatement();
			String getReservation = "SELECT * FROM reservation WHERE reservationid=" + "'"+reservationID+"'"+ " ;";
			System.out.println(reservationID);
			System.out.println(getReservation);
			ResultSet result = statement.executeQuery(getReservation);
			while(result.next()){
				reservation = new Reservation();
				reservation.setReservation(result.getString("username"), result.getString("reservationid"), result.getString("starttime"), result.getString("endtime"), result.getString("permit"), result.getString("parkingarea"), result.getString("floor"), result.getString("parkingspot"), result.getString("cancelled"), result.getString("resvdate"), result.getString("violation"), result.getString("vehiclenumber"), result.getString("cart"), result.getString("camera"), result.getString("history"), result.getString("payment"), result.getString("spotID"));
			}
			con.close();
			statement.close();
		} catch (SQLException e) {
		}
		return reservation;
	}
	
	private static void updateReservationinDB(String query) {
		Statement stmnt = null;
		Connection con =SQLConnection.getDBConnection();
		System.out.println(query);
		try {
			stmnt=con.createStatement();
			stmnt.executeUpdate(query);
			con.commit();
			System.out.println("Start End Time updatedin ReservationSpot");
			con.close();
			stmnt.close();
		} catch (SQLException e) {
		}
	}
	
	public static void updateReservationDetails(Reservation reservation, String reservationID){
		String query = "UPDATE RESERVATION SET cancelled='"+reservation.getCancelled()+"', violation='"
						+reservation.getViolation()+"',  vehiclenumber='"+reservation.getVehiclenumber()
						+"', history='"+reservation.getHistory()+"', cart='"+reservation.getCart()
						+"', camera='"+reservation.getCamera()+"'"
						+ " WHERE reservationid='"+reservationID+"';";
		
		Statement stmnt = null;
		Connection con =SQLConnection.getDBConnection();
		System.out.println(query);
		try {
			stmnt=con.createStatement();
			stmnt.executeUpdate(query);
			con.commit();
			System.out.println("updated");
		} catch (SQLException e) {
		}
	}
	
	private static void StoreReservationinDB (Reservation reservation,String queryString) {
		String result = "";
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertReservation = queryString + " VALUES ('"  
					+ reservation.getReservationid() + "','"
					+ reservation.getUsername() + "','"
					+ reservation.getSpotID() + "',"
					+ reservation.getStarttime() + ","
					+ reservation.getEndtime() + ",'"
					+ reservation.getPermit() + "','"
					+ reservation.getParkingarea() + "',"
					+ Integer.parseInt(reservation.getFloor()) + ","
					+ Integer.parseInt(reservation.getParkingspot()) + ","
					+ Integer.parseInt(reservation.getCancelled()) + ","
					+ " SYSDATE()" + ","
					+ reservation.getViolation() + ",'"
					+ reservation.getVehiclenumber() + "',"
					+ Integer.parseInt(reservation.getHistory()) + ","
					+ Integer.parseInt(reservation.getCart()) + ","
					+ Integer.parseInt(reservation.getCamera()) + ",'"
					+ reservation.getPayment() + "')";
			System.out.println(insertReservation);
			stmt.executeUpdate(insertReservation);
			conn.commit(); 
			System.out.println("Success: " +insertReservation);
			conn.close();
			stmt.close();
		} catch (SQLException e) {
		}
	}
	
	//Mansee
	public static void deleteReservationByManager(String reservationID){
		String query = "DELETE FROM reservation WHERE reservationid='"+reservationID+"';";
		Statement smnt = null;
		Connection conn = SQLConnection.getDBConnection();
		System.out.println(query);
		try {
			smnt = conn.createStatement();
			smnt.executeUpdate(query);
			conn.commit();
			System.out.println("Deleted");
		} catch (SQLException e) {
		}	
	}
	
	public static void insertReservation(Reservation reservation) {  
		StoreReservationinDB(reservation,"INSERT INTO RESERVATION (reservationid,username,spotID, starttime,endtime,permit,parkingarea,floor,parkingspot,cancelled,resvdate,violation,vehiclenumber,history,cart,camera,payment) ");
	}
	
	public static ArrayList<Reservation>  searchReservationwithUsername(String username)  {  
		return ReturnMatchingReservationList(" SELECT * from reservation WHERE username = '"+username+"'");
	}

	public static void updateReservationSpot(String spotID, String startTime, String endTime, String resvID) {
		updateReservationinDB("UPDATE parkingspot_details SET Availability = 'BOOKED', starttime = "+startTime+", endtime = "+ endTime+" , reservationid = '"+resvID+"' WHERE ParkingspotID = '"+ spotID+"'");
	}

	public static void updateReservationSpotwithResID(String selectedReservationID) {
		updateReservationinDB("UPDATE parkingspot_details SET Availability = 'AVAILABLE', starttime = "+0+", endtime = "+ 0+" , reservationid = 'NULL' WHERE reservationid = '"+ selectedReservationID+"'");
	}
}
