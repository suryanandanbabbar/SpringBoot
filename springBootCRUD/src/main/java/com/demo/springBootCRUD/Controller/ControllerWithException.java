package com.demo.springBootCRUD.Controller;

import com.demo.springBootCRUD.DTO.Student;
import com.demo.springBootCRUD.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWithException {

    @Autowired
    public StudentRepository stures;

    @PostMapping("/save")
    public Student saveStu(@RequestBody Student st) {
        String stName = st.getName();
        stName = stName + stName.length();
        st.setName(stName);
        return stures.save(st);
    }
}
