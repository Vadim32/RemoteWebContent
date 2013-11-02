package demidov.pkg.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class OrderEventServlet
 * This servlet is responsible to provide ability to user to make order of needed event
 */
public class OrderEventServlet extends HttpServlet {
	
	
	
	//-------------------------Variables------------------------
	
	private static final long serialVersionUID = 1L;
          
		
	
	//-------------------------Servlet methods------------------  
	    
	    /*This method takes forwardPath wrap this argument and use forward(..) to forward to resource on server 
	      from this particular servlet
	      
	      @param request - object that represents the request the client makes of the servlet
		  @param response -object that represents the response the servlet returns to the client
	      */ 
	    private void forwardUserRequests(HttpServletRequest request, HttpServletResponse response, String forwardPath) 
	    																				throws ServletException, IOException {
	    	
	    		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
					dispatcher.forward(request, response);
	    	}
	    	
	    
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
				boolean isNewUser; //This variable keeps status of a user false=user not new, true=user is new 
			
				HttpSession session = request.getSession(); //Get user status attribute is user new or not new
					isNewUser = (boolean) session.getAttribute("isNewUser");
													
				//When user request url of this servlet doGet(..) method it forward it to event.jsp page
				if(isNewUser == true)
						forwardUserRequests(request, response, "/WEB-INF/view/event_newuser.jsp");
				
					 else 	
						forwardUserRequests(request, response, "/WEB-INF/view/event_existeduser.jsp");		
					  
		    }
}