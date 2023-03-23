package com.example.controller;

import com.example.model.MyFile;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Value("${song-upload}")
    private String songUpload;

    @Autowired
    private ISongService service;

    @GetMapping("")
    public String index(Model model) {
        System.out.println("Da vao controller");
        List<Song> songList = service.findAll();
        model.addAttribute("songList", songList);
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        System.out.println("Da vao method create");
        Song song = new Song();
        model.addAttribute("song", song);
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("song") Song song, Model model){
        service.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") int id, Model model) {
        System.out.println("Da vao method edit");
        Song song = service.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/update")
    public String save(@ModelAttribute("song") Song song){
        service.update(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/delete")
    public String editForm(@PathVariable("id") int id) {
        System.out.println("Da vao method delete");
        service.remove(id);
        return "redirect:/songs";
    }

    @GetMapping("/upload")
    public String uploadForm(Model model) {
        System.out.println("Da vao method upload");
        model.addAttribute("myFile", new MyFile());
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute("myFile") MyFile myFile, RedirectAttributes rd){
        System.out.println("Post upload");
        try {
            MultipartFile multipartFile = myFile.getMultipartFile();
            String fileName = multipartFile.getOriginalFilename();
//            File newFile = new File(this.getFolderUpload(), fileName);
//            multipartFile.transferTo(newFile);
            FileCopyUtils.copy(multipartFile.getBytes(), new File(songUpload + fileName));
            rd.addFlashAttribute("message", "upload success");
        } catch (Exception e) {
            e.printStackTrace();
            rd.addFlashAttribute("message", "upload failed");
        }
        return "redirect:/songs";
    }

    public File getFolderUpload() {
        File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}