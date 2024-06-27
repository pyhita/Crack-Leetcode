package com.pyhita.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: kante_yang
 * @Date: 2024/3/14
 */
public class ArrayUtils {

    //  -1 -1 0 1 2 4

    public static void main(String[] args) {
        testSortArray();
    }

    private static void testSortArray() {
        int[][] array = new int[][]{
            {1, 3},
            {8, 10},
            {2, 6},
            {15, 18}
        };

        int[][] merge = merge(array);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static int[][] merge(int[][] intervals) {
        // [l1 r1] [l2 r2]
        // 可以合并的条件： r1 >= l2
        // 按照左区间的长度进行排序，如果发现r1 >= l2 进行合并
        // 合并之后的结果：[l1, Math.max(r1, r2)]
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        List<int[]> resList = new ArrayList<>();

        int[] start = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            // 不可以合并 更新start
            if (start[1] >= temp[0]) {
                start[1] = Math.max(start[1], temp[1]);
            } else {
                start = temp;
                resList.add(start);
            }
        }

        resList.add(start);

        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < res.length; i++) {
            int[] temp = resList.get(i);
            res[i] = temp;
        }

        return res;
    }
}
