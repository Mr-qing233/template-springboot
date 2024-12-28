package com.example.controller;

import com.example.service.FileService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("/testDir")
    public Boolean testDir() {
        return fileService.testDir();
    }

    @PostMapping("/upload")
    public Boolean upload(@RequestParam("file") MultipartFile file, @RequestParam("type") String type, @RequestParam("uploader") String uploader) throws IOException {
        log.info("upload file: {}", file.getName());
        return fileService.uploadFile(file,type,uploader);
    }

}
