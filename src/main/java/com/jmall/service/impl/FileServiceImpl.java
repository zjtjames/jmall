/**
 * created by Zheng Jiateng on 2019/1/7.
 */
package com.jmall.service.impl;

import com.google.common.collect.Lists;
import com.jmall.service.IFileService;
import com.jmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//springmvc封装的file
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    // 这个path是服务器本地存储位置 先上传到服务器本地 本地再传到ftp服务器的文件夹下
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
        // 创建一个File类型的对象 File类是java.io包中唯一代表磁盘文件本身的对象
        File targetFile = new File(path, uploadFileName);
        try {
            // 将上传的文件存储到目标文件中 MultipartFile是springmvc的类
            file.transferTo(targetFile);
            //文件已经成功上传至本地upload文件夹
            // 将targetFile 上传至FTP服务器上
            logger.info("将targetFile 上传至FTP服务器上");
            FTPUtil.uploadFile(Lists.newArrayList(targetFile)); //guawa
            // 文件已经上传至ftp服务器上
            // 上传完之后，删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常", e);
        }
        return targetFile.getName();
    }


}
