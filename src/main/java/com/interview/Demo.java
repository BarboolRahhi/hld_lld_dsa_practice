package com.interview;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Demo {



    public static void main(String[] args) {
//
//        var s = "sjdfdHjfSDfShg";
//
//        var lines = s.toLowerCase()
//                .chars()
//                .mapToObj(c -> (char) c)
//                .collect(groupingBy(identity(), counting()));
//
//        var first = lines.entrySet().stream().filter(e -> e.getValue() == 1L).findFirst().orElse(null);
//
//        System.out.println(lines);
//        System.out.println(first);

        BigDecimal decimal = new BigDecimal("0.2");
        System.out.println(decimal);
    }
}

class DbService {

    public Person getPerson() {
        // db query
        // entity  class
        // then covert entity class to dto
        Person person = new Person();
        person.setId("23445");
        person.setAge("23");
        person.setAddress("khara");
        person.setName("rahhi");
        return person;
    }
}


