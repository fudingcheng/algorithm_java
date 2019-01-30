package cn.itcast.link;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-30
 * @description:
 */
public class DoubleLinkList {

    /**
     * 头结点
     */
    private DoubleNode first;

    /**
     * 尾节点
     */
    private DoubleNode last;

    public DoubleLinkList() {
        first = null;
        last = null;
    }

    /**
     * 插入头节点
     */
    public void insertFirst(long value) {
        DoubleNode node = new DoubleNode(value);
        if (isEmpty()) {
            last = node;
        } else {
            first.previous = node;
        }
        node.next = first;
        first = node;
    }

    /**
     * 插入尾节点
     *
     * @param value
     */
    public void insertLast(long value) {
        DoubleNode node = new DoubleNode(value);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
            node.previous = last;
        }
        last = node;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public DoubleNode deleteFirst() {
        DoubleNode temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = temp.next;
        return temp;
    }

    /**
     * 删除尾节点
     *
     * @return
     */
    public DoubleNode deleteLast() {
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return last;
    }

    /**
     * 显示方法
     */
    public void display() {
        DoubleNode current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 删除节点
     *
     * @param value
     * @return
     */
    public DoubleNode delete(long value) {
        DoubleNode current = first;
        while (current.value != value) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            current.previous.next = current.next;
        }
        return current;
    }


    public boolean isEmpty() {
        return first == null;
    }

    @Test
    public void test() {
        DoubleLinkList list = new DoubleLinkList();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.display();
        list.delete(2);
        list.display();
        list.insertLast(4);
        list.display();
        list.deleteFirst();
        list.deleteLast();
        list.display();
    }
}
