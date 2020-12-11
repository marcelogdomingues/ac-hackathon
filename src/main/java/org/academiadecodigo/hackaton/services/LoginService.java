package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.commands.LoginDTO;
import org.academiadecodigo.hackaton.persistence.model.ClientModel;

public interface LoginService {

    ClientModel validate(LoginDTO loginDTO);

}
