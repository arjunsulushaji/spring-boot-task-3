package com.arjunshaji.spring.session.controller;

import com.arjunshaji.spring.session.entity.Admin;
import com.arjunshaji.spring.session.sevice.AdminService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/save")
    public Object saveAdmin(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
        return "ADMIN REGISTERED SUCCESSFULLY............";
    }

    @PostMapping("/login")
    public Object adminLogin(@RequestBody Admin admin, HttpServletResponse response)  {
        return adminService.adminLogin(admin,response);
    }


}
