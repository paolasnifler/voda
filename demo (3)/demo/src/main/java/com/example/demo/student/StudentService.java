package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    //mos regjistro studentet me te njejtin emer
    //lejo editimin
    //git github
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        if (studentRepository.existsByName(student.getName())) {
            throw new RuntimeException("Ekziston nje student me kete emer.");
        }

        if (student.getAge() <= 18) {
            throw new RuntimeException("Duhet te jete 18<");
        }

        return studentRepository.save(student);
    }


    public Student updateStudent(String id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
