package com.kuang.demo2;

import com.kuang.demo01.TestThread2_2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

// 线程实现方式三
public class TestCallable implements Callable<Boolean> {

    private String url;     // 网络图片地址
    private String name;    // 保存的文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }


    // 下载图片线程的执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testThread1 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.n63.com%2Fphotodir%2Fn63img%2F%3FN%3DX2hiJTI2ZGRXZ1dhJTVFVyU1RGtXJTVEa1clNURXJTVEV2VnJTVCJTI2JTJCLmYlMjZvb28lMjdoZ2xjayU1RCU1QyUyN2VZJTYwYyU1QiU1RCUzQSUxOCU1Q2FuWSUzQ1clM0UlM0QlMjdrbGpnaGslMjc%253D%26v%3D&refer=http%3A%2F%2Fwww.n63.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1629861742&t=1b1fa26f87e16ab87ef211dd61462efc","1.jpg");
        TestCallable testThread2 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.n63.com%2Fphotodir%2Fn63img%2F%3FN%3DX2hiJTI2ZGRXZ1dhJTVFVyU1RGtXJTVEa1clNURXJTVEV2VnJTVCJTI2JTJCLmYlMjZvb28lMjdoZ2xjayU1RCU1QyUyN2VZJTYwYyU1QiU1RCUzQSUxOCU1Q2FuWSUzQ1clM0UlM0QlMjdrbGpnaGslMjc%253D%26v%3D&refer=http%3A%2F%2Fwww.n63.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1629861742&t=1b1fa26f87e16ab87ef211dd61462efc","2.jpg");
        TestCallable testThread3 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.n63.com%2Fphotodir%2Fn63img%2F%3FN%3DX2hiJTI2ZGRXZ1dhJTVFVyU1RGtXJTVEa1clNURXJTVEV2VnJTVCJTI2JTJCLmYlMjZvb28lMjdoZ2xjayU1RCU1QyUyN2VZJTYwYyU1QiU1RCUzQSUxOCU1Q2FuWSUzQ1clM0UlM0QlMjdrbGpnaGslMjc%253D%26v%3D&refer=http%3A%2F%2Fwww.n63.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1629861742&t=1b1fa26f87e16ab87ef211dd61462efc","3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> result1 = ser.submit(testThread1);
        Future<Boolean> result2 = ser.submit(testThread2);
        Future<Boolean> result3 = ser.submit(testThread3);

        //获取结果
        boolean rs1 = result1.get();
        boolean rs2 = result2.get();
        boolean rs3 = result3.get();

        //关闭服务
        ser.shutdownNow();

    }



}






class WebDownloader{
    public void downloader(String url,String name)
    {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常: downloader方法出现了异常！");
        }
    }
}
