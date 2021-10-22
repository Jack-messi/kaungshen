package com.kuang.demo01;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {

    }

    public Proxy(Host host) {
        this.host=host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
    }


    public void seeHouse(){
        System.out.println("中介带你看房子");
    }

}
