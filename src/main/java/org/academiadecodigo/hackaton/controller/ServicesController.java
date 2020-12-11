package org.academiadecodigo.hackaton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicesController {

    @RequestMapping(method = RequestMethod.GET, value = "/services")
    public String services(){
        return "services/services";
    }

}
