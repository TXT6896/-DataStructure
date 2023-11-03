package com.tao.stack;

import com.tao.linked.LinkedList;

import java.security.PrivateKey;

public class LinkedStack<T> {

    private Node first;
    private int number;
    private int maxDeep;

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>(3);
        stack.push("123");
        stack.push("456");
        stack.push("789");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    public LinkedStack(int deep){
       this.number = 0;
       this.maxDeep = deep;
    }

    /**
     * 入栈
     * @param data
     */
    public void push(T data){
        if (number == maxDeep) {
            throw  new RuntimeException("栈空间已满，无法放入更多元素");
        }
        Node<T> node = new Node<>();
        node.value = data;
        node.next = first;
        first = node;
        number++;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        if (number == 0) {
            throw  new RuntimeException("栈元素为空");
        }
        Node<T> target = first;
        first = first.next;
        target.next = null;
        number--;
        return target.value;
    }

    class Node<T>{
        private T value;
        private Node next;
    }
}
