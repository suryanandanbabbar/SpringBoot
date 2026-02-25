package com.demo.springBootCRUD.Repository;

import com.demo.springBootCRUD.DTO.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
