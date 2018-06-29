package com.niit.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;


@Controller
public class UserController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(value="success",method = RequestMethod.POST)
	public String registerUser(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("username")String username,
			@RequestParam("password")String password,@RequestParam("phone")String phone)
	{
		User user=new User();
		user.setUsername(username);
        user.setEmail(email);
        user.setMobileNo(phone);
        user.setPassword(password);
        
		userDAO.addUser(user);
		return "Login";
    }
	
	@RequestMapping("/invalid")
	public String invalid(HttpSession Session)
	{
		Session.setAttribute("ErrorMessage","Invalid Credentials");
		return "index";
	}
	

	
	@RequestMapping("/loginsuccess")
	public String showMessage(@RequestParam(value="username")String name,@RequestParam(value="password")String password, 
			HttpSession session,Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		
		String role="ROLE_USER";
		for (GrantedAuthority authority:authorities) 
		{
		 System.out.println(authority.getAuthority());
		
		 if (authority.getAuthority().equals(role)) 
	     {
	    	 session.setAttribute("username",username);
			 session.setAttribute("SuccessMessage","Login Successful");
	    	 page="UserHome";
	    	 
	    	 
	    	
	     }
	     else 
	     {
	  
	    page="AdminHome";
	    session.setAttribute("SuccessMessage","Login Successful");
	    	 break;
	    }
		}
		 return page;
		}
	@RequestMapping("/isValidUser")
	public ModelAndView showMessage(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		System.out.println("in controller");

		String message;
		ModelAndView mv ;
		if (userDAO.isValidUser(username,password)) 
		{
			message = "Successfully Logged in";
			 mv = new ModelAndView("product");
		} else{
			message="Please enter a valid username and password";
			mv=new ModelAndView("Success");
		}
	
		mv.addObject("message", message);
		mv.addObject("username", username);
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("index");
		session.invalidate();
		session=request.getSession(true);
		mv.addObject("logoutMessage","you are successfully logged out");
		mv.addObject("loggedOut","true");
		return mv;
	}
		

	
}
