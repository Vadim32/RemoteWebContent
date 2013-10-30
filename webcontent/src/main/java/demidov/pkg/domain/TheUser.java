package demidov.pkg.domain;

import java.util.ArrayList;
import java.util.List;


public class TheUser {

	
	private int userId;

		public int getUserId() {
			return userId;
		}
	
		public void setUserId(int userId) {
			this.userId = userId;
		}



	private String userFirstName;
	
		public String getUserFirstName() {
			return userFirstName;
		}
	
		public void setUserFirstName(String userFirstName) {
			this.userFirstName = userFirstName;
		}
	
		
	
	private String userLastName;
	
		public String getUserLastName() {
			return userLastName;
		}
	
		public void setUserLastName(String userLastName) {
			this.userLastName = userLastName;
		}
	
	
		
	private String userPassword;

		public String getUserPassword() {
			return userPassword;
		}
	
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		
		
		
	private String userEmale;

		public String getUserEmale() {
			return userEmale;
		}
	
		public void setUserEmale(String userEmale) {
			this.userEmale = userEmale;
		}
		
		
		
	private String roleAccess;
			
		public String getRoleAccess() {
			return roleAccess;
		}
	
		public void setRoleAccess(String roleAccess) {
			this.roleAccess = roleAccess;
		}



	private String userGender;
				
		public String getUserGender() {
			return userGender;
		}
	
		public void setUserGender(String userGender) {
			this.userGender = userGender;
		}

	
			
	private List<UserEvents> userEventsList = new ArrayList<UserEvents>();

		public List<UserEvents> getUserEventsList() {
			return userEventsList;
		}
	
		public void setUserEventsList(List<UserEvents> userEventsList) {
			this.userEventsList = userEventsList;
		}
		
}