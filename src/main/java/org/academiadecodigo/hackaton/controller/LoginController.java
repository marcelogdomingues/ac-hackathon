package org.academiadecodigo.hackaton.controller;

import org.academiadecodigo.hackaton.commands.LoginDTO;
import org.academiadecodigo.hackaton.converts.ClientDtoToClient;
import org.academiadecodigo.hackaton.converts.ClientToClientDto;
import org.academiadecodigo.hackaton.persistence.model.ClientModel;
import org.academiadecodigo.hackaton.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private LoginService loginService;
    private ClientToClientDto clientToClientDto;
    private ClientDtoToClient clientDtoToClient;


    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public ModelAndView loginForm() {

        ModelAndView mav = new ModelAndView("services/login");
        mav.addObject("logindto", new LoginDTO());

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/loginProcess")
    public String auth(@ModelAttribute("logindto") LoginDTO loginDTO){

        ModelAndView mav = null;

        ClientModel clientModel = loginService.validate(loginDTO);

        if(clientModel != null){

            mav = new ModelAndView("/services/services");
            mav.addObject("username", clientModel.getUsername());

        } else {

            mav = new ModelAndView("/services/register");

        }
        return "redirect:/services/services";
    }


    // SETTER AND GETTERS
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public ClientToClientDto getClientToClientDto() {
        return clientToClientDto;
    }

    @Autowired
    public void setClientToClientDto(ClientToClientDto clientToClientDto) {
        this.clientToClientDto = clientToClientDto;
    }

    public ClientDtoToClient getClientDtoToClient() {
        return clientDtoToClient;
    }

    @Autowired
    public void setClientDtoToClient(ClientDtoToClient clientDtoToClient) {
        this.clientDtoToClient = clientDtoToClient;
    }

}


