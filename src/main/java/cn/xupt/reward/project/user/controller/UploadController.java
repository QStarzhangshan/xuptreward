package cn.xupt.reward.project.user.controller;

import com.alibaba.fastjson.JSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
public class UploadController {
    
	@RequestMapping(value = "/upload")
	@ResponseBody
	public String upload(MultipartFile file) {
	    try {
	    if (file.isEmpty()) {
	        return "文件为空";
	    }
	    // 获取文件名
	    String fileName = file.getOriginalFilename();
	    // 获取文件的后缀名
	    String suffixName = fileName.substring(fileName.lastIndexOf("."));

	    // 设置文件存储路径
	    String filePath = "D://aim//";
	    String path = filePath + fileName + suffixName;

	    File dest = new File(path);
	    // 检测是否存在目录
	    if (!dest.getParentFile().exists()) {
	        dest.getParentFile().mkdirs();// 新建文件夹
	    }
	    file.transferTo(dest);// 文件写入
	    return "上传成功";
	    } catch (IllegalStateException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "上传失败";
	}
}
