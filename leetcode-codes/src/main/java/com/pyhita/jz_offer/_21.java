package com.pyhita.jz_offer;

/**
 * @Author: kante_yang
 * @Date: 2024/4/23
 */
public class _21 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
     *
     * nums = [1,2,3,4] 输出：[1,3,2,4] 注：[3,1,2,4] 也是正确的答案之一
     */
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        reOrderArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void reOrderArray(int[] nums) {

    }


}
