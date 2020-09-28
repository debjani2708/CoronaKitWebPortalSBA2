package com.wellsfaro.fsd.sba2.coronakit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfaro.fsd.sba2.coronakit.entity.Users;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;
import com.wellsfaro.fsd.sba2.coronakit.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return  "index";
		
	}
	
//	@RequestMapping("/home")
//	public String home() {
//		return  "main-menu";
//	}
	
	@RequestMapping("/home")
	public ModelAndView getHeader(HttpSession session) throws CoronaKitException {
		ModelAndView mv = new ModelAndView("main-menu");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			String role = new ArrayList<>(auth.getAuthorities()).get(0).getAuthority();

			mv.addObject("unm", auth.getName());
			mv.addObject("role", role);
			//-----
		Users user	=userService.getUserDetails(auth.getName());
		session.setAttribute("username", user.getUsername());
		System.out.println("user name fetched :"+user.getUsername());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("contactnumber", user.getContact());
		
			//-----
		}
		return mv;
	}
}
