package org.academiadecodigo.hackaton.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    // HTML AND CSS NOT SYNCING
    @RequestMapping("/")
    public String home() {
        return "home/index";
    }
}
