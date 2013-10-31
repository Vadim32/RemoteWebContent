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

	
	List<String> sessionIdsList;
	
	WebContentDAOIF webContentDAOIF;
		
		public void setWebContentDAOIF(WebContentDAOIF webContentDAOIF) {
			this.webContentDAOIF = webContentDAOIF;
		}

	
		@Override
		public void init(FilterConfig arg0) throws ServletException {
								
					sessionIdsList = new ArrayList<String>();
					sessionIdsList = webContentDAOIF.fetchAllSessionIds();
									
			}
			

		@Override
		public void doFilter(ServletRequest request, ServletResponse response,
													 FilterChain filterChain) throws IOException, ServletException {
			
			System.out.println("List size: " + sessionIdsList.size());
					
				HttpServletRequest httpRequest = (HttpServletRequest)request;
			
				HttpSession session = httpRequest.getSession();
				String userSessionId = session.getId();
				System.out.println("Filter: " + userSessionId);
				
				if(sessionIdsList.size() !=0 && sessionIdsList.contains(userSessionId)) {
					
						System.out.println("There is same sessionID");
					
				} else {
					
					System.out.println("Hello anonim");
					
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("main");
				dispatcher.forward(request, response);
				
			
		}
	
		
		@Override
		public void destroy() {
			
			
			}
	

}