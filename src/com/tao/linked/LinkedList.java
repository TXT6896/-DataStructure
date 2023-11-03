package com.tao.linked;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * 双向链表
 *
 * @param <T>
 */
public class LinkedList<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;


    public static void main(String[] args) {
/*        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("123");
        linkedList.add("456");
        linkedList.add("789");
        linkedList.showData();
        linkedList.remove(0);
        linkedList.showData();
        linkedList.remove(1);
        linkedList.showData();
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));*/
    }

    /**
     * 添加元素
     *
     * @param
     */
    public void add(T val) {
        Node<T> node = new Node<>(val);

        if (size == 0) {
            first = node;
            last = node;
            size++;
            return;
        }
        last.next = node;
        node.pre = last;
        last = node;
        size++;
    }

    /**
     * 删除元素
     *
     * @param index 删除元素下标
     */
    public void remove(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node temp = first;
        for (int i = 0; i < index + 1; i++) {
            if (i == index) {
                if (temp.pre != null && temp.next != null) {
                    temp.pre.next = temp.next;
                    temp.next.pre = temp.pre;
                }
                //链表长度为1
                if (temp.pre == null && temp.next == null) {
                    first = null;
                    last = null;
                    break;
                }
                //链表头
                if (temp.pre == null) {
                    first = temp.next;
                    temp.next.pre = null;
                }
                //链表尾
                if (temp.next == null) {
                    last = temp.pre;
                    temp.pre.next = null;
                }
                break;
            }
            temp = temp.next;
        }
        size--;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            return first.val;
        }
        if (index == size - 1) {
            return last.val;
        }
        Node<T> temp = first;
        for (int i = 0; i < index + 1; i++) {
            if (i == index) {
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * 清空链表
     *
     * @return
     */
    public int clear() {
        first = null;
        last = null;
        int res = size;
        size = 0;
        return res;
    }

    public void showData() {
        if (size == 0) {
            throw new RuntimeException("集合为空");
        }
        Node<T> temp = first;
        while (temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    private static class Node<T> {
        private T val;
        private Node next;
        private Node pre;

        public Node(T val) {
            this.val = val;
        }
    }
}
