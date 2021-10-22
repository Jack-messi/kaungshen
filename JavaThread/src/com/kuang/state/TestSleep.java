package com.kuang.state;

import com.kuang.demo01.TestThread4;

//模拟网络延迟的： 放大问题的发生性

public class TestSleep implements Runnable{

    private int ticketNums = 10;


    @Override
    public void run() {
        while (true) {
            if (ticketNums<=0)
            {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第："+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestSleep testThread4 = new TestSleep();

        new Thread(testThread4,"小米").start();
        new Thread(testThread4,"老师").start();
        new Thread(testThread4,"黄牛党").start();

    }
}
