package parking_system.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import parking_system.model.User;
import parking_system.util.SQLConnection;

public class UserDAO {
	
static SQLConnection DBMgr = SQLConnection.getInstance();
public static final int MYSQL_DUPLICATE_PK = 1062;
public static boolean isDuplicate = false;
	private static ArrayList<User> ReturnMatchingUserList (String queryString) {
		ArrayList<User> userListInDB = new ArrayList<User>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
	try {
		stmt = conn.createStatement();
		ResultSet userList = stmt.executeQuery(queryString);
		while (userList.next()) {
			User user = new User(); 
			user.setUsername(userList.getString("username"));
			user.setLastName(userList.getString("lastname"));
			user.setFirstName(userList.getString("firstname"));
			user.setUtaid(userList.getString("utaid"));
			user.setEmail(userList.getString("email"));  
			user.setPermit(userList.getString("permit"));
			user.setStatus(userList.getString("status"));
			userListInDB.add(user);	
		}
		conn.close();
		stmt.close();
	} catch (SQLException e) {
	}
	return userListInDB;
	}
		
	private static void StoreListinDB (User user,String queryString) {
		String result = "";
		Statement stmt = null;
		isDuplicate = false;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertUser = queryString + " VALUES ('"  
					+ user.getUsername() + "','"
					+ user.getFirstName() + "','"
					+ user.getLastName() + "','"
					+ user.getEmail() + "','"
					+ user.getPassword() + "','"
					+ user.getRole() + "','"
					+ user.getUtaid() + "','"
					+ user.getPhone() + "','"
					+ user.getStreetaddress() + "','"
					+ user.getCity() + "','"
					+ user.getState() + "','"
					+ user.getZipcode() + "','"
					+ user.getVehiclenumber() + "','"
					+ user.getStatus() + "','"
					+ user.getPermit() + "',"
					+ " SYSDATE())";
			stmt.executeUpdate(insertUser);
			conn.commit(); 
			System.out.println("Success: " +insertUser);
			conn.close();
			stmt.close();
		} catch (SQLException e) {
		} 
	}
	
	//unique username
	//list user
	public static Boolean uniqueUser(String userName) {  
		Statement stmt = null;   
		Connection conn = null;  
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String searchUser= "SELECT * FROM USER WHERE username='"+ userName +"' ORDER BY lastname";
			System.out.println(searchUser);
			ResultSet userList = stmt.executeQuery(searchUser);
			ArrayList<User> userListInDB = new ArrayList<>();
			while (userList.next()) {
				User user = new User(); 
				user.setUser(userList.getString("username"), userList.getString("firstname"), userList.getString("lastName"), userList.getString("email"), userList.getString("password"), userList.getString("role"), userList.getString("utaid"), userList.getString("phone"), userList.getString("streetaddress"), userList.getString("city"), userList.getString("state"), userList.getString("zipcode"), userList.getString("vehiclenumber"), userList.getString("status"), userList.getString("permit"), userList.getString("comments"));
				userListInDB.add(user);	 
			}
			//conn.close();
			//stmt.close();
			return (userListInDB.isEmpty());
		} catch (SQLException e) {
		}
		return false;
	}
			

	private static User getUser(String queryString){
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		User user = new User();
		System.out.println(queryString);
	try {
		stmt = conn.createStatement();
		ResultSet userList = stmt.executeQuery(queryString);
		while (userList.next()) { 
			user.setUser(userList.getString("username"), userList.getString("firstname"), userList.getString("lastName"), userList.getString("email"), userList.getString("password"), userList.getString("role"), userList.getString("utaid"), userList.getString("phone"), userList.getString("streetaddress"), userList.getString("city"), userList.getString("state"), userList.getString("zipcode"), userList.getString("vehiclenumber"), userList.getString("status"), userList.getString("permit"), userList.getString("comments"));
			System.out.println(user.getFirstName()+ " -> ROle= "+ user.getRole());
			return user;
		}
		conn.close();
		stmt.close();
	} catch (SQLException e) {
	}
	return null;
	}
	
	public static User getUserByUsername(String username){
		User user = null;
		
		Statement  statement = null;
		Connection con = SQLConnection.getDBConnection();
		try {
			
			statement = con.createStatement();
			String getUser = "SELECT * FROM USER WHERE username=" + "'"+username+"'"+ " ;";
			System.out.println(username);
			System.out.println(getUser);
			ResultSet result = statement.executeQuery(getUser);
			
			while(result.next()){
				user = new User();
				user.setFirstName(result.getString("firstname"));
				//System.out.println(result.getString("firstname"));
				user.setLastName(result.getString("lastname"));
				//System.out.println(result.getString("lastname"));
				user.setEmail(result.getString("email"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setPhone(result.getString("phone"));
				user.setRole(result.getString("role"));
				user.setUtaid(result.getString("utaid"));
				user.setStreetaddress(result.getString("streetaddress"));
				user.setCity(result.getString("city"));
				user.setState(result.getString("state"));
				user.setZipcode(result.getString("zipcode"));
				user.setPermit(result.getString("permit"));
				user.setVehiclenumber(result.getString("vehiclenumber"));
				user.setStatus(result.getString("status"));
				user.setPermit(result.getString("permit"));
				user.setComments(result.getString("comments"));
			}
		} catch (SQLException e) {
		}
		return user;
	}
	
	public static void updateUserDetails(User user, String username){
		String query = "UPDATE USER SET firstname='"+user.getFirstName()+"', lastname='"
						+user.getLastName()+"',  email='"+user.getEmail()+"', password='"
						+user.getPassword()+"', role='"+user.getRole()+"', utaid='"
						+user.getUtaid()+"', phone='"+user.getPhone()+"',  streetaddress='"
						+user.getStreetaddress()+"',  city='"+user.getCity()+"', state='"
						+user.getState()+"', zipcode="+user.getZipcode()+", vehiclenumber='"
						+user.getVehiclenumber()+"', status='"
						+user.getStatus()+"', permit='"+user.getPermit()+ "', comments='"+user.getComments()+"'"
						+ " WHERE username='"+username+"';";
		
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
	
	public static void insertUser(User user) {  
		StoreListinDB(user,"INSERT INTO USER (username,firstName,lastName,email,password,role,utaid,phone,streetaddress,city,state,zipcode,vehiclenumber,status,permit,date_in) ");
	}
	
	public static User loginUser(String username, String password){
		return getUser("SELECT * FROM USER WHERE username='"+username+"' and password='"+password+"'");
	}
	
	public static ArrayList<User>  searchUserwithLname(String lastname)  {  
		return ReturnMatchingUserList("SELECT * from User WHERE lastname LIKE '%"+lastname+"%'");
	}

	public static ArrayList<User>  searchUserwithFname(String firstname)  {  
		return ReturnMatchingUserList(" SELECT * from User WHERE firstname LIKE '%"+firstname+"%'");
	}
	
	public static ArrayList<User>  searchUserwithUid(String utaid)  {  
		return ReturnMatchingUserList(" SELECT * from User WHERE utaid LIKE '%"+utaid+"%'");
	}
	
}
