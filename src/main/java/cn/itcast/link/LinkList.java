package cn.itcast.link;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-30
 * @description:单链表
 */
public class LinkList {
    /**
     * 头结点
     */
    private Node first;

    public LinkList() {
        first = null;
    }

    /**
     * 插入头结点
     *
     * @param value
     */
    public void insertFirst(long value) {
        Node node = new Node(value);
        node.next = first;
        first = node;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public Node deleteFirst() {
        Node tmp = first;
        first = tmp.next;
        return tmp;
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
        if (current == null) {
            return null;
        }
        while (current.value != value) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * 删除节点
     * @param value
     * @return
     */
    public Node delete(long value) {
        Node current = first;
        Node previous = first;
        //找到值为value的前节点
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

    @Test
    public void test() {
        LinkList linkList = new LinkList();
        linkList.insertFirst(1);
        linkList.insertFirst(2);
        linkList.insertFirst(3);
        linkList.display();
        /*Node node = linkList.find(2);
        if (node != null) {
            node.display();
        }*/
        linkList.deleteFirst();
        linkList.display();

        linkList.delete(2);
        linkList.display();
    }

}
