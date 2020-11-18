package com.uncopyrighted.uncopyrightedmain.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UncopyrightedController {

	@RequestMapping(value = "/login")
	public String empty() {
		return "login";
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/about")
	public String about() {
		return "about";
	}

}
