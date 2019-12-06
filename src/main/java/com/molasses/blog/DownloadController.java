package com.molasses.blog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

    @GetMapping("/download")
    public String showPage(){
        return "download page";
    }
}
