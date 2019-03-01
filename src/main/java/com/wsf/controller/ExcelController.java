package com.wsf.controller;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.wsf.util.ExcelImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ExcelController {
    //这里直接new了
    ExcelImpl excel = new ExcelImpl();

    @RequestMapping("/download_excel.do")
    //获取url链接上的参数
    public @ResponseBody String dowm(HttpServletResponse response,@RequestParam("id") String id,@RequestParam("name") String name){
        response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：张三.pdf)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(name+".xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            String[] titles = { "用户id", "用户姓名", "用户密码", "用户年龄" };
            excel.export(titles, out);
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }
}