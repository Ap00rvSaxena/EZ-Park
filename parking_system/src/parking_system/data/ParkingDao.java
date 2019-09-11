package parking_system.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import parking_system.model.ParkingDetails;
import parking_system.model.ParkingSpot;
import parking_system.model.User;
import parking_system.util.SQLConnection;

public class ParkingDao {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();

	public static ArrayList<ParkingSpot> getAnyParking(String queryString){
		ArrayList<ParkingSpot> parkingListInDB = new ArrayList<>();
		System.out.println("Search Parking Query: " + queryString);
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		System.out.println(queryString);
	try {
		stmt = conn.createStatement();
		ResultSet parkinglist = stmt.executeQuery(queryString);
		while (parkinglist.next()) { 
			ParkingSpot parkingSpot = new ParkingSpot();
			parkingSpot.setParkingSpot(parkinglist.getString("Parking_Area_Name"), parkinglist.getString("Parking_Type"), Integer.parseInt(parkinglist.getString("Floors")), Integer.parseInt(parkinglist.getString("capacity")), Integer.parseInt(parkinglist.getString("available")));
			parkingListInDB.add(parkingSpot);
		}
		conn.close();
		stmt.close();
	} catch (SQLException e) {
	}
	return parkingListInDB;
	}
	
	public static ParkingSpot getParticularSpot(String spotid) {
		ParkingSpot spotdetails = null;
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		String query = "SELECT * FROM PARKINGSPOT_DETAILS WHERE ParkingspotID = '"+spotid+"'";
		System.out.println(query);
		
		try {
			stmt = conn.createStatement();
			ResultSet pspot = stmt.executeQuery(query);
			System.out.println("In here: " + pspot);
			spotdetails = new ParkingSpot();
			while (pspot.next()) { 
				spotdetails.setParkingSpotFromDB(pspot.getString("ParkingspotID"), pspot.getInt("Parkingspot"), pspot.getString("Parking_Area_Name"), pspot.getString("Parking_Type"), pspot.getInt("Floors"), pspot.getString("Availability"), pspot.getInt("starttime"), pspot.getInt("endtime"), pspot.getString("reservationid"));
			}
			conn.close();
			stmt.close();
		} catch (SQLException e) {
		}		
		return spotdetails;
}


	public static void deactivateSpot(String spotid) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		boolean flag = false;
		System.out.println(spotid);
		String unavailable = "UNAVAILABLE";
		String query = "UPDATE PARKINGSPOT_DETAILS SET Availability = '"+unavailable+"' WHERE ParkingspotID = '"+ spotid+"'";
		System.out.println(query);
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.commit();
			conn.close();
			stmt.close();
			System.out.println("executed");
		} catch (SQLException e) {
		}	
	}
	
	public static ArrayList<ParkingSpot> getAvailableParking(String startTime, String endTime){
		return getAnyParking("select Parking_Area_Name, Parking_Type, Floors, count(*) as capacity, count(CASE WHEN (Availability != 'UNAVAILABLE' AND (endtime <="+ startTime +" OR "+ endTime +" <= starttime)) THEN 1 END) as available from parkingspot_details group by Parking_Area_Name,  Parking_Type, Floors");
		//SELECT * FROM PARKING_DETAILS WHERE available > 0 
	}
}
