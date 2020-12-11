package org.academiadecodigo.hackaton.converts;

import org.academiadecodigo.hackaton.commands.ClientDTO;
import org.academiadecodigo.hackaton.persistence.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDto {

    public ClientDTO convert(ClientModel clientModel){

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setEmail(clientModel.getEmail());
        clientDTO.setUsername(clientModel.getUsername());


        return clientDTO;
    }

}
