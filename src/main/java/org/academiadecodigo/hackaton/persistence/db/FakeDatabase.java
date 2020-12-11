package org.academiadecodigo.hackaton.persistence.db;

import org.academiadecodigo.hackaton.persistence.model.ClientModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class FakeDatabase {

    private List<ClientModel> clientList = new LinkedList<>();

    public List<ClientModel> getClientList() {
        return clientList;
    }

    public FakeDatabase(){
        ClientModel client1 = new ClientModel();
        client1.setUsername("duarte");
        client1.setPassword("password");
        client1.setId(1);
        clientList.add(client1);
    }
}