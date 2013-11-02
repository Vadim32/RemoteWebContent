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


		
	private String sessionUserId;
	
		public String getSessionUserId() {
			return sessionUserId;
		}
	
		public void setSessionUserId(String sessionUserId) {
			this.sessionUserId = sessionUserId;
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
	
			
		
	private String userEmale;

		public String getUserEmale() {
			return userEmale;
		}
	
		public void setUserEmale(String userEmale) {
			this.userEmale = userEmale;
		}
		
		
	
	private String personAddress;
		
		public String getPersonAddress() {
			return personAddress;
		}
	
		public void setPersonAddress(String personAddress) {
			this.personAddress = personAddress;
		}
	
	
	
	private String personPhoneNumber;
		
		public String getPersonPhoneNumber() {
			return personPhoneNumber;
		}
	
		public void setPersonPhoneNumber(String personPhoneNumber) {
			this.personPhoneNumber = personPhoneNumber;
		}


				
	private List<UserEvents> userEventsList = new ArrayList<UserEvents>();

		public List<UserEvents> getUserEventsList() {
			return userEventsList;
		}
	
		public void setUserEventsList(List<UserEvents> userEventsList) {
			this.userEventsList = userEventsList;
		}
		
}