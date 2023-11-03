package com.tao.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 假设前(n-1)个元素已经有序，将第n个元素插入已经有序的元素中
 * 最坏时间复杂度O(n*n)，最小时间复杂度 O(n)
 */
public class Insert {

    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 4, 6, 2,-1,88, 8, 3, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
