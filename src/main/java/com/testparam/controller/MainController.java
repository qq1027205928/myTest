package com.testparam.controller;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class MainController {

    Logger logger= LoggerFactory.getLogger(getClass());

    @PostMapping("/")
    public String index () {
        return "index";
    }

    @PostMapping("index")
    public String index1 () {
        System.out.println("haha");
        logger.info("haha");
        return "/index";
    }

    @PostMapping("/test1")
    @ResponseBody
    @ApiOperation(value = "test1",notes = "testAPI")
    public String test1 (@RequestBody TestParam pojo) {
        System.out.println(pojo.toString());
        return "haha1";
    }


    @PostMapping("/testp1")
    @ResponseBody
    @ApiOperation(value = "testp1",notes = "testAPI")
    public String test22 (@RequestBody HashMap map) {
        System.out.println(map.get("a").toString());
        System.out.println(map.get("b").toString());
        System.out.println(map.get("c").toString());
        return "haha2";
    }


    @PostMapping("/testp2")
    public String test1 (@RequestParam(value = "pajo2List") List<testPojo2> pojo2List) {
        for(testPojo2 p:pojo2List){
            System.out.println(p.getAge());
        }
        System.out.println(pojo2List.toString());
        return "index";
    }

    @PostMapping("test2")
    @ResponseBody
    public String index2 () {
        logger.info("test2222222");
        return "haha";
    }

    @PostMapping("testWord")
    @ResponseBody
    public String index3 () throws Exception {
        //LibreOffice.wordConverterToPdf("D:/wordFile/融资租赁合同（户用光伏）.docx-4.29.docx","D:/pdffile");
        LibreOffice.wordConverterToPdf("/app/wordFile/aaa.docx","/app/pdfFile");
        return "haha";
    }

    public static void main(String[] args) {

    }
}
