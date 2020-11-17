package com.uncopyrighted.uncopyrightedmain.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uncopyrighted.uncopyrightedmain.domain.IconRepository;
import com.uncopyrighted.uncopyrightedmain.domain.PictureRepository;
import com.uncopyrighted.uncopyrightedmain.domain.SongRepository;

@Controller
public class UncopyrightedController {

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private PictureRepository pictureRepository;
	
	@Autowired
	private IconRepository iconRepository;

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

	// Get all songs
	@RequestMapping(value = "/music", method = RequestMethod.GET)
	public String getSongs(Model model) {
		model.addAttribute("songs", songRepository.findAll());

		return "music";
	}

	@RequestMapping(value = "/pictures")
	public String pictures() {
		return "pictures";
	}

	// Get all pictures
	@RequestMapping(value = "/pictures", method = RequestMethod.GET)
	public String getPictures(Model model) {
		model.addAttribute("pictures", pictureRepository.findAll());
		return "pictures";
	}
	
	@RequestMapping(value = "/icons")
	public String icons() {
		return "icons";
	}
	
	// Get all icons
	@RequestMapping(value = "/icons", method = RequestMethod.GET)
	public String getIcons(Model model) {
		model.addAttribute("icons", iconRepository.findAll());
		return "icons";
	}

}
