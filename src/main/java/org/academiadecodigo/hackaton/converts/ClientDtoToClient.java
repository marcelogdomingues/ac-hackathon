package org.academiadecodigo.hackaton.converts;

import org.academiadecodigo.hackaton.commands.ClientDTO;
import org.academiadecodigo.hackaton.persistence.model.ClientModel;
import org.academiadecodigo.hackaton.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoToClient {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientModel convert(ClientDTO clientDTO) {

        ClientModel clientModel = (clientDTO.getId() != null) ? clientService.get(clientDTO.getId()) : new ClientModel();

        clientModel.setUsername(clientDTO.getUsername());
        clientModel.setEmail(clientDTO.getEmail());

        return clientModel;
    }

}

