
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<html>
	
		<head>
		
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Insert title here</title>
			
		</head>
		
		<body>
		
			<h1>Old user</h1>
			<form action="event-existed-user" method="post">
					
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
										
					
					
					<tr><td><input type="submit" value="Regester user"></td></tr>
					
				</table>
				
			</form>
			
		
		</body>
		
	</html>