package com.example.controller;

import com.example.entity.Picture;
import com.example.entity.User;
import com.example.service.ConcernService;
import com.example.service.PictureService;
import com.example.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("picture")
public class PictureController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private ConcernService concernService;
    @Autowired
    private PictureService pictureService;

    @ResponseBody
    @RequestMapping("/uploadPicture")
    public ModelAndView uploadPicture(@RequestParam(value="file",required=false) MultipartFile file,
                                      @RequestParam("name")String name,
                                      @RequestParam("intro")String intro,
                                      @RequestParam("tags")String tags)throws IOException {
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
            String caselsh = fileName.substring(0,fileName.lastIndexOf("."));
            Picture picture = new Picture();
            picture.setName(name);
            picture.setIntro(intro);
            picture.setTags(tags);
            picture.setUser_id(user.getId());
            pictureService.add(picture);
            //获取文件名后缀 
            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
            String newFileName = name+'.'+suffix;
            String path ="/picture/"+newFileName;
            file.transferTo(new File(pathRoot + path));
            mav.addObject("path",path);
        }
        else {
            mav.addObject("path","/picture/err.jpg");
        }
        return mav;
    }

    @RequestMapping("upload")
    public String upload(){
        return "uploadPicture";
    }



}

