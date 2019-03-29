package com.example.demo.controller;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		testService.test();
		return "test";
	}
}
