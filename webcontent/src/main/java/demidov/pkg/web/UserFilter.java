package demidov.pkg.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demidov.pkg.persistence.WebContentDAOIF;

public class UserFilter implements Filter {

	//-------------------------Variables------------------------
	
	private final String ANONIM_USER_NAME = "Anonym";	//Default name if new user or did not registered  
	
	private WebContentDAOIF webContentDAOIF;
				
		public void setWebContentDAOIF(WebContentDAOIF webContentDAOIF) {
			this.webContentDAOIF = webContentDAOIF;
		}
 
		
	//-------------------------Filter methods-------------------
	
		@Override
		public void init(FilterConfig arg0) throws ServletException {
				//Nothing to do
			}
			
		
		
		/*This method takes forwardPath wrap this argument and use forward(..) to forward to resource on server 
	      from this particular servlet
	      
	      @param request - object that represents the request the client makes of the servlet
		  @param response -object that represents the response the servlet returns to the client
	      */ 
	    private void forwardUserRequests(ServletRequest request, ServletResponse response, String forwardPath) 
	    																				throws ServletException, IOException {
	    	
	    		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
					dispatcher.forward(request, response);
	    	}
		
		

		@Override
		public void doFilter(ServletRequest request, ServletResponse response,
													 FilterChain filterChain) throws IOException, ServletException {
			
				
				List<String> sessionIdsList = new ArrayList<String>();	//Creating new instance of List to collect sessions id's 
				sessionIdsList = webContentDAOIF.fetchAllSessionIds(); // Fetch all session id's from database
				
									
				HttpServletRequest httpRequest = (HttpServletRequest)request; 
			
				HttpSession session = httpRequest.getSession();	//Get session present present user request
				String userSessionId = session.getId();	//Get Id of user session to use it to fetch user name
				session.setAttribute("userSessionId", userSessionId); //Save session id in user own session
								
					//Check whether user is new or registered user by fetch id from database
				   //If session id is match with session id from database then user is not new 
					if(sessionIdsList != null 
							&& 
							 sessionIdsList.size() != 0 
							   && 
								sessionIdsList.contains(userSessionId)) {
						
						session.setAttribute("isNewUser", "false");
						session.setAttribute("userName", webContentDAOIF.fetchUserNameBySessionId(userSessionId));
										
					 	} else {
					 		
							session.setAttribute("isNewUser", "true");
							session.setAttribute("userName", ANONIM_USER_NAME); //User is new user or not registered user. Default name will apply to user
						    }
				
					//Check to where particular user request goes and forward it on special servlet url
				   //If no servlet url found forward it on page stub.
					if(httpRequest.getServletPath().equals("/main")) 
						
							forwardUserRequests(request, response, "/main");
							
					   else if(httpRequest.getServletPath().equals("/event")) 
						
							 		forwardUserRequests(request, response, "/event");
					
							 else 
								 		forwardUserRequests(request, response, "/WEB-INF/view/stubURL.jsp");						
					
		} //End of doFilter(..) method
	
		
		@Override
		public void destroy() {
			//Nothing to do
			}
	

}