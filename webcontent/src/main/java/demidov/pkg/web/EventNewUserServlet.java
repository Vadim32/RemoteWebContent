package demidov.pkg.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
	       
		private WebContentDAOIF webContentDAOIF;
	
		
	//-------------------------Servlet methods------------------  
	
	 public void init() {
	    	
    	 /*Getting bean from spring ContextLoaderListener and inject it to webContentDAOIF variable 
    	   to use webContentDAOIF in this servlet*/
    	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    	 	webContentDAOIF = context.getBean("webContentDAOImpl", WebContentDAOIF.class);
    	}
	
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		TheUser user = new TheUser();
			user.setSessionUserId(request.getParameter("userSessionId"));
			user.setUserFirstName(request.getParameter("first_name"));
			user.setUserLastName(request.getParameter("last_name"));
			user.setUserEmale(request.getParameter("e_male"));
			user.setPersonAddress(request.getParameter("address"));
			user.setPersonPhoneNumber(request.getParameter("phone_number"));
		
		UserEvents event;
				
			webContentDAOIF.saveUser(user);
		
	}

}