package com.kuang.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class imageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如何让浏览器5秒自动刷新一次
        resp.setHeader("refresh","3");

        // 在内存中创建图片
        BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        // 得到图片
        Graphics graphics = bufferedImage.getGraphics();// 笔

//        设置图片的背景颜色
        graphics.setColor(Color.white);

        graphics.fillRect(0,0,80,20);

        // 给图片写数据
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeNum(),0,20);

        // 告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");

        // 网站存在缓存，不让浏览器缓存,
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写给浏览器
        ImageIO.write(bufferedImage,"jpg", resp.getOutputStream());

    }

    private String makeNum()
    {
        Random random = new Random();
        String i = random.nextInt(999999)+"";
        StringBuffer sb = new StringBuffer();
        for (int i1 = 0; i1 < 7 - i.length(); i1++) {
            sb.append("0");
        }
        i = sb.toString() + i;
        return i;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
