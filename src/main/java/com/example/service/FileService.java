package com.example.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    boolean testDir();

    Boolean uploadFile(MultipartFile file,String type, String uploader) throws IOException;
}
