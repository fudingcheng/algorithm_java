package cn.itcast.hash.linkedList;

import cn.itcast.hash.Info;

/**
 * @author:fudingcheng
 * @date:2019-02-06
 * @description: 链表
 */
public class LinkList {

    /**
     * 头结点指针
     */
    private Node first;

    public LinkList() {
        first = null;
    }

    /**
     * 在头结点后插入节点
     *
     * @param info
     */
    public void insertFirst(Info info) {
        Node node = new Node(info);
        node.next = first;
        first = node;
    }

    /**
     * 删除节点
     *
     * @return
     */
    public Node deleteFirst() {
        Node tmp = first;
        first = tmp.next;
        return tmp;
    }

    /**
     * 查找方法
     *
     * @param key
     * @return
     */
    public Node find(String key) {
        Node current = first;
        while (!key.equals(current.info.getKey())) {
            if (current.next == null) {
                return null;
            }
            current = first.next;
        }
        return current;
    }

    /**
     * 删除方法
     *
     * @param key
     * @return
     */
    public Node delete(String key) {
        Node current = first;
        Node previous = first;
        while (!key.equals(current.info.getKey())) {
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

}
