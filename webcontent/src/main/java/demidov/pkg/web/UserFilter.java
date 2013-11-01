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
import javax.servlet.http.HttpSession;

import demidov.pkg.persistence.WebContentDAOIF;

public class UserFilter implements Filter {

	//-------------------------Variables------------------------
	
	private final String ANONIM_USER_NAME = "Anonim";	//Default name if new user did not order or registered  
	
	WebContentDAOIF webContentDAOIF;
				
		public void setWebContentDAOIF(WebContentDAOIF webContentDAOIF) {
			this.webContentDAOIF = webContentDAOIF;
		}

		
	//-------------------------Filter methods-------------------
	
		@Override
		public void init(FilterConfig arg0) throws ServletException {
				//Nothing to do
			}
			

		@Override
		public void doFilter(ServletRequest request, ServletResponse response,
													 FilterChain filterChain) throws IOException, ServletException {
			
				
				List<String> sessionIdsList = new ArrayList<String>();	//Creating new instance of List to collect sessions id's 
				sessionIdsList = webContentDAOIF.fetchAllSessionIds(); // Fetch all session id's from database
				
									
				HttpServletRequest httpRequest = (HttpServletRequest)request; 
			
				HttpSession session = httpRequest.getSession();	//Get session present present user request
				String userSessionId = session.getId();	//Get Id of user session request for a page
								
				System.out.println(userSessionId);
				
					if(sessionIdsList != null 
							&& 
							 sessionIdsList.size() != 0 
							   && 
								sessionIdsList.contains(userSessionId)) {
					
					System.out.println("Match");
					session.setAttribute("userName", webContentDAOIF.fetchUserNameBySessionId(userSessionId));
					
				} else {
					
					System.out.println("NOT Match");
					session.setAttribute("userName", ANONIM_USER_NAME);
					
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/main");
				dispatcher.forward(request, response);
						
		}
	
		
		@Override
		public void destroy() {
			//Nothing to do
			}
	

}