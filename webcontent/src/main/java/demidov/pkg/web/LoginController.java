package demidov.pkg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		return "login";	
	}
	
	
	@RequestMapping(value="/security/j_spring_security_check", method=RequestMethod.POST)
	public String  access() {
		
		return "redirect:/";
		
	}
	
	
}
