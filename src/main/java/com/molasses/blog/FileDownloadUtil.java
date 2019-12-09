package com.molasses.blog;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

// http://localhost:8080/download

public class FileDownloadUtil {

    public static String download(HttpServletResponse response, File file) throws  IllegalArgumentException{
//        System.out.println(filename);

        // 设置下载文件的http header
        response.setHeader("content-type","application/octet-stream");
        response.setContentType("application/octet-stream");
        try{
            // encode() 方法会把文件名中的空格转成加好"+",这里要转回来
            String defaultFilename = java.net.URLEncoder.encode(file.getName(),"UTF-8").replace("+"," ");
            response.setHeader("Content-Disposition","attachment;filename=" + defaultFilename);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        // 定义每次读取二进制文件的量：1024个字节
        byte[] buff = new byte[1024];
        OutputStream os;
        try{
            os = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1){
                os.write(buff,0,buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return "success";
    }
}
