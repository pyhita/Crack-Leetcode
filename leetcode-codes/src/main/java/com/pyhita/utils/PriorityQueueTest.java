package com.pyhita.utils;

import java.util.List;
import java.util.PriorityQueue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: kante_yang
 * @Date: 2024/3/11
 */
public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Person> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()));

        queue.addAll(List.of(
            Person.builder().name("kante").age(20).build(),
            Person.builder().name("kante").age(30).build(),
            Person.builder().name("kante").age(40).build(),
            Person.builder().name("kante").age(50).build()
        ));

        System.out.println(queue.poll());
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static  class Person {
        private String name;
        private Integer age;
    }

}
