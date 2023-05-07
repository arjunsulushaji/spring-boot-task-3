package com.arjunshaji.spring.session.sevice;

import com.arjunshaji.spring.session.entity.Admin;
import com.arjunshaji.spring.session.repositroy.AdminRepo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //SAVE ADMIN DETAILS TO POSTGRES DB
    public void saveAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    //AUTHORIZE ADMIN EMAIL AND PASSWORD TO ADMIN LOGIN
    public Object adminLogin(Admin admin, HttpServletResponse response) {

        //FIND ADMIN FORM DB BY USING USERNAME AND PASSWORD
        Admin admin1 = adminRepo.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());

        if(admin1 == null){
            //throw new RuntimeException("INVALID USERNAME OR PASSWORD.........");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "INVALID USERNAME OR PASSWORD.........";
        }
        //CREATE A RANDOM NUMBER AS ID AND STORED IN REDIS AND IN HEADER
        String data = String.valueOf(UUID.randomUUID());
        redisTemplate.opsForValue().set("sessionId",data,Duration.ofMinutes(1));
        ((HttpServletResponse) response).setHeader("sessionId",data);

        return "ADMIN LOGIN SUCCESSFUL..............";
    }
}
