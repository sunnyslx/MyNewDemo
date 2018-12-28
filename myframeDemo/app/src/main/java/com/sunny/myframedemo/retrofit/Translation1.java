package com.sunny.myframedemo.retrofit;

/**
 * Created by Sunny on 18-9-18.
 */

public class Translation1 {
    private int status;
    private Content content;

    private static class Content{
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errorNo;
    }

    //定义输出返回数据的方法
    public void show(){
        System.out.println(status);
        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errorNo);
    }
}
