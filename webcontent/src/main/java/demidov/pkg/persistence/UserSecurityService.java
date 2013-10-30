package demidov.pkg.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import demidov.pkg.domain.TheUser;

public class UserSecurityService implements UserDetailsService{

	 
	WebContentDAOIF webContentDAOIF;
					
		public WebContentDAOIF getWebContentDAOIF() {
			return webContentDAOIF;
		}
	
	
		public void setWebContentDAOIF(WebContentDAOIF webContentDAOIF) {
			this.webContentDAOIF = webContentDAOIF;
		}


	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		
		 UserDetails userDetails = null;
		 
		 
		 TheUser theUser = webContentDAOIF.fetchUserByName(userName);
		 
		 userDetails = new User(theUser.getUserEmale(), theUser.getUserPassword(), true, true, true, true, getAthorities(theUser.getRoleAccess()));
		
		System.out.println("Hello baby-1");
		return userDetails;
	}
	
	
	public Collection<GrantedAuthority> getAthorities(String role) {

		
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
		
		
		authList.add(new SimpleGrantedAuthority(" "));
		
		System.out.println("Hello baby-2");
		
		if ( role.equals("ROLE_USER")) {
		    
		    authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		   }
		 
		   // Return list of granted authorities
		   return authList;
		
		

		
	}
	
	
}
