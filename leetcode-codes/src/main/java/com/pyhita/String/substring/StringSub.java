package com.pyhita.String.substring;

/**
 * @Author: kante_yang
 * @Date: 2024/6/27
 */
public class StringSub {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String next = sc.next();
        // String[] nums = next.split(",");
        // String n1 = nums[0].replace("\"", "");
        // String n2 = nums[1].replace("\"", "");
        // String res = new Main().subString(n1, n2);
        // System.out.println("\"" + res + "\"");

        String res = new StringSub().subString("1", "1");
        System.out.println("res = " + res);
    }

    private String subString(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num1.length() == 0 || num2.length() == 0) return null;

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
        StringBuilder res = new StringBuilder();

        int m = num1.length(), n = num2.length();
        int i = m - 1, j = n - 1;
        int borrow = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int z = 0;
            if (x - y - borrow < 0) {
                z = (x - y - borrow + 10) % 10;
            } else {
                z = x - y - borrow;
            }
            res.append(z);
            borrow = x - y - borrow < 0 ? 1 : 0;
            i--;
            j--;
        }

        // reverse
        res.reverse();
        // skip zero
        int z = 0;
        while (z < res.length() - 1) {
            if (res.charAt(z) != '0') break;;
            z++;
        }

        return res.substring(z);
    }

    private boolean isLess(String num1, String num2) {
        return num1.length() == num2.length() ? num1.compareTo(num2) < 0
            : num1.length() < num2.length();
    }

}
