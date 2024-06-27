package com.pyhita.utils;

import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: kante_yang
 * @Date: 2024/4/18
 */
public class MapTest {


    public static void main(String[] args) {
        // new MapTest().testConcurrentSkipListMap();
        new MapTest().testRandom();
    }

    private void testConcurrentSkipListMap() {
        ConcurrentSkipListMap<Integer, Integer> skipListMap = new ConcurrentSkipListMap<>();

        skipListMap.put(0, 22);
        skipListMap.put(5, 25);
        skipListMap.put(11, 44);
        skipListMap.put(23, 54);

        // 找到不大于 13 的最大项，即(11, 44)
        Entry<Integer, Integer> entry = skipListMap.floorEntry(13);
        System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    private void testRandom() {
        // Math.random 0 ~ 1 [0.0, 1.0)
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 2));
        }
        System.out.println("==========Math.random===========");

        // Random 0 ~ 1 rand.nextInt(n) [0, n)
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(rand.nextInt(2));
        }

        System.out.println("==========Random.nextInt===========");
        // ThreadLocalRandom
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(threadLocalRandom.nextInt(2));
        }
    }

}
