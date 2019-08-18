package com.example.controller;
import com.example.entity.Concern;
import com.example.entity.Picture;
import com.example.entity.User;
import com.example.service.UserBaseService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    private UserBaseService userBaseService;
    @RequestMapping("/index")
    public String toIndex(){
        return "login";
    }

    @RequestMapping("/goRegister")
    public String register(){
        return "register";
    }
    @RequestMapping("/handleRegister")
    public ModelAndView handleRegister(User user){
        userBaseService.save(user);
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(@RequestParam("username") String username,
                                   @RequestParam("password") String password) {
        boolean isValid = userBaseService.loginCheck(username, password);
        User user = userBaseService.searchUser(username);
        ModelAndView mav = new ModelAndView();
        if (isValid){
            Set<Concern> concerns = user.getConcerner();
            List<User> users = new ArrayList<User>();
            List<Picture> pictures = new ArrayList<Picture>();

            List<Integer> ids=new ArrayList<Integer>();
            for (Concern concern:concerns ){
                ids.add(concern.getConcerned_id());

            }
            for (Integer id:ids){
                users.add(userBaseService.findById(ids.get(id)));
            }

            for (User user1 :users){
                Set<Picture> picture = user1.getPicture();
                for (Picture picture1:picture){
                    pictures.add(picture1);
                }
            }
            mav.setViewName("userHome");
            request.getSession().setAttribute("username", username);
            mav.addObject("pictures",pictures);
            mav.addObject("users",users);
            mav.addObject("user",user);
            return mav;
        }
        else{
            mav.addObject("err", "账号或密码有无，请重新登陆");
            mav.setViewName("login");
            return mav;
        }
    }

    @RequestMapping("/searchUser")
    public ModelAndView searchUser(@RequestParam("key")String username){
        User user = userBaseService.searchUser(username);
        Set<Picture> pictures = user.getPicture();
        Set<Concern> cencerned = user.getConcerned();
        Set<Concern> cencerner =user.getConcerner();
        int count_ed = cencerned.size();
        int count_er = cencerner.size();
        ModelAndView mav = new ModelAndView("otherUser");
        mav.addObject("user", user);
        mav.addObject("picture",pictures);
        mav.addObject("c_er", cencerner);
        mav.addObject("c_ed", cencerned);
        mav.getModel().put("count_ed",count_ed);
        mav.getModel().put("count_er",count_er);
        return mav;
    }
    @RequestMapping("myHome")
    public ModelAndView toMysHome(){
       String  username = (String)request.getSession().getAttribute("username");
        User user = userBaseService.searchUser(username);
        ModelAndView mav = new ModelAndView("myHome");
        mav.addObject("user", user);
        return mav;
    }
    @RequestMapping("changPassword")
    public ModelAndView changePassword(@RequestParam("newpassword")String newpassword){
        String  username = (String)request.getSession().getAttribute("username");
        User user = userBaseService.searchUser(username);
        user.setPassword(newpassword);
        userBaseService.update(user);
        ModelAndView modelAndView = new ModelAndView("myHome");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("changeInformation")
    public ModelAndView changeInformation(User user0){
        String  username = (String)request.getSession().getAttribute("username");
        User user = userBaseService.searchUser(username);
        user.setProvince(user0.getProvince());
        user.setCity(user0.getCity());
        user.setType(user0.getType());
        user.setEmail(user0.getEmail());
        user.setMobile(user0.getMobile());
        if (user0.getUsername() != null){
            user.setUsername(user0.getUsername());
            request.getSession().removeAttribute("username");
            request.getSession().setAttribute("usernaem",user.getUsername());
        }
        userBaseService.update(user);
        ModelAndView modelAndView = new ModelAndView("myHome");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("uploadHead")
    public ModelAndView uploadHead(@RequestParam(value="file",required=false) MultipartFile file)throws IOException {
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String username = (String) request.getSession().getAttribute("username");
        User user = userBaseService.searchUser(username);
        ModelAndView mav = new ModelAndView("myHome");
        mav.addObject("user", user);
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            System.out.println("fileName：" + fileName);
            //获得文件类型（可以判断如果不是图片，禁止上传）
            /* String contentType=file.getContentType();*/
            //获取文件名        
            /*String caselsh = fileName.substring(0,fileName.lastIndexOf("."));*/
            //获取文件名后缀 
            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);

            String newFileName = user.getId()+'.'+suffix;
            String path ="/picture/"+newFileName;
            file.transferTo(new File(pathRoot + path));
            mav.addObject("path",path);
        }
        else {
            mav.addObject("path","/picture/err.jpg");
        }
        return mav;
    }

    @RequestMapping("aaaa")
    @ResponseBody
        public void upload(@RequestParam("u_photo")MultipartFile u_photo){
        System.out.println("u_photo="+u_photo.getSize());
    }


}

