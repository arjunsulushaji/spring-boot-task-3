package com.arjunshaji.spring.session.sevice;

import com.arjunshaji.spring.session.entity.Student;
import com.arjunshaji.spring.session.repositroy.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    public Object getStudentById(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            return studentRepo.findById(id);
        } else {
            return "STUDENT NOT FOUND IN THE GIVEN ID.........";
        }
    }

    public Object updateStudentById(Long id, Student student) {
        Optional<Student> student1 = studentRepo.findById(id);
        if(student1.isPresent()){

            if (Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
                student1.get().setName(student.getName());
            }
            if (Objects.nonNull(student.getAge()) && !"".equalsIgnoreCase(student.getAge())) {
                student1.get().setAge(student.getAge());
            }
            if (Objects.nonNull(student.getDepartment()) && !"".equalsIgnoreCase(student.getDepartment())) {
                student1.get().setDepartment(student.getDepartment());
            }
            if (Objects.nonNull(student.getMark()) && !"".equalsIgnoreCase(student.getMark())) {
                student1.get().setMark(student.getMark());
            }
            Student student2 = student1.get();
            return studentRepo.save(student2);
        } else {
            return "STUDENT NOT FOUND IN THE GIVEN ID.........";
        }
    }

    public String deleteStudentById(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            studentRepo.deleteById(id);
            return "STUDENT DETAILS DELETED SUCCESSFULLY......";
        } else {
            return "STUDENT NOT FOUND IN THE GIVEN ID........";
        }
    }
}
