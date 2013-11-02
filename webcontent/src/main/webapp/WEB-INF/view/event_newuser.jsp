<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<html>
	
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Order event page</title>
			
			<!-- Bootstrap css responsive-->
    	    <link href="resources/css/bootstrap.css" rel="stylesheet">
    	    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    	        	        	    
		</head>
		
		<body>
			
			<!-- JQuery and Bootstrap file-->
			<script src="resources/js/jquery-1.10.2.min.js"></script>
			<script src="resources/js/bootstrap.min.js"></script>
			<script src="resources/js/jquery.scrollTo.js"></script> 
			<script src="resources/js/jquery.nav.js"></script>
			
			<h1>New user</h1>
			<form action="event-new-user" method="post">
					
					<input type="hidden" name="userSessionId" value="${userSessionId}">
						
				<table align="center">
					
					<tr><td>Event type:</td><td>
						<select name="event_type">
							<option>Choose event type</option>
							<option>Computer Maintenance Event</option>
							<option>Software Development Event</option>
						</select>
					</td></tr>
					<tr><td>Event date:</td> <td><input type="text" class="span2" name="user_event_date"></td></tr>
					<tr><td>Event description:</td> <td><textarea rows="5" name="description"></textarea></td></tr>
					<tr><td>Additional Info:</td> <td><input type="text" class="span2" name="additional_info"></td></tr>
										
					<tr><td>First name:</td> <td><input type="text" class="span2" name="first_name"></td></tr>
					<tr><td>Last name:</td> <td><input type="text" class="span2" name="last_name"></td></tr> 
					<tr><td>E-male:</td> <td><input type="text" class="span2" name="e_male"> </td></tr>
					<tr><td>Address:</td> <td> <input type="text" class="span2" name="address"></td></tr>
					<tr><td>Phone number:</td> <td> <input type="text" class="span2" name="phone_number"></td></tr>
					
					<tr><td><input type="submit" value="Regester user"></td></tr>
					
				</table>
				
			</form>
			
		</body>
		
	</html>