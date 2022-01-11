package com.turing.controller;


import com.turing.entity.Emp;
import com.turing.entity.Emp2;
import com.turing.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/emp")
@Slf4j
public class EmpController {

     @Autowired
    private EmpService empService;

    @RequestMapping("/find")
   public String findAll(Model model){

        List<Emp2> empList = empService.findAll();
        model.addAttribute("empList",empList);
        return  "index";
    }

       @RequestMapping("/")
       public String login(){
           return "login";
      }

    //登录
    @RequestMapping("/log")
    public String log(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
      //设置编码格式
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      request.setCharacterEncoding("utf-8");
       //获取用户名
       String username=request.getParameter("username");
        //获取密码
        Integer pwd=Integer.parseInt(request.getParameter("pwd"));
        List<Emp> list = empService.login(username, pwd);
       // System.out.print(list.size());
        if(list.size()>0){
            session.setAttribute("username",username);
            response.sendRedirect("find");
       }
        out.print("<script>alert('用户名或密码错误，请重新登录');</script>");
           return "login";
    }

    @RequestMapping("/del")
    public String del(Integer empno){

        boolean flag = empService.del(empno);
        if(flag){
            log.info("删除成功");
            return "redirect:/emp/find";
        }
        log.info("删除失败");
        return "redirect:/emp/find";
    }

      @RequestMapping("/login")
      @ResponseBody
       public String login1(){
          List<Emp> falg = empService.login("SMITH", 7369);
           if(falg.size()>0){
               return "success";
           }
            return "error";
      }
}
