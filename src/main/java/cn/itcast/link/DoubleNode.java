package cn.itcast.link;

/**
 * @author:fudingcheng
 * @date:2019-01-30
 * @description: 双向链表节点
 */
public class DoubleNode {

    public long value;

    public DoubleNode next;
    public DoubleNode previous;

    public DoubleNode(long value) {
        this.value = value;
    }

    public void display() {
        System.out.print(value + " ");
    }
}
