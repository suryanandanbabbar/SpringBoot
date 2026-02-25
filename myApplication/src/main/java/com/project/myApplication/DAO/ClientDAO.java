package com.project.myApplication.DAO;

import com.project.myApplication.DTO.Client;
import com.project.myApplication.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientDAO {

    @Autowired
    private ClientRepository clres;

    public Client saveClient(Client c) {
        return clres.save(c);
    }

    public String getByName(String name) {
        List<Client> list = clres.findByName(name);
        return "Records are: " + list;
    }

    public Client deleteById(int id) {
        Optional<Client> op = clres.findById(id);
        if(op.isPresent()) {
            return op.get();
        }
        return null;
    }

    public Client findById(int id) {
        Optional<Client> op = clres.findById(id);
        if(op.isPresent()) {
            return op.get();
        }
        return null;
    }
}
