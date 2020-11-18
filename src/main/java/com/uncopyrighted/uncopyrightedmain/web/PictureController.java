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

import com.uncopyrighted.uncopyrightedmain.domain.Picture;
import com.uncopyrighted.uncopyrightedmain.domain.PictureRepository;


@Controller
public class PictureController {
	@Autowired
	private PictureRepository pictureRepository;

	// Get picturelist
	@RequestMapping(value = "/picturelist", method = RequestMethod.GET)
	public String getPictures(Model model) {
		model.addAttribute("pictures", pictureRepository.findAll());
		return "picturelist";
	}

	// Get all pictures in json
	@RequestMapping(value = "/pictures", method = RequestMethod.GET)
	public @ResponseBody List<Picture> pictureListRest() {
		return (List<Picture>) pictureRepository.findAll();
	}

	// Get picture by id
	@RequestMapping(value = "/pictures/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Picture> findPictureRest(@PathVariable("id") Long pictureid) {
		return pictureRepository.findById(pictureid);
	}

	// Save picture to rest
	@RequestMapping(value = "pictures", method = RequestMethod.POST)
	public @ResponseBody Picture savePictureRest(@RequestBody Picture picture) {
		return pictureRepository.save(picture);
	}

	// Delete picture by id
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletepicture/{id}", method = RequestMethod.GET)
	public String deletePicture(@PathVariable("id") Long pictureid, Model model) {
		pictureRepository.deleteById(pictureid);
		return "redirect:../picturelist";
	}

	// Add picture
	@RequestMapping(value = "/addpicture")
	public String addPicture(Model model) {
		model.addAttribute("picture", new Picture());
		return "addpicture";
	}

	// Save picture
	@RequestMapping(value = "/savepicture")
	public String save(Picture picture) {
		pictureRepository.save(picture);
		return "redirect:picturelist";
	}

	// Edit picture
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/editpicture/{id}")
	public String editPicture(@PathVariable("id") Long pictureid, Model model) {
		model.addAttribute("picture", pictureRepository.findById(pictureid));
		return "editpicture";
	}
	
	

}
