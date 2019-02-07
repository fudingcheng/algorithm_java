package cn.itcast.hash.linkedList;

import cn.itcast.hash.Info;

/**
 * @author:fudingcheng
 * @date:2019-02-06
 * @description: 节点
 */
public class Node {
    /**
     * 数据域
     */
    public Info info;
    /**
     * 指针域
     */
    public Node next;

    public Node(Info info) {
        this.info = info;
    }
}
