package com.tao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        integers.add(-1);
        integers.add(1);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-1);
        list.add(1);
        System.out.println(list.equals(integers));
        System.out.println(list);
        System.out.println(integers);

    }

    public static void testLocalDateTime(){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("jha");
        list1.remove(0);
        System.out.println(list1.size());
        /*HashMap<String, String> map = new HashMap<>();
        map.put("username","zhansan");
        Object o = map

        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        System.out.println(currentTime.getHour());
        System.out.println(currentTime.getMinute());
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);*/
        HashMap<String, String> map = new HashMap<>();
        map.put("username","zhangsan");
        map.put("password","zhangsan");
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("username","zhangsans");
        map1.put("password","zhangsan");
        List<Map> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        System.out.println(list.stream().distinct().collect(Collectors.toList()).size());
    }
}
