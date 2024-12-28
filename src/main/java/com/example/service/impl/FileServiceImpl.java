package com.example.service.impl;

import com.example.service.FileService;
import com.example.vo.ResultEnum;
import com.example.vo.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

//    private final String localPathPrefix = "./data/";
    @Value("${file.localPath}")
    private String localPathPrefix;

    @Override
    public boolean testDir() {

        // 创建文件夹
        File dirFile = new File(localPathPrefix);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        // 创建文件
        try {
//            Files.createFile(path1);
            String content = "Test content";
            Files.writeString(Paths.get(localPathPrefix + "test1.txt"), content);
            log.info("创建成功");
        }catch (IOException e){
            log.error("创建失败");
            e.printStackTrace();
        }
        // 读取文件
        Path path2 = Paths.get(localPathPrefix + "test.txt");
        try {
            List<String> strings = Files.readAllLines(path2);
            for (String line : strings) {
                System.out.println(line);
            }
            log.info("读取成功");
        }catch (IOException e){
            log.error("读取失败");
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 上传文件
     * @param file 文件
     * @return FileVo
     * @throws IOException error
     */
    @Override
    public Boolean uploadFile(MultipartFile file,String type, String uploader) throws IOException {
        // 获取文件名
        String originalFilename = file.getOriginalFilename();

        // 创建目录
        // 用户目录
        log.info("创建目录");
        String userPath = localPathPrefix + uploader;
        File dirFile = new File(userPath);
        if(!dirFile.exists()){
            dirFile.mkdirs();
            log.info("创建目录成功");
        }

        // 文件名-使用type+时间
        log.info("格式化文件");
        String fileName = type + "-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        // 确保文件类型为db
        String fileType = "";
        if (originalFilename != null) {
            fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            if (!fileType.equals("db")){
                ResultJson.Error(ResultEnum.SUFFIXERROR);
            }
        }
        fileName = fileName + fileType;

        // 存储文件
        log.info("存储文件");
        String realPath = userPath + "\\" + fileName;
        File realFile = new File(realPath);
        file.transferTo(realFile);

        return true;
    }
}
