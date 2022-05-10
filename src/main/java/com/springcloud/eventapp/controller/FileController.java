package com.springcloud.eventapp.controller;

import com.springcloud.eventapp.storage.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/upload/image")
    public ResponseEntity fileUpload(){
        Map<String, Object> data = new HashMap<>();
        data.put("id", "spring-cloud");
        data.put("type", "png");
        data.put("fileSize", 5);

        fileService.fileUpload(data);

        return ResponseEntity.ok("success");
    }

}
