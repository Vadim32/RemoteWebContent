package demidov.pkg.domain;


import java.util.Date;


public class UserEvents {


	
	private int userEventId;

		public int getUserEventId() {
			return userEventId;
		}
	
		public void setUserEventId(int userEventId) {
			this.userEventId = userEventId;
		}



	private Date userEventDate;		
		
		public Date getUserEventDate() {
			return userEventDate;
		}
	
		public void setUserEventDate(Date userEventDate) {
			this.userEventDate = userEventDate;
		}
	
	
	
	protected TheUser theUser;

		public TheUser getTheUser() {
			return theUser;
		}
	
		public void setTheUser(TheUser theUser) {
			this.theUser = theUser;
		}
		
}