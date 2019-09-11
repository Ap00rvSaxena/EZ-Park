package parking_system.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import parking_system.model.ParkingArea;
import parking_system.model.User;
import parking_system.util.SQLConnection;

public class ParkigAreaDAO {
	
static SQLConnection DBMgr = SQLConnection.getInstance();
public static final int MYSQL_DUPLICATE_PK = 1062;
public static boolean isDuplicate = false;
	
private static ArrayList<ParkingArea> ReturnMatchingParkingAreaList (String queryString) {
	
	ArrayList<ParkingArea> parkingAreaListInDB = new ArrayList<ParkingArea>();

	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();  


	try {
		stmt = conn.createStatement();
		ResultSet parkingAreaList = stmt.executeQuery(queryString);
		while (parkingAreaList.next()) {
			ParkingArea parkingArea = new ParkingArea(); 
			parkingArea.setParking_area_name(parkingAreaList.getString("Parking_area_name"));
			parkingArea.setType(parkingAreaList.getString("type"));
			parkingArea.setfloor(parkingAreaList.getString("floor"));
			parkingArea.setCapacity(parkingAreaList.getString("capacity"));
			parkingArea.setReserved(parkingAreaList.getString("reserved"));
			parkingArea.setAvailable(parkingAreaList.getString("available"));
			//System.out.println(user.getCompany_name()+" "+company.getIdcompany());
			parkingAreaListInDB.add(parkingArea);	
			
		}
		conn.close();
		stmt.close();
	} catch (SQLException e) {
	}
	return parkingAreaListInDB;
}

public static ParkingArea getParkingArea( ParkingArea park){
	//User user = null;
	ParkingArea parkingArea= null;
	
	Statement  statement = null;
	Connection con = SQLConnection.getDBConnection();
	try {
		
		statement = con.createStatement();
		String getParkingArea = "SELECT * FROM parking_details WHERE parking_area_name=" + "'"+park.getParking_area_name()+"'AND "+ "type=" + "'"+park.getType()+"'AND "+
				"floor=" + "'"+park.getfloor()+"'AND "+"capacity=" + "'"+park.getCapacity()+"'AND "+"available=" + "'"+park.getAvailable()+"';";
		System.out.println(park.getParking_area_name());
		System.out.println(getParkingArea);
		ResultSet result = statement.executeQuery(getParkingArea);
		
		while(result.next()){
			parkingArea = new ParkingArea();
			parkingArea.setParking_area_name(result.getString("parking_area_name"));
			
			System.out.println(result.getString("parking_area_name"));
			
			parkingArea.setType(result.getString("type"));
			parkingArea.setfloor(result.getString("floor"));
			
			parkingArea.setCapacity(result.getString("capacity"));
			
			parkingArea.setReserved(result.getString("reserved"));
			
			parkingArea.setAvailable(result.getString("available"));
		
			
		}
	} catch (SQLException e) {
	}
	return parkingArea;
}

public static void updateParkingAreaDetails(ParkingArea parkingArea){
	
	
	
	
	String query = "UPDATE Parking_details SET parking_area_name='"+parkingArea.getParking_area_name()+"', type='"
					+parkingArea.getType()+"',  floor='"+parkingArea.getfloor()+"', capacity='"
					+parkingArea.getCapacity()+"', reserved='"+parkingArea.getReserved()+"', available='"
					+parkingArea.getAvailable()+"'"
					+" WHERE parking_area_name=" + "'"+parkingArea.getParking_area_name()+"' AND "+ "type=" + "'"+parkingArea.getType()+"' AND "+
					"floor=" + "'"+parkingArea.getfloor()+"';";
	
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




private static void StoreListinDB (ParkingArea parkingArea,String queryString) {
	String result = "";
	Statement stmt = null;
	isDuplicate = false;
	Connection conn = SQLConnection.getDBConnection();  

	try {

		stmt = conn.createStatement();

		String insertParkingArea = queryString + " VALUES ('"  
				+ parkingArea.getParking_area_name() + "','"
				+ parkingArea.getType() + "','"
				+ parkingArea.getfloor() + "','"
				+ parkingArea.getCapacity() + "','"
				+ '0'+ "','"
				+ parkingArea.getCapacity() + "')"
				;

		System.out.println(insertParkingArea);

		stmt.executeUpdate(insertParkingArea);

		conn.commit(); 

		System.out.println("Success: " +insertParkingArea);
		conn.close();
		stmt.close();
	} catch (SQLException e) {
	}
}

	public static void insertParkingArea(ParkingArea parkingArea) {  
	
		StoreListinDB(parkingArea,"INSERT INTO PARKING_DETAILS (parking_area_name,type,floor,capacity,reserved,available) ");
	}
	
	public static ArrayList<ParkingArea>  searchParkingArea()  {  
		
		return ReturnMatchingParkingAreaList(" SELECT * from parking_details");
	}
}
