package com.turing.controller;

import com.turing.entity.Dept;
import com.turing.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/{id}")
    @ResponseBody
    public Dept findById(@PathVariable("id") Integer id){

       return deptService.findById(id);
    }

    @RequestMapping("/insert")
    public String insert(Dept dept){

        deptService.insert(dept);
        return "添加完成";
    }
}
