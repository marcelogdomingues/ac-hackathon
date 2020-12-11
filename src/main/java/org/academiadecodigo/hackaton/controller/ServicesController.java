package org.academiadecodigo.hackaton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicesController {

    @RequestMapping(method = RequestMethod.GET, value = "/services")
    public ModelAndView services(){
        ModelAndView mav = new ModelAndView("/services/services");
        return mav;
    }

}
