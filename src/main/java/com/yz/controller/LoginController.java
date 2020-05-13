package com.yz.controller;

import com.yz.service.TUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource
    private TUserService tUserService;

    @GetMapping("/toLogin")
    public String login(){ return "login"; }

    @GetMapping({"/admin/manage","/toManage","/stopOrRerun/toManage/stop","/delete/toManage/delete"})
    public String doLogin(Model model){
        model.addAttribute("list",tUserService.queryAll());
        return "admin/manage";
    }

    @PostMapping("/errorLogin")
    public String failureLogin(){
        return "login_error";
    }

    @GetMapping("/toLogout")
    public String logout(){
        return "index";
    }
}
