package cn.itcast.link;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-30
 * @description:双端链表
 */
public class FirstLastLinkList {

    /**
     * 头结点
     */
    private Node first;
    /**
     * 尾节点
     */
    private Node last;

    public FirstLastLinkList() {
        this.first = null;
        this.last = null;
    }


    /**
     * 插入节点,从头节点后进行插入
     *
     * @param value
     */
    public void insertFirst(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            last = node;
        }
        node.next = first;
        first = node;
    }

    /**
     * 插入节点,从尾部插入
     *
     * @param value
     */
    public void insertLast(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    /**
     * 从头部删除节点
     *
     * @return
     */
    public Node deleteFirst() {
        Node temp = first;
        if (first.next == null) {
            last = null;
        }
        first = temp.next;
        return temp;
    }


    /**
     * 显示方法
     */
    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 查找方法
     *
     * @param value
     * @return
     */
    public Node find(long value) {
        Node current = first;
        while (current.value != value) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * 删除节点
     *
     * @param value
     * @return
     */
    public Node delete(long value) {
        Node current = first;
        Node previous = first;
        while (current.value != value) {
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    @Test
    public void test() {
        FirstLastLinkList firstLastLinkList = new FirstLastLinkList();
        firstLastLinkList.insertLast(1);
        firstLastLinkList.insertLast(2);
        firstLastLinkList.insertLast(3);

        System.out.println(firstLastLinkList.isEmpty());

    }

}
