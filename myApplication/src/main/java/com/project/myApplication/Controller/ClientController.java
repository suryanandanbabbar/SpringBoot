package com.project.myApplication.Controller;

import com.project.myApplication.DTO.Client;
import com.project.myApplication.Response.ResponseStructure;
import com.project.myApplication.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/name/{name}")
    public ResponseEntity<ResponseStructure<List<Client>>> updateClientByName(
            @PathVariable String name,
            @RequestBody Client updatedClient) {

        return clser.updateByName(name, updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteClientById(@PathVariable int id) {
        return clser.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseStructure<Client>> getClientById(@PathVariable int id) {
        return clser.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Client>> updateClientById(
            @PathVariable int id,
            @RequestBody Client updatedClient) {

        return clser.updateById(id, updatedClient);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<ResponseStructure<List<Client>>> getClientByAge(
            @PathVariable int age) {

        return clser.findByAge(age);
    }

    @PutMapping("/age/{age}")
    public ResponseEntity<ResponseStructure<List<Client>>> updateClientByAge(
            @PathVariable int age,
            @RequestBody Client updatedClient) {

        return clser.updateByAge(age, updatedClient);
    }
}
