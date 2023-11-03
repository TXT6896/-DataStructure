package com.tao.digui;

/**
 * 八皇后问题
 */
public class EightQueen {

    /**
     * 一维数组，下表等于行数，值等于列数
     */
    private static int[] arr = new int[8];
    private static int count = 0;
    private static int num = 0;

    public static void main(String[] args) {
        System.out.println(arr[4]);
        check(6);
        System.out.println("共判断计算： "+num);
    }

    /**
     * 放置皇后
     *
     * @param n
     */
    public static void check(int n) {
        //等于8证明放置完毕
        if (n == 8) {
            print();
            System.out.println(++count);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[n] = i;
            if (allowPlace(n)) {
                check(n + 1);
            }
        }

    }

    /**
     * 判断是否与之前的皇后位置冲突（不同行、不同列、不同斜线）
     *
     * @param n 第n个皇后
     * @return
     */
    public static boolean allowPlace(int n) {
        for (int i = 0; i < n; i++) {
            num++;
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

}
