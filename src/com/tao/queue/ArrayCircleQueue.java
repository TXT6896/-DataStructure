package com.tao.queue;

import java.math.BigDecimal;

/**
 * 数组模拟环形队列
 */
public class ArrayCircleQueue {
    //队首
    private int first;
    //队尾
    private int end;
    //可通过公式 size = (end - first + queue.length) % queue.length 计算得到
    private int size;
    private int[] queue;

    public static void main(String[] args) {
/*        ArrayCircleQueue arrayCircleQueue = new ArrayCircleQueue(3);
        System.out.println(arrayCircleQueue.isEmpty());
        arrayCircleQueue.add(1);
        arrayCircleQueue.showData();
        arrayCircleQueue.add(2);
        arrayCircleQueue.showData();
        arrayCircleQueue.add(3);
        arrayCircleQueue.showData();
        System.out.println(arrayCircleQueue.isFull());
        System.out.println(arrayCircleQueue.get());
        arrayCircleQueue.showData();
        System.out.println(arrayCircleQueue.isFull());
        arrayCircleQueue.add(4);
        arrayCircleQueue.showData();*/
        String s = "";
        System.out.println(s.isEmpty());

    }

    /**
     * 初始化队列
     */
    public ArrayCircleQueue(int size) {
        queue = new int[size + 1];
        this.size = 0;
        first = 0; //指向队列中队首元素位置
        end = 0; //指向队列中队尾元素后一位
    }

    /**
     * 判断队列是否为空
     * ps:队首等于队尾
     */
    public boolean isEmpty() {
        //return size == 0;
        return first == end;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        //return size == queue.length - 1;
        return (end + 1) % queue.length == first;
    }

    /**
     * 入队
     */
    public void add(int value) {
        //队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        queue[end] = value;
        end = (end + 1) % queue.length;
        size++;
    }

    /**
     * 出队
     */
    public int get() {
        //队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int res = queue[first];
        first = (first + 1) % 5;
        size--;
        return res;
    }

    /**
     * 显示队列所有元素
     */
    public void showData() {
        for (int i = first; i < first + size; i++) {
            System.out.print(" " + queue[i % queue.length]);
        }
        System.out.println();
    }


}
