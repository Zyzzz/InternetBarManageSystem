package com.imudges.controller;

/**
 * Created by Administrator on 2016/11/14.
 */

import com.imudges.utils.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shhao.
 * Date: 14-9-1
 * Time:下午4:32
 */
@Controller
public class FileUploadController {

    Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("test")
    public String test(){
        return "test";
    }
    @RequestMapping("upload")
    public void upload( MultipartFile studentPhoto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filePath = FileUpload.uploadFile(studentPhoto, request);
        logger.info("filePath:" + filePath);
        response.setContentType("text/html;charset=utf8");
        response.getWriter().write("<img src='"+filePath+"'/>");
    }
}