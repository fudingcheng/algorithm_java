package cn.itcast.tree;

/**
 * @author:fudingcheng
 * @date:2019-02-01
 * @description: 二叉数节点
 */
public class Node {
    /**
     * 数据项
     */
    public long data;

    /**
     * 数据项
     */
    public String sData;

    /**
     * 左节点
     */
    public Node leftChild;
    /**
     * 右节点
     */
    public Node rightChild;

    /**
     * 构造方法
     *
     * @param data
     * @param sDate
     */
    public Node(long data, String sDate) {
        this.data = data;
        this.sData = sDate;
    }
}
