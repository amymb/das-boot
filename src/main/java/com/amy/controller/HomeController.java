package com.amy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pivotal on 4/13/17.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Das Boot!";
    }
}
