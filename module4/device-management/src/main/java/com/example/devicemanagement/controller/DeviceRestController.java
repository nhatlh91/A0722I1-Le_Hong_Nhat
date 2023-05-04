package com.example.devicemanagement.controller;

import com.example.devicemanagement.entity.Device;
import com.example.devicemanagement.service.CategoryServiceImpl;
import com.example.devicemanagement.service.DeviceServiceImpl;
import com.example.devicemanagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/device/")
public class DeviceRestController {
    private DeviceServiceImpl deviceService;
    private CategoryServiceImpl categoryService;
    private UserServiceImpl userService;

    @Autowired
    public DeviceRestController(DeviceServiceImpl deviceService, CategoryServiceImpl categoryService, UserServiceImpl userService){
        this.categoryService = categoryService;
        this.deviceService = deviceService;
        this.userService = userService;
    }

    @GetMapping("search")
    public ResponseEntity<List<Device>> search(@RequestParam("keyword")String keyword){
        List<Device> devices = deviceService.search(keyword);
        if(devices.isEmpty()){
            return new ResponseEntity<>(devices, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(devices,HttpStatus.OK);
    }
}
