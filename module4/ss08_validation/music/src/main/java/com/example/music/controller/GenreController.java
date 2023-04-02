package com.example.music.controller;

import com.example.music.model.Genre;
import com.example.music.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    GenreService genreService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);
        return "/genre/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        return "/genre/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("genre") Genre genre, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/genre/create";
        } else {
            genreService.create(genre);
            return "redirect:/genres/list";
        }
    }

//    @GetMapping("/edit/{id}")
//    public String showEdit(@PathVariable("id") Long id, Model model){
//        Song song = songService.findById(id).orElse(new Song());
//        List<Genre> genres = genreService.findAll();
//        model.addAttribute("song",song);
//        model.addAttribute("genres",genres);
//        return "/edit";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        genreService.deleteById(id);
        return "redirect:/genres/list";
    }

    @PostMapping("/deleteAll")
    public String deleteAll(@RequestParam(value = "ids", defaultValue = "") Long[] ids) {
        for (Long id : ids) {
            genreService.deleteById(id);
        }
        return "redirect:/genres/list";
    }
}
