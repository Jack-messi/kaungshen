package com.kuang.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread，实现多线程同步下载图片

public class TestThread2_2 implements Runnable{

    private String url;     // 网络图片地址
    private String name;    // 保存的文件名

    public TestThread2_2(String url, String name) {
        this.url = url;
        this.name = name;
    }


    // 下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2_2 testThread1 = new TestThread2_2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.n63.com%2Fphotodir%2Fn63img%2F%3FN%3DX2hiJTI2ZGRXZ1dhJTVFVyU1RGtXJTVEa1clNURXJTVEV2VnJTVCJTI2JTJCLmYlMjZvb28lMjdoZ2xjayU1RCU1QyUyN2VZJTYwYyU1QiU1RCUzQSUxOCU1Q2FuWSUzQ1clM0UlM0QlMjdrbGpnaGslMjc%253D%26v%3D&refer=http%3A%2F%2Fwww.n63.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1629861742&t=1b1fa26f87e16ab87ef211dd61462efc","1.jpg");
        TestThread2_2 testThread2 = new TestThread2_2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.n63.com%2Fphotodir%2Fn63img%2F%3FN%3DX2hiJTI2ZGRXZ1dhJTVFVyU1RGtXJTVEa1clNURXJTVEV2VnJTVCJTI2JTJCLmYlMjZvb28lMjdoZ2xjayU1RCU1QyUyN2VZJTYwYyU1QiU1RCUzQSUxOCU1Q2FuWSUzQ1clM0UlM0QlMjdrbGpnaGslMjc%253D%26v%3D&refer=http%3A%2F%2Fwww.n63.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1629861742&t=1b1fa26f87e16ab87ef211dd61462efc","2.jpg");
        TestThread2_2 testThread3 = new TestThread2_2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.n63.com%2Fphotodir%2Fn63img%2F%3FN%3DX2hiJTI2ZGRXZ1dhJTVFVyU1RGtXJTVEa1clNURXJTVEV2VnJTVCJTI2JTJCLmYlMjZvb28lMjdoZ2xjayU1RCU1QyUyN2VZJTYwYyU1QiU1RCUzQSUxOCU1Q2FuWSUzQ1clM0UlM0QlMjdrbGpnaGslMjc%253D%26v%3D&refer=http%3A%2F%2Fwww.n63.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1629861742&t=1b1fa26f87e16ab87ef211dd61462efc","3.jpg");

        //通过代理方式，调用start方法启动线程
        new Thread(testThread1).start();
        new Thread(testThread2).start();
        new Thread(testThread3).start();

    }
}


// 下载器
class WebDownloader_1{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，Downloader方法出现问题");
        }
    }
}


