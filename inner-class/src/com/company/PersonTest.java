package com.company;

public class PersonTest {
    public static void main(String[] args) {
        //创建外部类对象
        Person person = new Person();
        //创建内部类对象
        Person.Heart heart = person.new Heart();
        //调用内部类方法
        heart.jump();
        //调用外部类方法
        person.setLive(false);
        //调用内部类方法
        heart.jump();

    }
}
