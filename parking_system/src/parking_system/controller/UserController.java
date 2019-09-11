package parking_system.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

import parking_system.data.ReservationDAO;
import parking_system.data.UserDAO;
import parking_system.model.Reservation;
import parking_system.model.User;
import parking_system.model.UserErrorMsgs;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String editUserUsername=null;
	private String userRole = null;
	private String userStatus = null;
	private String selectedUserReservation = null;
	private String selectedReservationID = null;
    
	private void getUserParam (HttpServletRequest request, User user) {
		user.setUser(request.getParameter("username"),request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("email"), request.getParameter("password"), request.getParameter("role"),request.getParameter("utaid"),request.getParameter("phone"),request.getParameter("streetaddress"),request.getParameter("city"),request.getParameter("state"),request.getParameter("zipcode"),request.getParameter("vehiclenumber"),request.getParameter("status"),request.getParameter("permit"), request.getParameter("comments"));
	}
	
	private void getReservationParam(HttpServletRequest request, Reservation reservation) {
		reservation.setReservation(request.getParameter("username"), request.getParameter("reservationid"), request.getParameter("starttime"), request.getParameter("endtime"), request.getParameter("permit"), request.getParameter("parkingarea"), request.getParameter("floor"), request.getParameter("parkingspot"), request.getParameter("cancelled"), request.getParameter("resvdate"), request.getParameter("violation"), request.getParameter("vehiclenumber"), request.getParameter("cart"), request.getParameter("camera"), request.getParameter("history"), request.getParameter("payment"), request.getParameter("spotID"));		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		User user = new User();
		Reservation reservation = new Reservation();
		UserErrorMsgs userErrorMsgs = new UserErrorMsgs();

		if (action.equalsIgnoreCase("saveUser") ) {  
			getUserParam(request, user);
			user.validateUser(action, user, userErrorMsgs);
			session.setAttribute("user", user);
			if(!userErrorMsgs.getErrorMsg().equals("")){
				getUserParam(request, user);
				session.setAttribute("errorMsgs", userErrorMsgs);
				url="/formUser.jsp";
			}
			else{
				UserDAO.insertUser(user);
					session.invalidate();
					url="/index.jsp";
			}
			
		}
		
		else if (action.equalsIgnoreCase("loginUser")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			getUserParam(request, user);
			user.validateUser(action, user, userErrorMsgs);
			session.setAttribute("user", user);
			if(!userErrorMsgs.getErrorMsg().equals("")){
				session.setAttribute("errorMsgs", userErrorMsgs);
				url="/login.jsp";
			}
			else {
				user = UserDAO.loginUser(username, password);
				if (user!=null){
					session.setAttribute("greetingField1", "Welcome Back, " + user.getUsername());
					
					editUserUsername=user.getUsername();
					userRole=user.getRole();
					userStatus=user.getStatus();
					
					session.setAttribute("role", userRole);
					session.setAttribute("username", user.getUsername());
					session.setAttribute("status", user.getStatus());
					session.setAttribute("vehiclenumber", user.getVehiclenumber());
					session.setAttribute("permit", user.getPermit());
					
					System.out.println("user role: " + userRole);
					System.out.println("editUserUsername: " + editUserUsername);
					System.out.println("Set Role(param): "+ userRole);
					if(user.getRole().equals("USER"))
						url="/listUser.jsp";
					else if(user.getRole().equals("MANAGER"))
						url="/listManager.jsp";
					else
						url="/listAdmin.jsp";
				}
				else{
					System.out.println("userController: "+ user);
					session.removeAttribute("errorMsgs");
					session.setAttribute("greetingField", "User Not Found!");
					url="/login.jsp";
				}
			}
		}
		
		else if (action.equalsIgnoreCase("logoutUser")){
			session.invalidate();
			url="/login.jsp";
		}
		
		else if (action.equalsIgnoreCase("searchUser") ) {
				String searchString = request.getParameter("search");
				String searchFilter = request.getParameter("searchFilter");
				user.setSearch(searchString);
				user.setSearchfilter(searchFilter);
				System.out.println("Search: " + user.getSearch()+ " Filter: "+ user.getSearchfilter());
				user.validateUser(action, user, userErrorMsgs);
				ArrayList<User> UserInDB = new ArrayList<User>();
				if(!userErrorMsgs.getErrorMsg().equals("")){
					session.setAttribute("errorMsgs", userErrorMsgs);
					url="/searchUser.jsp";
				}
				else {
					if (searchFilter.equals("firstName")){
						UserInDB=UserDAO.searchUserwithFname(searchString);
					}
					else if(searchFilter.equals("lastName")){
						UserInDB=UserDAO.searchUserwithLname(searchString);
					}
					else{
						UserInDB=UserDAO.searchUserwithUid(searchString);
					}
					session.setAttribute("USERS", UserInDB);
					session.setAttribute("searchMsg", UserInDB.size() + " Search Results Found!");
					session.setAttribute("role", userRole);
					System.out.println("Search with Role: "+ userRole);
					session.removeAttribute("errorMsgs");
					url="/searchUserList.jsp";
				}
			}
		else if(action.equalsIgnoreCase("userEditProfile")){
			System.out.println("update: "+user.getUsername());
			User updateUser = new User();
			updateUser = UserDAO.getUserByUsername(editUserUsername); 
			session.setAttribute("UPDATEUSER", updateUser);
			if (userRole.equalsIgnoreCase("user"))
				url = "/updateUserProfile.jsp";
			else if (userRole.equalsIgnoreCase("manager"))
				url = "/updateManagerProfile.jsp";
			else
				url = "/updateAdminProfile.jsp";
		}
		else if(action.equalsIgnoreCase("managerEditUser")){
			String userSelected = request.getParameter("userSelected");
			editUserUsername = userSelected;
			//user.validateUser(action, user, userErrorMsgs);
			session.setAttribute("user", user);
			System.out.println("Selected User: "+userSelected);
			System.out.println("update: "+ user.getUsername());
			User updateUser = new User();
			updateUser = UserDAO.getUserByUsername(userSelected);
			session.setAttribute("UPDATEUSER", updateUser);
			if (userRole.equalsIgnoreCase("manager"))
				url = "/updateManagerProfile.jsp";
			else
				url = "/updateAdminProfile.jsp";
			//System.out.println(updateUser.getEmail());
		}
		
		else if (action.equalsIgnoreCase("updateUserInDB")){
			getUserParam(request, user);
			user.validateUser(action, user, userErrorMsgs);
			session.setAttribute("user", user);
			if(!userErrorMsgs.getErrorMsg().equals("")){
				getUserParam(request, user);
				session.setAttribute("errorMsgs", userErrorMsgs);
				/*if (userRole.equalsIgnoreCase("user"))
					url="/updateUserProfile.jsp";
				else */if (userRole.equalsIgnoreCase("manager"))
					url="/updateManagerProfile.jsp";
				else
					url="/updateAdminProfile.jsp";
			}
			else{
				UserDAO.updateUserDetails(user, editUserUsername);
				if (userRole.equalsIgnoreCase("user"))
					url = "/listUser.jsp";
				else if (userRole.equalsIgnoreCase("manager"))
					url = "/listManager.jsp";
				else
					url = "/listAdmin.jsp";
				System.out.println("update query");
			}
			
		}
		
		else if(action.equalsIgnoreCase("viewReservationList")){
			if (userRole.equalsIgnoreCase("user")){
				selectedUserReservation = editUserUsername;
			}
			else{
				selectedUserReservation = request.getParameter("userSelected");
			}			
			System.out.println("Reservations specific User selected: " + selectedUserReservation);
			//user.validateUser(action, user, userErrorMsgs);
			ArrayList<Reservation> ReservationInDB = new ArrayList<>();
			ReservationInDB =  ReservationDAO.searchReservationwithUsername(selectedUserReservation);
			session.setAttribute("RESERS", ReservationInDB);
			session.setAttribute("searchMsg", ReservationInDB.size() + " Reservations Found!");
			session.removeAttribute("errorMsgs");
			url="/userReservationList.jsp";
		}
		
		else if(action.equalsIgnoreCase("managerEditRevervation")){
			selectedReservationID = request.getParameter("reservationSelected");
			//user.validateUser(action, user, userErrorMsgs);
			session.setAttribute("user", user);
			System.out.println("Selected reservation: "+ selectedReservationID);
			Reservation updateReser = new Reservation();
			updateReser = ReservationDAO.getReservationByID(selectedReservationID);
			session.setAttribute("UPDATERESER", updateReser);
			url = "/updateReservation.jsp";
			//System.out.println(updateUser.getEmail());
		}
		
		else if (action.equalsIgnoreCase("updateReservationInDB")){
			getReservationParam(request, reservation);
			//session.setAttribute("UPDATERESER", reservation);
			System.out.println("Vehicle at param: " + request.getParameter("vehiclenumber")+ " & Resv Date(param): "+  request.getParameter("resvdate")+ " & ResvDate(obj) : "+reservation.getResvdate()+"Vehicle at obj: " + reservation.getVehiclenumber());
			ReservationDAO.updateReservationDetails(reservation, selectedReservationID);
			if (userRole.equalsIgnoreCase("user"))
				url = "/listUser.jsp";
			else if (userRole.equalsIgnoreCase("manager"))
				url = "/listManager.jsp";
			else
				url = "/listAdmin.jsp";
			System.out.println("update query");			
		} 
	
		// Mansee Delete Reservation
		else if(action.equalsIgnoreCase("managerDeleteRevervation")){
			String selectedReservationID = request.getParameter("reservationSelected");
			System.out.println("Reservation id: "+selectedReservationID);
			ReservationDAO.deleteReservationByManager(selectedReservationID);
			ReservationDAO.updateReservationSpotwithResID(selectedReservationID);;
			System.out.println("Deleted controller");
			url="/searchUser.jsp";
			
		}
		
		//new	
		else if(action.equalsIgnoreCase("searchForParkings") ) {  
		//	getParkingParam(request, parking);
			
			if(userStatus.equals(String.valueOf(0))) {
				System.out.println("Sorry"+userStatus);
				session.setAttribute("greetingField2", "Can not make reservation as your privilage has been revoked.");
				url= "/listUser.jsp";
			}
			else if (ReservationDAO.searchReservationwithUsername(session.getAttribute("username").toString()).size() >=3){
				System.out.println("Sorry: Number of Reservations exceeded");
				session.setAttribute("greetingField2", "Max Reservation Limit(3) achieved");
				url= "/listUser.jsp";
			}
			else {
				url="/searchParking.jsp";
			} 
			
		}
		//Akhsay
		else {
			session.setAttribute("statusField", (session.getAttribute("status").toString().equals("1") ? "Active" : "Revoked"));
			System.out.println("Status at home: " +session.getAttribute("status").toString());
			url = "/listUser.jsp";
			
		}		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}

}