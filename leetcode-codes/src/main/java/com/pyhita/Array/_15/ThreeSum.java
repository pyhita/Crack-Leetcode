package com.pyhita.Array._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: kante_yang
 * @Date: 2024/3/14
 */
public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new ThreeSum().threeSum(nums);
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return List.of();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k <= nums.length - 3; k++) {
            if (nums[k] > 0) continue;
            if (k > 0 && nums[k] == nums[k - 1]) continue; // skip
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    res.add(List.of(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }

        return res;
    }
}
