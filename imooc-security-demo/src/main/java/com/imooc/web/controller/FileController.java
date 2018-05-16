package com.imooc.web.controller;

import com.imooc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by wbcaoa on 2018/5/15.
 */
@RestController
@RequestMapping("/file")
public class FileController {

    String folder = "F:\\my-github\\spring安全服务\\spring-sercurity\\imooc-secruity-demo\\src\\main\\java\\com\\imooc\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {

        System.out.println("文件上传的Name : " + file.getName());
        System.out.println("文件上传的OriginalFilename" + file.getOriginalFilename());
        System.out.println("文件上传的Size : " + file.getSize());


        File localFile = new File(folder, new Date().getTime() + ".txt");

        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletResponse response) throws Exception {
        try (
                FileInputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream();
        ) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");

            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }

}
