package com.interview.dsa;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws ParseException {

//        var tempHashMap = new HashMap<Integer, Employee>();
//        tempHashMap.put(0001, new Employee(0001, "rahhi"));
//        System.out.println(tempHashMap);
//        tempHashMap.get(0001).name = "sanjay";
//        System.out.println(tempHashMap);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = formatter.parse("2022-02-01");
        System.out.println(date);

    }
}


class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
