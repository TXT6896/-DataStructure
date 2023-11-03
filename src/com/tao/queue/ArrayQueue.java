package com.tao.queue;

/**
 * 数组的方式实现队列(无实际意义)
 */
public class ArrayQueue {
    //队首
    private int first;
    //队尾
    private int end;
    private int size;
    private int[] queue;

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(1);
        arrayQueue.add(10);
        arrayQueue.showData();
        System.out.println(arrayQueue.isFull());
        System.out.println(arrayQueue.getHead());
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.add(20);

    }

    /**
     * 初始化队列
     */
    public ArrayQueue(int size) {
        this.size = size;
        queue = new int[size];
        first = -1; //指向队列中最前元素前一位
        end = -1; //指向队列中最后元素当前位置
    }

    /**
     * 判断队列是否为空
     * ps:队首等于队尾
     */
    public boolean isEmpty() {
        return first == end;
    }

    /**
     * 判断队列是否已满
     * ps:队尾等于队列最大值
     */
    public boolean isFull() {
        return size - 1 == end;
    }

    /**
     * 入队
     */
    public void add(int value) {
        //队列是否已满
        if (isFull()){
            throw new RuntimeException("队列已满");
        }
        queue[++end] = value;
    }

    /**
     * 出队
     */
    public int get(){
       //队列是否为空
       if (isEmpty()){
           throw new RuntimeException("队列为空");
       }
       return queue[++first];
    }

    /**
     * 显示队列所有元素
     */
    public void showData(){
        for (int i = first+1; i < end+1; i++) {
            System.out.print(" "+queue[i]);
        }
    }

    /**
     * 获取头数据
     */
    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return queue[first+1];
    }

}


