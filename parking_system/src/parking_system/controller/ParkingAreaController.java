package parking_system.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import parking_system.data.ParkigAreaDAO;
import parking_system.model.ParkingArea;
import parking_system.model.ParkingAreaErrorMsgs;
/**
 * Servlet implementation class ParkingAreaController
 */
@WebServlet("/ParkingAreaController")
public class ParkingAreaController extends HttpServlet {
private static final long serialVersionUID = 1L;

String parkingareaname=null;



    
	private void getParkinAreaParam (HttpServletRequest request, ParkingArea parkingArea) {
		parkingArea.setParkingArea(request.getParameter("parking_area_name"),request.getParameter("type"),request.getParameter("floor"),request.getParameter("capacity"),request.getParameter("reserved"),request.getParameter("available"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
	
		ParkingArea parkingArea=new ParkingArea();
		ParkingArea parkingArea2=new ParkingArea();
		ParkingAreaErrorMsgs parkingAreaErrorMsgs= new ParkingAreaErrorMsgs();
		
		if (action.equalsIgnoreCase("saveParkingArea") ) { 
			System.out.println("Here: " + parkingAreaErrorMsgs.getParkingAreaNameError() );
			getParkinAreaParam(request, parkingArea);
			parkingArea.validateParkingArea(action, parkingArea, parkingAreaErrorMsgs);
			session.setAttribute("parkingArea", parkingArea);
			
			if(!parkingAreaErrorMsgs.getErrorMsg().equals("")){
				getParkinAreaParam(request, parkingArea);
				session.setAttribute("errorMsgs", parkingAreaErrorMsgs);
				url="/addParkingArea.jsp";
			}
			else{
				ParkigAreaDAO.insertParkingArea(parkingArea);		
				url="/listManager.jsp";
			}


		}

		else if (action.equalsIgnoreCase("searchParkingArea") ) {
			ArrayList<ParkingArea> parkingAreaInDB = new ArrayList<ParkingArea>();
			parkingAreaInDB=ParkigAreaDAO.searchParkingArea();
			session.setAttribute("ParkingArea", parkingAreaInDB);
			session.setAttribute("searchMsg", parkingAreaInDB.size() + " Search Results Found!");
			System.out.println(parkingAreaInDB.size());
			url="/SearchParkingAreaList.jsp";
		}

		
		
		else if(action.equalsIgnoreCase("EditParkingArea")){
			
			System.out.println("update: ");
			
			String radioBut = request.getParameter("select");
			String parking[] = radioBut.split(",");
			
			session.setAttribute("parking_area_name", parking[0]);
			session.setAttribute("type", parking[1]);
			session.setAttribute("floor", parking[2].toString());
			session.setAttribute("capacity", parking[3].toString());
			session.setAttribute("available", parking[4].toString());
			
			ParkingArea park = new ParkingArea();
			
			park.setParking_area_name(parking[0]);
			park.setType(parking[1]);
			park.setfloor(parking[2].toString());
			park.setCapacity(parking[3].toString());
			park.setAvailable(parking[4].toString());
			System.out.println("update: ");
			
			ParkingArea updateParkingArea = new ParkingArea();
				
			updateParkingArea = ParkigAreaDAO.getParkingArea(park); 
					session.setAttribute("UPDATEParkingArea", updateParkingArea);
			//		if (userRole.equalsIgnoreCase("manager"))
						url = "/updateParkingArea.jsp";	
				//}


			}
		else {//if (action.equalsIgnoreCase("updateParkingAreaInDB")){
			
			getParkinAreaParam(request, parkingArea2);
			
		//	System.out.println(request.getParameter("parking_area_Name"));
			
			parkingArea.validateParkingArea(action, parkingArea2, parkingAreaErrorMsgs);
			session.setAttribute("parkingArea", parkingArea2);
			
		//	System.out.println("This is my testing capacitty"+parkingArea2.getParking_area_name());
			
		
			if(!parkingAreaErrorMsgs.getErrorMsg().equals("")){
				getParkinAreaParam(request, parkingArea);
				session.setAttribute("errorMsgs", parkingAreaErrorMsgs);
				url="/updateParkingArea.jsp";
			}
			else
			{
				ParkigAreaDAO.updateParkingAreaDetails(parkingArea2);	
				url = "/listManager.jsp";
				System.out.println("update query");
			}
		}
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
				
		}
		
				
	}


