package com.example.music.controller;

import com.example.music.model.*;
import com.example.music.service.GenreService;
import com.example.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    GenreService genreService;
    @Autowired
    SongService songService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sort") Optional<String> sort){
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        String sortField = sort.orElse("name");
//        Sort sortBy = Sort.by("email").descending().and(Sort.by("phoneNumber").ascending());
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(sortField).ascending());
        Page<Song> songs = songService.findAll(pageable);
        model.addAttribute("songs",songs);
        return "/song/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        Song song = new Song();
        List<Genre> genres = genreService.findAll();
        model.addAttribute("song",song);
        model.addAttribute("genres",genres);
        return "/song/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("song")Song song, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            songService.save(song);
            return "redirect:/songs/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Long id, Model model){
        Song song = songService.findById(id).orElse(new Song());
        List<Genre> genres = genreService.findAll();
        model.addAttribute("song",song);
        model.addAttribute("genres",genres);
        return "/song/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        songService.delete(id);
        return "redirect:/songs/list";
    }

    @PostMapping("/deleteAll")
    public String deleteAll(@RequestParam(value = "ids", defaultValue = "") Long[] ids){
        if (ids.length != 0) {
            songService.deleteAll(ids);
        }
        return "redirect:/songs/list";
    }
}
