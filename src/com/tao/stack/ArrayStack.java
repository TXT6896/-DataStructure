package com.tao.stack;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 数组实现栈
 */
public class ArrayStack<T> {
    private T[] arr;
    private int number;

    public static void main(String[] args) throws ParseException {
        ArrayStack<String> stack = new ArrayStack<>(String.class,3);
        stack.push("123");
        stack.push("456");
        stack.push("789");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    public ArrayStack(Class<T> type, int deep) {
        this.number = 0;
        this.arr = (T[]) Array.newInstance(type, deep);
    }

    /**
     * 入栈
     *
     * @param data
     */
    public void push(T data) {
        if (number == arr.length) {
            throw  new RuntimeException("栈空间已满，无法放入更多元素");
        }
        arr[number++] = data;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        if (number == 0){
            throw new RuntimeException("栈元素为空");
        }
        return arr[--number];
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public T getTop(){
        T pop = this.pop();
        this.push(pop);
        return pop;
    }

    public boolean isEmpty(){
        return number == 0;
    }
}
