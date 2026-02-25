package com.project.myApplication.Controller;

import com.project.myApplication.DTO.Client;
import com.project.myApplication.Response.ResponseStructure;
import com.project.myApplication.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clser;

    @PostMapping
    public ResponseEntity<ResponseStructure<Client>> saveClient(@RequestBody Client c) {
        return clser.saveCl(c);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<String>> getClientByName() {
        return clser.getByName("surya");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteClientById(@PathVariable int id) {
        return clser.deleteById(id);
    }
}
