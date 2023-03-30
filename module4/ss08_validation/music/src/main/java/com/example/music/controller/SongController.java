package com.example.music.controller;

import com.example.music.model.Song;
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

import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    SongService service;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sort") Optional<String> sort){
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        String sortField = sort.orElse("name");
//        Sort sortBy = Sort.by("email").descending().and(Sort.by("phoneNumber").ascending());
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(sortField).ascending());
        Page<Song> songs = service.findAll(pageable);
        model.addAttribute("songs",songs);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        Song song = new Song();
        model.addAttribute("song",song);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("song")Song song, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            service.save(song);
            return "redirect:/songs/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Long id, Model model){
        Song song = service.findById(id).orElse(new Song());
        model.addAttribute("song",song);
        return "/create";
    }
}
