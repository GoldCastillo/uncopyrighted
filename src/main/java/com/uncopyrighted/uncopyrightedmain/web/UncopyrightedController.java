package com.uncopyrighted.uncopyrightedmain.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uncopyrighted.uncopyrightedmain.domain.SongRepository;

@Controller
public class UncopyrightedController {
	
	@Autowired
	private SongRepository songRepository;
	
	
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
	
	@RequestMapping(value = "/music")
	public String music() {
		return "music";
	}
	
	//Get all songs
	@RequestMapping(value = "/music", method = RequestMethod.GET)
	public String getSongs(Model model) {
		model.addAttribute("songs", songRepository.findAll());
		
		return "music";
	}
	
	
	
	
}
