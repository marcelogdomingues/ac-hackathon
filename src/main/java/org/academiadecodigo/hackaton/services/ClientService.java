package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.ClientModel;

public interface ClientService {

    ClientModel get(Integer id);

    void add(ClientModel clientModel);

}
