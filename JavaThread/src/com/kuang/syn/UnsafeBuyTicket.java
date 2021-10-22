package com.kuang.syn;


// 线程不安全，票数有负数
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"小米").start();
        new Thread(buyTicket,"老师").start();
        new Thread(buyTicket,"黄牛党").start();
    }
}


class BuyTicket implements Runnable {

    //票
    private int ticketNums = 10;
    boolean flag = true;  //外部停止方式

    @Override
    public void run() {
        //买票

        while (flag)
        {
            buy();
        }

    }

    // synchronized 同步方法，锁的是this
    private synchronized void buy() {
        if (ticketNums<=0)
        {
            flag=false;
            return;
        }
        // 模拟延时，放大问题的发生性
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 买票
        System.out.println(Thread.currentThread().getName()+" 拿到了 "+ ticketNums--);
    }
}
