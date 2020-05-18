package com.company;

public class Person {
    private boolean live=true;
    class Heart{
        public void jump(){
            //直接访问外部类成员
            System.out.println("内部类直接访问外部类成员:"+live);
        }
    }
    public boolean isLive() {
        return live;
    }
    public void setLive(boolean live) {
        this.live = live;
    }
}
