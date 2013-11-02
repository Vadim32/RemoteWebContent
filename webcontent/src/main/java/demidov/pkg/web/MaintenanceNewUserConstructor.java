package demidov.pkg.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import demidov.pkg.domain.ComputerMaintenanceEvent;
import demidov.pkg.domain.TheUser;
import demidov.pkg.domain.UserEvents;
import demidov.pkg.utils.DateChangerUtils;

public class MaintenanceNewUserConstructor {
	 
		
	public TheUser newUserConstructor(HttpServletRequest request, List<UserEvents> userEventsList) {
		
			
		TheUser user = new TheUser(); //User entity will be saved when user made order 
			user.setSessionUserId(request.getParameter("userSessionId"));
			user.setUserFirstName(request.getParameter("first_name"));
			user.setUserLastName(request.getParameter("last_name"));
			user.setUserEmale(request.getParameter("e_male"));
			user.setPersonAddress(request.getParameter("address"));
			user.setPersonPhoneNumber(request.getParameter("phone_number"));
			user.setUserEventsList(userEventsList);
						
			return user;	
		}
	
	
	public UserEvents newMaintenanceEventConstructor(HttpServletRequest request, TheUser user) {
			
		ComputerMaintenanceEvent maintenanceEvent = new ComputerMaintenanceEvent();
			try { 
				maintenanceEvent.setUserEventDate(DateChangerUtils.dateConvertation(request.getParameter("user_event_date"))); 
				} catch (ParseException e) { 
					e.printStackTrace(); 
					}
			maintenanceEvent.setUserOrderDate(new Date());
			maintenanceEvent.setDescriptionMaintenance(request.getParameter("description"));
			maintenanceEvent.setAdditionalInfoMaintenance(request.getParameter("additional_info"));
			maintenanceEvent.setTheUser(user);
			
			return maintenanceEvent;
		}
			
	}