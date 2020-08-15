package com.ccljjk.server.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("one")
    public String one() {
        return "one";
    }

    @GetMapping("two")
    public String two() {
        return "two";
    }

    @GetMapping("three")
    public String three() {
        return "three";
    }

    @GetMapping("error")
    public Object error() {
        Map map = new HashMap();
        map.put("code", "500");
        map.put("msg", "未知错误");
        return map;
    }

    /**
     * 测试访问图片
     *
     * @param imgName  图片名
     * @param response 响应
     */
    @GetMapping("/img/{img}")
    public void getImg(@PathVariable("img") String imgName, HttpServletResponse response) {
        // 设置响应类型为html，编码为utf-8，处理相应页面文本显示的乱码
        response.setContentType("application/octet-stream");
        // 设置文件头：最后一个参数是设置下载文件名
        response.setHeader("Content-disposition", "attachment;filename=" + imgName + ".jpg");
        ClassPathResource classPathResource = new ClassPathResource("/img/" + imgName + ".jpg");
        try {
            InputStream inputStreamImg;
            inputStreamImg = classPathResource.getInputStream();
            // Image img = ImageIO.read(inputStreamImg);
            OutputStream out = response.getOutputStream();

            byte[] body;
            body = new byte[inputStreamImg.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
            inputStreamImg.read(body);// 读入到输入流里面
            out.write(body);
            out.flush();
            //关闭响应输出流
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
