package com.arjunshaji.spring.session.repositroy;

import com.arjunshaji.spring.session.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
