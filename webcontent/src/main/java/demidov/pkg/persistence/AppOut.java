package demidov.pkg.persistence;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import demidov.pkg.domain.ComputerMaintenanceEvent;
import demidov.pkg.domain.SoftwareDevelopmentEvent;
import demidov.pkg.domain.TheUser;
import demidov.pkg.domain.UserEvents;


public class AppOut {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("spring-context.xml");
		context.refresh();
		
		WebContentDAOIF dao =(WebContentDAOIF) context.getBean("webContentDAOImpl", WebContentDAOIF.class);
		
		
		List<UserEvents> eventList  = new ArrayList<UserEvents>();
		
		
		SoftwareDevelopmentEvent sde = new SoftwareDevelopmentEvent();
		sde.setDescriptionDevelopment("Develop");
		sde.setAdditionalInfoDevelopment("Development Test");
		sde.setUserEventDate(new Date());
		eventList.add(sde);
	
		
		ComputerMaintenanceEvent cme = new ComputerMaintenanceEvent();
		cme.setDescriptionMaintenance("Description maitnance");
		cme.setAdditionalInfoMaintenance(" Maitnance Test");
		cme.setUserEventDate(new Date());
		eventList.add(cme);
		
		
		TheUser user = new TheUser();
		user.setUserFirstName("Vadim1");
		user.setUserLastName("Dem1");
		user.setUserGender("Male1");
		user.setUserEmale("vad@mail.ru");
		user.setPersonAddress("Adress");
		user.setPersonPhoneNumber("1111111");
			
			user.setUserEventsList(eventList);
		
			dao.saveUser(user);
		
		/*List<UserEvents> l = new ArrayList<UserEvents>();
							
		
		for(int i=1; i<10; i++) {
		SoftwareDevelopmentEvent sde = new SoftwareDevelopmentEvent();
		sde.setUserEventDate(new Date());
		sde.setDescriptionDevelopment("Develop something-"+i);
		sde.setAdditionalInfoDevelopment("Develope please-"+i);
		l.add(sde);
		}
		
		dao.saveUser2(1, l);*/
		
		
		
		
		/*List<UserEvents> ue =  dao.fetchUser();
		
		System.out.println(ue.size());
		
		for(int i=0; i<ue.size(); i++) {
			
			
			SoftwareDevelopmentEvent s = (SoftwareDevelopmentEvent)ue.get(i);
			System.out.println(s.getDescriptionDevelopment());
			
		}*/
		
		
		
	}

}
