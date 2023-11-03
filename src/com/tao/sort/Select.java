package com.tao.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次排序从待排序数中找到最小（最大）的数，并与待排序数中索引最小处的数交换位置
 * 进行下一轮排序时，不包括已排序的数
 * 时间复杂度（最大&平均） n*n
 */
public class Select {

    public static void main(String[] args) {
        int[] arr = {1, 5,-1, 9, 4, 6, 2, 8, 3, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length-1; j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp;
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
