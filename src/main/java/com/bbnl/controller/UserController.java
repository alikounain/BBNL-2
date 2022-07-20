package com.bbnl.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbnl.entity.User;
import com.bbnl.repository.UserRepository;
import com.bbnl.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String HomePage() {
		return "home";
	}
	
	@GetMapping("/user")
	public String userDashboard(Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user", user);
		return "userdashboard";
	}
	
	@GetMapping("/customer")
	public String custDashboard(Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user", user);
		return "custdashboard";
	}
	@GetMapping("/provider")
	public String provDashboard(Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user", user);
		return "provdashboard";
	}
	@GetMapping("/ministerial")
	public String minisDashboard(Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user", user);
		return "minisdashboard";
	}
	
	@RequestMapping(value = "/signup")
	public String signupUser(Model model) {
		model.addAttribute("user", new User());
		return "userSignup";
	}
	
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		service.saveUser(user);
		return "redirect:/signin?success";
	}
	
	@GetMapping("/signin")
	public String signinUser(Model model) {
		return "userSignin";
	}
}
