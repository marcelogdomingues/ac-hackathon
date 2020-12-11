package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.controller.ClientControllerImp;
import org.academiadecodigo.hackaton.persistence.db.FakeDatabase;
import org.academiadecodigo.hackaton.persistence.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientControllerImp clientControllerImp;
    private FakeDatabase fakeDatabase;


    @Autowired
    public void setFakeDatabase(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    @Autowired
    public void setClientControllerImp(ClientControllerImp clientControllerImp) {
        this.clientControllerImp = clientControllerImp;
    }

    public ClientModel get(Integer id){
        ClientModel clientModel = null;

        for (ClientModel c : fakeDatabase.getClientList()){
            if(c.getId().equals(id)){
                clientModel = c;
            }
        }

        return clientModel;
    }

    @Override
    public void add(ClientModel clientModel) {
        fakeDatabase.getClientList().add(clientModel);
    }

}
