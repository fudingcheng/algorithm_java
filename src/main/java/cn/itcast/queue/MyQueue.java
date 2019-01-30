package cn.itcast.queue;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-22
 * @description:
 */
public class MyQueue {

    /**
     * 底层使用数组实现
     */
    private long[] arr;

    /**
     * 元素数量
     */
    private int elements;

    /**
     * 队头
     */
    private int front;


    /**
     * 队尾
     */
    private int end;

    public MyQueue() {
        arr = new long[10];
        elements = 0;
        front = 0;
        end = -1;
    }

    public MyQueue(int maxSize) {
        arr = new long[maxSize];
        elements = 0;
        front = 0;
        end = -1;
    }

    /**
     * 添加元素
     *
     * @param value
     */
    public void insert(long value) {
        if (end>=arr.length-1) {
            end=-1;
        }else{
            elements++;
        }
        arr[++end] = value;
    }

    /**
     * 移除元素
     *
     * @return
     */
    public long remove() {
        long value = arr[front++];
        if(front>=arr.length){
            front=0;
        }
        elements--;
        return value;
    }

    /**
     * 查看数据
     *
     * @return
     */
    public long peek() {
        return arr[front];
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return elements == 0;
    }

    /**
     * 判断是否已满
     *
     * @return
     */
    public boolean isFull() {
        return elements == arr.length;
    }

    @Test
    public void testQueue() {
        MyQueue queue = new MyQueue(4);
        queue.insert(11);
        queue.insert(22);
        queue.insert(33);
        queue.insert(44);
        queue.insert(55);

        System.out.println(queue.peek());
        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());

    }

}
