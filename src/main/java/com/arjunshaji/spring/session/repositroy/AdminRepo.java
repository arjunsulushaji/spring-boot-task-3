package com.arjunshaji.spring.session.repositroy;

import com.arjunshaji.spring.session.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.DoubleStream;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
    Admin findByUsernameAndPassword(String username, String password);
}
