/**
 * created by Zheng Jiateng on 2019/1/7.
 */
package com.jmall.service.impl;

import com.jmall.service.iFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//springmvc封装的file
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileServiceImpl implements iFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        // 扩展名
        // abc.jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // A用户:abc.jpg
        // B用户:abc.jpg 不用用户相同文件名的文件会覆盖
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名:{}，上传的路径：{}，新文件名：{}", fileName, path, uploadFileName);
        // 目录
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            //不存在则创建 先赋予写权限
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        // public File(String parent, String child){} @param   parent  The parent pathname string
        File targetFile = new File(path, uploadFileName);


    }


}
