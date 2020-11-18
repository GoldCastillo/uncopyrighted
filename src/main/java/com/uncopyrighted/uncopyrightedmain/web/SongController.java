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

import com.uncopyrighted.uncopyrightedmain.domain.Song;
import com.uncopyrighted.uncopyrightedmain.domain.SongRepository;


@Controller
public class SongController {
	@Autowired
	private SongRepository songRepository;

	// Get songlist
	@RequestMapping(value = "/songlist", method = RequestMethod.GET)
	public String getSongs(Model model) {
		model.addAttribute("songs", songRepository.findAll());
		return "songlist";
	}

	// Get all songs in json
	@RequestMapping(value = "/songs", method = RequestMethod.GET)
	public @ResponseBody List<Song> songListRest() {
		return (List<Song>) songRepository.findAll();
	}

	// Get song by id
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long songid) {
		return songRepository.findById(songid);
	}

	// Save song to rest
	@RequestMapping(value = "songs", method = RequestMethod.POST)
	public @ResponseBody Song saveSongRest(@RequestBody Song song) {
		return songRepository.save(song);
	}

	// Delete song by id
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletesong/{id}", method = RequestMethod.GET)
	public String deleteSong(@PathVariable("id") Long songid, Model model) {
		songRepository.deleteById(songid);
		return "redirect:../songlist";
	}

	// Add song
	@RequestMapping(value = "/addsong")
	public String addSong(Model model) {
		model.addAttribute("song", new Song());
		return "addsong";
	}

	// Save song
	@RequestMapping(value = "/savesong")
	public String save(Song song) {
		songRepository.save(song);
		return "redirect:songlist";
	}

	// Edit song by id
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/editsong/{id}")
	public String editSong(@PathVariable("id") Long songid, Model model) {
		model.addAttribute("song", songRepository.findById(songid));
		return "editsong";
	}

}
