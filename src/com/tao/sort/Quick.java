package com.tao.sort;

import com.tao.stack.ArrayStack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 快速排序
 * 时间复杂度(最好|平均|最坏) O(nlog2n)|O(nlog2n)|O(n*n)
 */
public class Quick {

    public static void main(String[] args) {

        int[] arr = new int[1000];
        int[] arr2 = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            arr[i] = random.nextInt();
            arr2[i] = arr[i];
        }
        Arrays.sort(arr);
        sort(arr2, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr).equals(Arrays.toString(arr2)));

    }


    public static void sort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        /*int randomINdex = left + (int) (Math.random() * (right - left));*/
        int i1 = left;
        int i2 = right;
        while (i1 < i2) {
            while (arr[i2] > arr[left] && i1 < i2) {
                i2--;
            }
            while (arr[i1] < arr[left] && i1 < i2) {
                i1++;
            }

//            if (i1<i2){
            int temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
            //           }
        }
        sort(arr, left, i2 - 1);
        sort(arr, i2 + 1, right);
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(arr, randomIndex, right);
        int[] equalX = partition(arr, left, right);
        process(arr, left, equalX[0] - 1);
        process(arr, equalX[1] + 1, right);
    }

    private static int[] partition(int[] arr, int left, int right) {
        int lessX = left - 1;
        int moreX = right;
        int index = left;
        while (index < moreX) {
            if (arr[index] < arr[right]) {
                swap(arr, ++lessX, index++);
            } else if (arr[index] > arr[right]) {
                swap(arr, --moreX, index);
            } else {
                index++;
            }
        }
        swap(arr, moreX, right);
        return new int[]{lessX + 1, moreX};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
