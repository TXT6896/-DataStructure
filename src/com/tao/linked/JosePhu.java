package com.tao.linked;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 约瑟夫问题
 */
public class JosePhu {

    public static void main(String[] args) {
        SingleCircleLinkedList list = new SingleCircleLinkedList(5);
        list.play(1,2);
    }

    private static class SingleCircleLinkedList {

        private Node first;
        private int size;

        /**
         * 创建环形单向链表
         *
         * @param nums 游戏人数
         */
        public SingleCircleLinkedList(int nums) {
            if (nums < 1) {
                System.out.println("初始化错误，输入值不正确");
            }
            Node curr = new Node(1);
            first = curr;
            for (int i = 2; i < nums + 1; i++) {
                Node node = new Node(i);
                curr.next = node;
                curr = node;
            }
            curr.next = first;
            size = nums;

        }

        /**
         * 开始游戏
         *
         * @param begin 从谁开始
         * @param num   数多少
         */
        public void play(int begin, int num) {
            if (begin < 1 || begin > size || num < 1){
                System.out.println("游戏无法开始，规则定义有误");
            }
            //找到开始的同学的上一位同学
            Node before = first;
            while(true){
                if (before.next.no == begin){
                    break;
                }
                before = before.next;
            }
            Node curr = before.next;
            //开始
            int count = 0;
            while (true){
                count++;
                //找到被踢同学
                if (count == num){
                    System.out.println(curr.no);
                    curr = curr.next;
                    before.next = curr;
                    count = 0;

                }else {
                    curr = curr.next;
                    before = before.next;
                }

                //最后一名同学，游戏结束
                if (curr == before){
                    System.out.println(curr.no);
                    break;
                }
            }
        }


        class Node {
            private int no;
            private Node next;

            public Node(int no) {
                this.no = no;
            }
        }
    }
}
