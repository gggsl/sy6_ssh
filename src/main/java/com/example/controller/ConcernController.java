package com.example.controller;

import com.example.entity.User;
import com.example.service.ConcernService;
import com.example.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("concern")
public class ConcernController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private ConcernService concernService;

    @ResponseBody
    @RequestMapping("/handleConcern")
    public void handleConcern(@RequestParam("username")String username){
       String usern = (String)request.getSession().getAttribute("username");
        User user_er = userBaseService.searchUser(usern);
        User user_ed = userBaseService.searchUser(username);
        concernService.toFollow(user_er.getId(),user_ed.getId());
    }

}
