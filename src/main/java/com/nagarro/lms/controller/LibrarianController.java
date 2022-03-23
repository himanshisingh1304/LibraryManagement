package com.nagarro.lms.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.lms.entity.Librarian;
import com.nagarro.lms.service.LibrarainService;

@Controller
public class LibrarianController {

	@Autowired
	private LibrarainService librarianService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new Librarian());
		return mv;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") Librarian user) {
		Librarian authUser = librarianService.login(user.getUsername(), user.getPassword());
		if (Objects.nonNull(authUser)) {
			return "redirect:/books";
		}
		else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value= {"/logout"}, method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/login";
	}
}
