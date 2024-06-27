package com.pyhita.utils;

/**
 * @Author: kante_yang
 * @Date: 2024/5/25
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append(2);
        sb.append(33);
        sb.append(102);

        System.out.println(sb.toString());

        sb.setLength(sb.length() - 1);

        System.out.println(sb.toString());
    }

}
