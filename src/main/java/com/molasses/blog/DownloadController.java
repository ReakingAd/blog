package com.molasses.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DownloadController {

    @GetMapping("/download")
//    @RequestMapping("/download")
    @ResponseBody
    public void downloadMolassesInstaller(HttpServletResponse response){
        System.out.println("in request");
        String filename = "temp.txt";
//        System.out.println(filename);
        String result = FileUtil.downloadFile(response,filename);
//        System.out.println(result);
    }
}
