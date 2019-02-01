package cn.itcast.tree;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-02-01
 * @description: 有序二叉树
 */
public class OrderedBinaryTree {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 插入节点
     *
     * @param value
     */
    public void insert(long value, String sValue) {
        //封装节点
        Node newNode = new Node(value, sValue);
        //引用当前节点
        Node current = root;
        //应用父节点
        Node parent;
        //如果root为null,第一次插入的时候
        if (root == null) {
            root = newNode;
            return;
        } else {    //非第一次插入
            //遍历树
            while (true) {
                //父节点指向当前节点
                parent = current;
                if (current.data > value) {
                    //如果当前指向的节点数据比插入的数据大,则走向左子树
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    //如果当前指向的节点的数据比插入数据小,则走向右子树
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找节点
     *
     * @param value
     */
    public Node find(long value) {
        //应用当前节点,从根节点开始
        Node current = root;
        //循环,只要查找值不等于当前节点的数据项就一致查找
        while (current.data != value) {
            //进行比较,如果当前节点的值大于查找值,则走向左子树
            if (current.data > value) {
                current = current.leftChild;
            } else {    //如果当前节点的值小于查找值,则走向右子树
                current = current.rightChild;
            }
            //如果查不到,返回null
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    /**
     * 前序遍历:
     * (1)访问根节点
     * (2)先序遍历左子树
     * (3)先序遍历右子树
     *
     * @param localNode
     */
    public void frontOrder(Node localNode) {
        if (localNode != null) {
            //访问根节点
            System.out.println(localNode.data + "," + localNode.sData);
            //前序遍历左子树
            frontOrder(localNode.leftChild);
            //前序遍历右子树
            frontOrder(localNode.rightChild);
        }
    }

    /**
     * 中序遍历
     * (1)中序遍历左子树
     * (2)访问根节点
     * (3)中序遍历右子树
     *
     * @param localNode
     */
    public void inOrder(Node localNode) {
        if (localNode != null) {
            //中序遍历左子树
            inOrder(localNode.leftChild);
            //访问根节点
            System.out.println(localNode.data + "," + localNode.sData);
            //中序遍历右子树
            inOrder(localNode.rightChild);
        }
    }

    /**
     * 后续遍历
     * (1)后序遍历左子树
     * (2)后序遍历右子树
     * (3)访问根节点
     *
     * @param localNode
     */
    public void afterOrder(Node localNode) {
        if (localNode != null) {
            //后续遍历左子树
            afterOrder(localNode.leftChild);
            //后续遍历右子树
            afterOrder(localNode.rightChild);
            //访问根节点
            System.out.println(localNode.data + "," + localNode.sData);
        }
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public boolean delete(long value) {
        //引用当前节点,从根节点开始
        Node current = root;
        //应用当前节点的父节点
        Node parent = root;
        //当前是否为左节点标记
        boolean isLeftChild = true;
        //查找节点
        while (current.data != value) {
            parent = current;
            if (current.data > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }

            if (current == null) {
                return false;
            }
        }
        //如果是叶子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {    //单支节点,左节点为空
            if (current == root) {
                root = root.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }

        } else if (current.leftChild == null) {     //单支节点,左节点为空
            if (current == root) {
                root = root.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {  //如果是双支节点
            //1.查找后继节点
            //2.删除后继结点
            //3.让后继结点的父节点称为其右子树的父节点
            //4.让后继节点替代待删除的节点
            Node successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.leftChild = successor;
            } else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     * 查找后继节点
     *
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        //引用后继节点
        Node successor = delNode;
        //应用后继节点父节点
        Node successorParent = delNode;
        //引用当前节点
        Node current = delNode.rightChild;

        //走向左子树,查找后继节点
        while (current!=null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        //判断是否找到
        if(successor!=delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }


    @Test
    public void testTree() {
        OrderedBinaryTree tree = new OrderedBinaryTree();
        tree.insert(8, "a");
        tree.insert(10, "b");
        tree.insert(6, "c");
        tree.insert(5, "d");
        tree.insert(9, "e");
        tree.insert(4, "f");

        tree.frontOrder(tree.root);
        System.out.println("-------------------------");
        tree.inOrder(tree.root);
        System.out.println("-------------------------");
        tree.afterOrder(tree.root);

    }

}
