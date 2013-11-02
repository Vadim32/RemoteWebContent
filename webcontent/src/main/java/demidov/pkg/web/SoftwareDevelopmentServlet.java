package demidov.pkg.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demidov.pkg.domain.SoftwareDevelopmentEvent;
import demidov.pkg.domain.TheUser;
import demidov.pkg.domain.UserEvents;
import demidov.pkg.utils.DateChangerUtils;

public class SoftwareDevelopmentServlet extends EventNewUserServlet {

	
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("This is Software Development Event");
	
		List<UserEvents> userEventsList = new ArrayList<UserEvents>(2); //This list store all user orders 
		
		
		TheUser user = new TheUser(); //User entity will be saved when user made order 
			user.setSessionUserId(request.getParameter("userSessionId"));
			user.setUserFirstName(request.getParameter("first_name"));
			user.setUserLastName(request.getParameter("last_name"));
			user.setUserEmale(request.getParameter("e_male"));
			user.setPersonAddress(request.getParameter("address"));
			user.setPersonPhoneNumber(request.getParameter("phone_number"));
						
		SoftwareDevelopmentEvent developmentEvent = new SoftwareDevelopmentEvent();
			   try {
				   developmentEvent.setUserEventDate(DateChangerUtils.dateConvertation(request.getParameter("user_event_date")));
						} catch (ParseException e) {
								e.printStackTrace();
							}
			developmentEvent.setUserOrderDate(new Date());
			developmentEvent.setDescriptionDevelopment(request.getParameter("description"));
			developmentEvent.setAdditionalInfoDevelopment(request.getParameter("additional_info"));
			userEventsList.add(developmentEvent);
									
			user.setUserEventsList(userEventsList);
			
			developmentEvent.setTheUser(user);
			
			
			webContentDAOIF.saveUser(user);			
		
	}
	
}