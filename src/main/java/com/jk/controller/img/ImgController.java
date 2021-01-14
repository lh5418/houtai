package com.jk.controller.img;

import com.jk.service.UserService;
import com.jk.utils.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * author :yxm
 **/
@RestController
@RequestMapping("/img")
public class ImgController {


    @RequestMapping(value = "/uploadUserImg",method = RequestMethod.POST)
    public Object uploadUserImg(MultipartFile movieImg, HttpServletRequest request){
        try {
            MultipartFile multipartFile = movieImg;
            String fileName = movieImg.getOriginalFilename();
            String url = AliyunOSSUtil.uploadFile(fileName, multipartFile);
            System.out.println(url);
            return url;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "false";
    }
  /*  @RequestMapping("/updateloadVideo")
    public String uploadVideo(MultipartFile videofile, SectionBean sectionBean) throws IOException, IOException {
        String filename = videofile.getOriginalFilename();
        String title = filename.substring(0, filename.lastIndexOf("."));

        UploadStreamRequest request = new UploadStreamRequest("LTAI4G3ntGRfoNHYdYU78a3x","Soej3AwXerYHngXN5zxFDkHFJv688m",
                title,filename,videofile.getInputStream());
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);
        String videoId = null;
        if (response.isSuccess()){
            videoId = response.getVideoId();
        }else {
            videoId = response.getVideoId();
        }
        sectionBean.setVideoId(videoId);
        currService.addzhangjie(sectionBean);
        return videoId;
    }*/
    /*@RequestMapping("/uploadUserImg")
    public String uploadFile(MultipartFile movieImg,HttpServletRequest request) throws Exception {
        File file = MultipartFileToFile.multipartFileToFile(movieImg);
        String s = OssFileUtil.uploadObject2OSS(file);
        return s;
    }*/
   /* @PostMapping("/ossFile")
    public Object fileUpload(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println(request+","+response);
            *//*System.out.println("是否进入了OssController方法？？？");*//*
            //转型为MultipartHttpRequest
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
            //获得文件
            MultipartFile multipartFile = multipartRequest.getFile("myfile");
            String fileName = multipartFile.getOriginalFilename();

            AliyunOSSUtil.uploadFile(fileName,multipartFile);
            Map<String, Object> map= new HashMap<String, Object>();
            map.put("fileName", fileName);
            map.put("fileType", multipartFile.getContentType());
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "false";
    }*/
}
