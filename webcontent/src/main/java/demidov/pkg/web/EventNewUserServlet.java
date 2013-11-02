package demidov.pkg.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import demidov.pkg.domain.TheUser;
import demidov.pkg.domain.UserEvents;
import demidov.pkg.persistence.WebContentDAOIF;


/**
 * Servlet implementation class EventNewUserServlet
 */
public class EventNewUserServlet extends HttpServlet {
	
	
	//-------------------------Variables------------------------
	
		private static final long serialVersionUID = 1L;
	       
		protected WebContentDAOIF webContentDAOIF;
	
		
	//-------------------------Servlet methods------------------  
	
	 public void init() {
    	 /*Getting bean from spring ContextLoaderListener and inject it to webContentDAOIF variable 
    	   to use webContentDAOIF in this servlet*/
    	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    	 	webContentDAOIF = context.getBean("webContentDAOImpl", WebContentDAOIF.class);
    	}
	
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
			
			List<UserEvents> userEventsList = new ArrayList<UserEvents>(2); //This list store all user orders 
		
						
			if(!request.getParameter("event_type").isEmpty()  
				&& 
				request.getParameter("event_type").equals("Software Development Event")) {
							
						System.out.println();
				
				} else if(!request.getParameter("event_type").isEmpty() 
						   && 
						   request.getParameter("event_type").equals("Computer Maintenance Event"))  {
				
					 MaintenanceNewUserConstructor computerMaintenanceNewUser  = new MaintenanceNewUserConstructor();
					 	TheUser user = computerMaintenanceNewUser.newUserConstructor(request, userEventsList);
					 		userEventsList.add(computerMaintenanceNewUser.newMaintenanceEventConstructor(request, user));
								
							   webContentDAOIF.saveUser(user);
								
				 	} else {
						 	System.out.println();
				 			}
		}
}