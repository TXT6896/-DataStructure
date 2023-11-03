package com.tao.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 冒泡排序（升序）
 * 通过从索引0开始进行相邻两元素的比较，如果低索引元素值大于高索引元素值，
 * 则将两元素位置交换，最后的结果就是将参与排序的所有元素中的最大值放到了最后，
 * 进行下一轮排序时，不必再将前几轮元素中最大元素进行排序
 * 优化：如果某一轮排序中没有发生元素交换，则已经有序
 * 时间复杂度（最大&平均） n*n
 */
public class Bubble {

    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 4, 6, 2, 8, 3, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        int temp;
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            //没有发生交换，证明已经有序
            if (flag){
                break;
            }
        }
    }
}
