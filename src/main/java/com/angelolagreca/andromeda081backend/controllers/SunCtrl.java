package com.angelolagreca.andromeda081backend.controllers;

import com.angelolagreca.andromeda081backend.model.entities.Sun;
import com.angelolagreca.andromeda081backend.services.SunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("")
public class SunCtrl {

    @Autowired
    SunService sunService;

    @GetMapping("sun")
    public List<Sun> getSunController(){
        return sunService.getSunService();
    }
}
