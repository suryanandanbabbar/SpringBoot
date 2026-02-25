package com.project.myApplication.DAO;

import com.project.myApplication.DTO.Client;
import com.project.myApplication.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAO {

    @Autowired
    private ClientRepository clres;

    public Client saveClient(Client c) {
        return clres.save(c);
    }
}
