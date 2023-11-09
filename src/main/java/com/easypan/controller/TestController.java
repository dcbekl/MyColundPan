package com.easypan.controller;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: lkl
 * @Date: 2023/10/15 21:51
 * @Description:
 **/

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String localAddr = request.getLocalAddr();
        return "test13246";
    }

    @GetMapping("/testCheckCode")
    public void testCheckCode(HttpServletResponse response, Integer type) throws IOException {
        // 设置响应头
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();

        String fileName = "classpath:static/pyy.jpg";
        File file = ResourceUtils.getFile(fileName);

        byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));

        outputStream.write(bytes);
    }
}
