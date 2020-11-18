package com.uncopyrighted.uncopyrightedmain.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uncopyrighted.uncopyrightedmain.domain.Icon;
import com.uncopyrighted.uncopyrightedmain.domain.IconRepository;


@Controller
public class IconController {
	
	@Autowired
	private IconRepository iconRepository;

	// Get iconlist
	@RequestMapping(value = "/iconlist", method = RequestMethod.GET)
	public String getIcons(Model model) {
		model.addAttribute("icons", iconRepository.findAll());
		return "iconlist";
	}

	// Get all icons in json
	@RequestMapping(value = "/icons", method = RequestMethod.GET)
	public @ResponseBody List<Icon> iconListRest() {
		return (List<Icon>) iconRepository.findAll();
	}

	// Get icon by id
	@RequestMapping(value = "/icons/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Icon> findIconRest(@PathVariable("id") Long iconid) {
		return iconRepository.findById(iconid);
	}

	// Save icon to rest
	@RequestMapping(value = "icons", method = RequestMethod.POST)
	public @ResponseBody Icon saveIconRest(@RequestBody Icon icon) {
		return iconRepository.save(icon);
	}

	// Delete icon by id
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deleteicon/{id}", method = RequestMethod.GET)
	public String deleteIcon(@PathVariable("id") Long iconid, Model model) {
		iconRepository.deleteById(iconid);
		return "redirect:../iconlist";
	}

	// Add icon
	@RequestMapping(value = "/addicon")
	public String addIcon(Model model) {
		model.addAttribute("icon", new Icon());
		return "addicon";
	}

	// Save icon
	@RequestMapping(value = "/saveicon")
	public String save(Icon icon) {
		iconRepository.save(icon);
		return "redirect:iconlist";
	}

	// Edit icon
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "editicon/{id}", method = RequestMethod.GET)
	public String editIcon(@PathVariable("id") Long iconId, Model model) {
		model.addAttribute("icon", iconRepository.findById(iconId));
		return "editicon";
	}

	
}
