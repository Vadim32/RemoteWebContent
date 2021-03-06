package demidov.pkg.persistence;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import demidov.pkg.domain.SoftwareDevelopmentEvent;
import demidov.pkg.domain.TheUser;
import demidov.pkg.domain.UserEvents;


@Transactional
public class WebContentDAOImpl implements WebContentDAOIF {

	
	
	
	private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}


		
	public void saveUser2(Integer id, List<UserEvents> events) {
		
		Session session = sessionFactory.getCurrentSession();
		
		TheUser theuser = (TheUser)session.get(TheUser.class, id);
				
		theuser.setUserEventsList(events);
		
		session.saveOrUpdate(theuser);

	}


	
	

	public List<UserEvents> fetchUser() {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SoftwareDevelopmentEvent.class);
				
		return criteria.list();
	}



	public void saveUser(TheUser user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(user);
		
	}



	@Override
	public TheUser fetchUserByName(String userName) {
			
		return (TheUser)sessionFactory.getCurrentSession().createQuery("select u from TheUser u where u.userFirstName=:name")
																	    .setParameter("name", userName).uniqueResult();
	}

 

	

	
}
