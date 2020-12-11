package org.academiadecodigo.hackaton.controller;

import org.academiadecodigo.hackaton.commands.ClientDTO;
import org.academiadecodigo.hackaton.converts.ClientDtoToClient;
import org.academiadecodigo.hackaton.persistence.model.ClientModel;
import org.academiadecodigo.hackaton.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    private ClientService clientService;
    private ClientDtoToClient clientDtoToClient;

    @Autowired
    public void setClientDtoToClient(ClientDtoToClient clientDtoToClient) {
        this.clientDtoToClient = clientDtoToClient;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView("/services/register");

        mav.addObject("newclient", new ClientModel());

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registerProcess")
    public ModelAndView addUser(@ModelAttribute("newclient") ClientDTO clientDTO){

        ClientModel clientModel = clientDtoToClient.convert(clientDTO);

        clientService.add(clientModel);

        return new ModelAndView("/services/services", "user", clientModel.getUsername());

    }
}
