package com.pyhita.String.substring;

/**
 * @Author pyhita
 * @Date 2024/6/28
 * @Description
 */
public class SubString {

    public static void main(String[] args) {
        SubString ss = new SubString();
        System.out.println("100 - 100 = " + ss.subString("100", "100"));
        System.out.println("1 - 100 = " + ss.subString("1", "100"));
        System.out.println("100 - 1 = " + ss.subString("100", "1"));
        System.out.println("9999999 - 99 = " + ss.subString("9999999", "99"));
        System.out.println("99 - 9999999 = " + ss.subString("99", "9999999"));
    }


    private String subString(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num1.length() == 0 || num2.length() == 0) return "";

        String res;
        if (isLess(num1, num2)) {
            res = sub(num2, num1);
            if ("0".equals(res)) {
                res = "0";
            } else {
                res = "-" + res;
            }
        } else {
            res = sub(num1, num2);
        }

        return res;
    }

    private String sub(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int i = n1.length - 1, j = n2.length - 1;
        int borrow = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? n1[i] - '0' : 0;
            int b = j >= 0 ? n2[j] - '0' : 0;

            int c;
            if (a - b - borrow < 0) {
                c = (a - b - borrow + 10) % 10;
            } else {
                c = a - b - borrow;
            }

            borrow = a - b - borrow < 0 ? 1 : 0;
            res.append(c);
            i--;
            j--;
        }

        res.reverse();

        int k = 0;
        while (k < res.length() - 1) {
            if (res.charAt(k) != '0') break;
            k++;
        }

        return res.substring(k);
    }

    private boolean isLess(String num1, String num2) {
        return num1.length() == num2.length() ?
                num1.compareTo(num2) < 0 :
                num1.length() < num2.length();
    }



}
