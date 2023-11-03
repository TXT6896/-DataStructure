package com.tao.digui;

/**
 * 迷宫回溯问题
 */
public class Maze {


    public static void main(String[] args) {
        int[][] map = getMap();
        showMap(map);
        getWay(map, 2, 2);
        System.out.println("=====================================");
        showMap(map);
    }

    /**
     * 创建一个地图
     *
     * @return
     */
    public static int[][] getMap() {
        int[][] map = new int[8][7];
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[i].length - 1] = 1;
        }
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[5][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;
        return map;
    }

    /**
     * 展示地图
     *
     * @param map
     */
    public static void showMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length; i1++) {
                System.out.print(" " + map[i][i1]);
            }
            System.out.println();
        }
    }

    /**
     * 获取路径 0、未走过 1、墙壁 2、走过 3、走不通
     * 移动规则 下右上左
     *
     * @param map
     * @param i   起点
     * @param j
     * @return
     */
    public static boolean getWay(int[][] map, int i, int j) {
        //判断到达终点（临界条件）
        if (map[6][5] == 2) {
            return true;
        }
        //判断能否走
        if (map[i][j]!=0){
            return false;
        }
        //假定当前位置可以走通
        map[i][j] = 2;
        if (getWay(map, i + 1, j)) {
            return true;
        }
        if (getWay(map, i, j + 1)) {
            return true;
        }
        if (getWay(map, i - 1, j)) {
            return true;
        }
        if (getWay(map, i, j - 1)) {
            return true;
        }
        //都走不通
        map[i][j] = 3;
        return false;
    }
}
