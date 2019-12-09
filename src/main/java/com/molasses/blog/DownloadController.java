package com.molasses.blog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class DownloadController {

    @Value("${download.dir}")
    private String downloadDir;

    @Value("${download.installerFilename}")
    private String installerFilename;

    @GetMapping("/download")
    @ResponseBody
    public String downloadMolassesInstaller(HttpServletResponse response){
//        String filename = "Molasses Setup 0.1.0.exe";
        File file = new File(downloadDir + File.separator + installerFilename);
        System.out.println(file.getPath());
        System.out.println(file.getName());
        // 检查是否存在指定文件
        try{
            if(!file.exists()){
                System.out.println("no");
                throw new Exception("指定的文件不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }

        String result = "";
        try{
            result = FileDownloadUtil.download(response, file);
        } catch (IllegalArgumentException e){
            System.out.println("in catch");
            e.printStackTrace();
            return e.getMessage();
        }
        System.out.println(result);
        return "";
    }
}
