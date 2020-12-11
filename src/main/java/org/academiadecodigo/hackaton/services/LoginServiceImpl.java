package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.commands.LoginDTO;
import org.academiadecodigo.hackaton.converts.LoginDtoToLogin;
import org.academiadecodigo.hackaton.persistence.db.FakeDatabase;
import org.academiadecodigo.hackaton.persistence.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private FakeDatabase fakeDatabase;


    @Autowired
    public void setFakeDatabase(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }


    public ClientModel validate(LoginDTO loginDTO) {

        ClientModel clientModel = null;
        for (ClientModel c : fakeDatabase.getClientList()) {
            if (c.getPassword().equals(loginDTO.getPassword())) {
                clientModel = c;
                break;
            }
        }
        return clientModel;
    }
}
