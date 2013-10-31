package demidov.pkg.persistence;

import java.util.List;

import demidov.pkg.domain.TheUser;
import demidov.pkg.domain.UserEvents;

public interface WebContentDAOIF {

	public void saveUser(TheUser user);	
	
	public void saveUser2(Integer id, List<UserEvents> events);
	
	public List<UserEvents> fetchUser();
	
	public TheUser fetchUserByName(String userName);
	
	public List<String> fetchAllSessionIds();
	
}
