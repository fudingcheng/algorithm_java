package cn.itcast.link;

/**
 * @author:fudingcheng
 * @date:2019-01-27
 * @description: 链表节点
 */
public class Node {
    public long value;
    public Node next;

    public Node(long value) {
        this.value = value;
    }

    public void display() {
        System.out.print(value+" ");
    }

}
