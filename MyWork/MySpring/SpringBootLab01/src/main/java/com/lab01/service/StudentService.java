package com.lab01.service;
import com.lab01.repository.StudentRepository;
import com.lab01.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    public Student save(Student student)
    {
        return studentRepository.save(student);
    }

    public Student findById(Long id)
    {
        return studentRepository.findById(id).orElse(null);
    }
    public void delete(Long id)
    {
        studentRepository.deleteById(id);
    }


}
