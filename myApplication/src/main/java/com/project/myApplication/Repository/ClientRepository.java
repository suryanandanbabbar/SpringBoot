package com.project.myApplication.Repository;

import com.project.myApplication.DTO.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Get the client based on name
    List<Client> findByName(String name);

    // Get the client based on age
    List<Client> findByAge(int age);
}
