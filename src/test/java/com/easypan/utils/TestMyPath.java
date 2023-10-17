package com.easypan.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Author: lkl
 * @Date: 2023/10/16 16:55
 * @Description:
 **/

public class TestMyPath {

    @Test
    public void testPath() throws FileNotFoundException {

        String fileName = "classpath:static/pyy.jpg";
        File file1 = ResourceUtils.getFile(fileName);
        File file = new File(fileName);
        if (file1.exists()) {
            System.out.println(file1.getAbsolutePath());
        }
    }


}
