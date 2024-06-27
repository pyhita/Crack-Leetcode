package com.pyhita.Sorting._sorting;

import java.util.Arrays;

/**
 * @Author: kante_yang
 * @Date: 2024/4/24
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 3, 2, 1};
        merge(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void merge(int[] a) {
        int[] b = new int[a.length];
        int num = a.length;
        int rght, wid, rend;
        int i,j,m,t;

        for (int k=1; k < num; k *= 2 ) {
            for (int left=0; left+k < num; left += k*2 ) {
                rght = left + k;
                rend = rght + k;
                if (rend > num) rend = num;
                m = left; i = left; j = rght;
                while (i < rght && j < rend) {
                    if (a[i] <= a[j]) {
                        b[m] = a[i]; i++;
                    } else {
                        b[m] = a[j]; j++;
                    }
                    m++;
                }
                while (i < rght) {
                    b[m]=a[i];
                    i++; m++;
                }
                while (j < rend) {
                    b[m]=a[j];
                    j++; m++;
                }
                for (m=left; m < rend; m++) {
                    a[m] = b[m];
                }
            }
        }
    }


}
