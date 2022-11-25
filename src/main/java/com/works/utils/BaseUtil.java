package com.works.utils;


import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class BaseUtil {


    public static String encodeImage(Path pathToImage) throws Exception {
        byte[] bytes = Files.readAllBytes(pathToImage);
        String base64EncodedImageBytes = Base64.getEncoder().encodeToString(bytes);
        return base64EncodedImageBytes;
    }


    public static void decodeImage(String base64EncodedString) throws Exception {
        byte[] decode = Base64.getDecoder().decode(base64EncodedString);
        Path path = Paths.get("/home/mkyong/test/phone2.png");
        Files.write(path, decode);
    }
    //isa
}