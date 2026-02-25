package com.demo.springBootCRUD.Controller;

import com.demo.springBootCRUD.DTO.Student;
import com.demo.springBootCRUD.Repository.StudentRepository;
import com.demo.springBootCRUD.Response.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class RESTController {

    @Autowired
    private StudentRepository stures;

    @PostMapping
    public String saveStudent(@RequestBody Student st) {
        stures.save(st);
        return "Student saved successfully";
    }

    @GetMapping
    public List<Student> getAll() {
        return this.stures.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        Optional<Student> op = this.stures.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
            return null;
        }
    }

    // If we want to give our own structure in the response body of Postman,
    // we need to use ResponseStructure Class
    @GetMapping("/get/{id}")
    public ResponseStructure<Student> getStuById(@PathVariable int id) {
        ResponseStructure<Student> response = new ResponseStructure<>();
        Optional<Student> op = stures.findById(id);

        if(op.isPresent()) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Data fetched successfully");
            response.setData(op.get());
            return response;
        }

        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage("Student not found");
        response.setData(null);
        return response;
    }

    // If we want to change the complete body of postman along with structure and http status code
    // we have to use response entity class (inbuilt)
    @GetMapping("/get1/{id}")
    public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable int id) {
        ResponseStructure<Student> response = new ResponseStructure<>();
        Optional<Student> op = stures.findById(id);
        if(op.isPresent()) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Data fetched successfully");
            response.setData(op.get());
            return new ResponseEntity<ResponseStructure<Student>>(response, HttpStatus.OK);
        }

        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage("Student not found");
        response.setData(null);

        return new ResponseEntity<ResponseStructure<Student>>(response, HttpStatus.NOT_FOUND);
    }
}
