package com.tao.array;

import java.util.Arrays;

/**
 * 稀疏数组
 */
public class sparseArray {
    public static void main(String[] args) {
        //原始数组
        int[][] arr = new int[10][10];
        arr[2][2] = 1;
        arr[3][3] = 2;
        arr[5][1] = 7;
        Arrays.stream(arr).forEach(obj -> {
            Arrays.stream(obj).forEach(a -> {
                System.out.print(" "+a);
            });
            System.out.println();
        });
        //1.获取原始数组有效值个数
        int count = 0;
        for (int[] ar : arr) {
            for (int a : ar) {
                if (a>0) ++count;
            }
        }
        //2.创建对应的稀疏数组
        int[][] sparse = new int[count + 1][3];
        //2.1 第一行值
        sparse[0][0] = arr.length;
        sparse[0][1] = arr[0].length;
        sparse[0][2] = count;

        //2.2 保存有效值
        count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                if (arr[i][i1] > 0){
                    sparse[count][0] = i;
                    sparse[count][1] = i1;
                    sparse[count][2] = arr[i][i1];
                    count++;
                }
            }
        }

        Arrays.stream(sparse).forEach(obj -> {
            Arrays.stream(obj).forEach(a -> {
                System.out.print(" "+a);
            });
            System.out.println();
        });

        //3. 稀疏转二维
        int[][] res = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 0; i < sparse[0][2]; i++) {
            res[sparse[i+1][0]][sparse[i+1][1]] = sparse[i+1][2];
        }
        Arrays.stream(res).forEach(obj -> {
            Arrays.stream(obj).forEach(a -> {
                System.out.print(" "+a);
            });
            System.out.println();
        });
    }
}
