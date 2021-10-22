package com.kuang.demo01;


//多个线程同时操作同一个对象
//买火车票的例子
public class TestThread4 implements Runnable {

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
        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4,"小米").start();
        new Thread(testThread4,"老师").start();
        new Thread(testThread4,"黄牛党").start();

    }
}
