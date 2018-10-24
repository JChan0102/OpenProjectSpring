package com.openproject.visitorMessage.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args){
        DateFormat dateFormat;
        dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(new Date()));


    }

}
