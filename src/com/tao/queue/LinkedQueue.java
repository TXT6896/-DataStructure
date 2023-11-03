package com.tao.queue;

/**
 * 链表实现队列
 */
public class LinkedQueue<T> {

    private int size;
    private int maxSize;
    private Node first;
    private Node end;

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>(3);
        System.out.println(queue.isEmpty());
        queue.add("123");
        queue.add("456");
        queue.add("789");
        System.out.println(queue.isFull());
        queue.showData();
        //queue.add("000");
        System.out.println(queue.get());
        queue.showData();
        queue.add("000");
        queue.showData();
        System.out.println(queue.get());
        queue.add("666");
        queue.showData();
        queue.add("999");
    }

    public LinkedQueue(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
    }

    /**
     * 判断队列已满
     */
    public boolean isFull() {
        return size == maxSize;
    }

    /**
     * 判断队列为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     */
    public void add(T val) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        Node<T> node = new Node<>(val);
        if (isEmpty()) {
            first = node;
            end = node;
        }
        end.next = node;
        end = node;
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    public T get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        Node<T> res = first;
        first = first.next;
        size--;
        return res.currVal;
    }

    /**
     * 展示所有元素
     */
    public void showData(){
        if (isEmpty()) {
            return;
        }
        Node curr = first;
        while(curr.next != null){
            System.out.print(curr.currVal+" ");
            curr = curr.next;
        }
        System.out.println(curr.currVal);
    }

    private static class Node<T> {
        private T currVal;
        private Node next;

        public Node(T currVal) {
            this.currVal = currVal;
        }

        public T getCurrVal() {
            return currVal;
        }

        public void setCurrVal(T currVal) {
            this.currVal = currVal;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
