package cn.itcast.stack;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-22
 * @description:
 */
public class MyStack {
    /**
     * 底层是数组实现
     */
    private long[] arr;
    /**
     * 栈顶指针
     */
    private int top;

    public MyStack() {
        arr = new long[10];
        top = -1;
    }

    public MyStack(int length) {
        arr = new long[length];
        top = -1;
    }

    /**
     * 插入元素
     *
     * @param value
     */
    public void push(long value) {
        arr[++top] = value;
    }

    /**
     * 移除元素
     */
    public long pop() {
        return arr[top--];
    }

    /**
     * 查看元素
     *
     * @return
     */
    public long peek() {
        return arr[top];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 判断栈是否满了
     */
    public boolean isFull(){
        return top==arr.length-1;
    }



    @Test
    public void test(){
        MyStack myStack = new MyStack(5);
        myStack.push(23);
        myStack.push(21);
        myStack.push(43);
        myStack.push(56);
        myStack.push(44);

        System.out.println(myStack.isEmpty());
        System.out.println(myStack.isFull());

        while (!myStack.isEmpty()){
            System.out.print(myStack.pop()+",");
        }
        System.out.println();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.isFull());


    }

}
