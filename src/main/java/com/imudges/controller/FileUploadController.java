package com.imudges.controller;

/**
 * Created by Administrator on 2016/11/14.
 */


import com.imudges.model.CommodityEntity;
import com.imudges.model.ImageEntity;
import com.imudges.repository.CommodityRepository;
import com.imudges.repository.ImageRepository;
import com.imudges.utils.FileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by shhao.
 * Date: 14-9-1
 * Time:下午4:32
 */
@Controller
public class FileUploadController {

    //Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    CommodityRepository commodityRepository;
    @Autowired
    ImageRepository imageRepository;

    @RequestMapping("test")
    public String test(){
        return "test";
    }
    @RequestMapping(value = "addIndent",method = RequestMethod.POST)
    public String addIndent(String commodityName,MultipartFile imagetop,MultipartFile imagetwo,MultipartFile imagethree,int price,String description,double discount,HttpServletRequest request,ModelMap modelMap ) throws IOException {
        CommodityEntity commodityEntity = new CommodityEntity();
        ImageEntity imageEntity = new ImageEntity();
        String filePath1 = FileUpload.uploadFile(imagetop, request);
        String filePath2 = FileUpload.uploadFile(imagetwo, request);
        String filePath3 = FileUpload.uploadFile(imagethree, request);
        filePath1 = filePath1+";"+filePath2+";"+filePath3;
        imageEntity.setImg(filePath1);
        imageRepository.saveAndFlush(imageEntity);
        imageEntity =  imageRepository.findByImg(filePath1);
        commodityEntity.setCommodityname(commodityName);
        commodityEntity.setPrice(price);
        commodityEntity.setDescription(description);
        commodityEntity.setImageByImageId(imageEntity);
        commodityEntity.setDiscount(discount);
        commodityRepository.saveAndFlush(commodityEntity);
        List<CommodityEntity> commodityEntities = commodityRepository.findAll();
        modelMap.addAttribute("commodityEntities",commodityEntities);
        return "cate";
    }
    @RequestMapping("download")
    public void download(String fileName,HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream os = response.getOutputStream();
        try {
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentType("image/jpeg; charset=utf-8");
            os.write(FileUtils.readFileToByteArray(FileUpload.getFile(fileName,request)));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}