package com.yz.controller;

import com.yz.entity.TUser;
import com.yz.service.TUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-05-11 11:34:25
 */
@Controller
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;
    private int id;

    @GetMapping("/toRenew/{id}")
    public String toRenew(@PathVariable("id") int id){
        this.id = id;
        return "admin/renew";
    }

    @PostMapping("/renew")
    public String renew(int time){
        tUserService.renew(time,this.id);
        return "redirect:toManage";
    }

    @GetMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam("data") String data){
        tUserService.deleteById(Integer.parseInt(data));
    }

    @GetMapping("/toInsert")
    public String toInsert(){
        return "admin/insert";
    }

    @PostMapping("/insert")
    public String insert(TUser tUser){
        tUserService.insert(tUser);
        return "redirect:toManage";
    }

    @GetMapping("/stopOrRerun")
    @ResponseBody
    public void stop(@RequestParam("data") String data){
        tUserService.stopOrRerun(Integer.parseInt(data));
    }

}