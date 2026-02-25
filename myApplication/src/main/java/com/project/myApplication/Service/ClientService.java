package com.project.myApplication.Service;

import com.project.myApplication.DAO.ClientDAO;
import com.project.myApplication.DTO.Client;
import com.project.myApplication.Exception.IDNotFoundException;
import com.project.myApplication.Response.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDAO dao;

    public ResponseEntity<ResponseStructure<Client>> saveCl(Client c) {
        ResponseStructure<Client> res = new ResponseStructure<>();
        res.setStatusCode(HttpStatus.OK.value());
        res.setMessage("Successfully saved the client");
        res.setData(dao.saveClient(c));

        return new ResponseEntity<ResponseStructure<Client>>(res, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> getByName(String name) {
        ResponseStructure<String> res = new ResponseStructure<>();
        res.setStatusCode(HttpStatus.OK.value());
        res.setMessage("Successfully fetched the client");
        res.setData(dao.getByName(name));

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
        ResponseStructure<String> res = new ResponseStructure<>();
        Client c = dao.deleteById(id);

        if(c != null) {
            res.setStatusCode(HttpStatus.OK.value());
            res.setMessage("Successfully deleted the client");
            res.setData("Data deleted");

            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        throw new IDNotFoundException();
    }

    public ResponseEntity<ResponseStructure<Client>> findById(int id) {
        Client c = dao.findById(id);

        if (c != null) {
            ResponseStructure<Client> res = new ResponseStructure<>();
            res.setStatusCode(HttpStatus.OK.value());
            res.setMessage("Successfully fetched the client");
            res.setData(c);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        throw new IDNotFoundException();
    }

    public ResponseEntity<ResponseStructure<Client>> updateById(int id, Client updatedClient) {
        Client c = dao.updateById(id, updatedClient);

        if (c != null) {
            ResponseStructure<Client> res = new ResponseStructure<>();
            res.setStatusCode(HttpStatus.OK.value());
            res.setMessage("Successfully updated the client");
            res.setData(c);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        throw new IDNotFoundException();
    }

    public ResponseEntity<ResponseStructure<List<Client>>> updateByName(String name, Client updatedClient) {
        List<Client> updatedClients = dao.updateByName(name, updatedClient);

        if (updatedClients != null) {
            ResponseStructure<List<Client>> res = new ResponseStructure<>();
            res.setStatusCode(HttpStatus.OK.value());
            res.setMessage("Successfully updated client(s)");
            res.setData(updatedClients);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        throw new IDNotFoundException("No client found with given name");
    }

    public ResponseEntity<ResponseStructure<List<Client>>> findByAge(int age) {

        List<Client> clients = dao.findByAge(age);

        if (!clients.isEmpty()) {

            ResponseStructure<List<Client>> res = new ResponseStructure<>();
            res.setStatusCode(HttpStatus.OK.value());
            res.setMessage("Successfully fetched client(s)");
            res.setData(clients);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        throw new IDNotFoundException("No client found with given age");
    }

    public ResponseEntity<ResponseStructure<List<Client>>> updateByAge(int age, Client updatedClient) {

        List<Client> updatedClients = dao.updateByAge(age, updatedClient);

        if (updatedClients != null) {

            ResponseStructure<List<Client>> res = new ResponseStructure<>();
            res.setStatusCode(HttpStatus.OK.value());
            res.setMessage("Successfully updated client(s)");
            res.setData(updatedClients);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        throw new IDNotFoundException("No client found with given age");
    }
}
