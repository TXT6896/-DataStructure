package com.tao.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度O(nlogn)
 */
public class Merge {

    private static int[] temp;

    public static void main(String[] args) {
        int[] arr= new int[]{1, 9, 5, 3, 2, 6, 4,-19,78, 7, 8};
        temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }


    public static void merge(int[] arr, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        //左指针
        int i1 = left;
        //右指针
        int i2 = mid + 1;
        //辅助数组指针
        int i3 = left;

        //1.两个分组都没有遍历完成，对比大小将较小（较大）填入辅助数组
        while (i1 <= mid && i2 <= right) {

            if (arr[i1] <= arr[i2]) {
                temp[i3++] = arr[i1++];
            } else {
                temp[i3++] = arr[i2++];
            }
        }
        //2.某一个分组走完，将另一个分组按顺序填入辅助数组
        while (i1 <= mid) {
            temp[i3++] = arr[i1++];
        }
        while (i2 <= right) {
            temp[i3++] = arr[i2++];
        }
        //3.将辅助数组填入原始数组
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
