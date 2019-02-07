package cn.itcast.graph;

import cn.itcast.link.FirstLastLinkList;
import cn.itcast.link.LinkList;
import cn.itcast.queue.MyQueue;
import cn.itcast.stack.MyStack;
import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-02-07
 * @description: 图
 */
public class Graph {

    /**
     * 顶点数组
     */
    private Vertex[] vertexList;

    /**
     * 临接矩阵
     */
    private int[][] adjMat;

    /**
     * 顶点的最大数量
     */
    private int maxSize = 20;

    /**
     * 当前顶点数量
     */
    private int nVertex;

    /**
     * 栈
     */
    private MyStack stack;

    /**
     * 队列
     */
    private MyQueue queue;


    public Graph() {
        vertexList = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0;
        stack = new MyStack();
        queue = new MyQueue();
    }

    /**
     * 添加顶点
     *
     * @param label
     */
    public void addVertex(char label) {
        vertexList[nVertex++] = new Vertex(label);
    }

    /**
     * 添加边
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    /**
     * 深度优先搜索
     */
    public void dfs() {
        //首先访问0号顶点
        vertexList[0].isVisited = true;
        //显示该顶点
        displayVertex(0);
        //压入栈中
        stack.push(0);
        //遍历
        while (!stack.isEmpty()) {
            //获得一个未访问过的临接点
            int v = getAdjUnVisitedVertex((int) stack.peek());
            //如果已经访问过,则弹栈
            if (v == -1) {
                stack.pop();
            } else {   //未访问过,则标记,并压入栈中
                vertexList[v].isVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        //搜索完毕后,将节点的状态改为已经访问
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].isVisited = true;
        }

    }

    /**
     * 广度优先搜索
     */
    public void wfs() {
        //首先访问0号顶点
        vertexList[0].isVisited = true;
        //显示该顶点
        displayVertex(0);
        //放入队列中
        queue.insert(0);
        //遍历
        while (!queue.isEmpty()) {
            int v = getAdjUnVisitedVertex((int) queue.peek());
            if (v == -1) {
                queue.remove();
            } else {
                vertexList[v].isVisited = true;
                displayVertex(v);
                queue.insert(v);
            }
        }

        //搜索完毕后,将节点的状态改为已经访问
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].isVisited = true;
        }
    }

    /**
     * 访问临接节点
     *
     * @param v
     * @return
     */
    private int getAdjUnVisitedVertex(int v) {
        for (int i = 0; i < nVertex; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].isVisited == false) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 显示顶点信息
     *
     * @param i
     */
    public void displayVertex(int i) {
        System.out.print(vertexList[i].label);
    }

    /**
     * 最小生成树
     */
    public void mst() {
        //首先访问0号节点
        vertexList[0].isVisited = true;
        //压入栈中
        stack.push(0);
        while (!stack.isEmpty()) {
            int currentVertex = (int) stack.peek();
            //获得一个未访问过的临接点
            int v = getAdjUnVisitedVertex(currentVertex);
            if (v == -1) {
                //弹出一个顶点
                stack.pop();
            } else {
                vertexList[v].isVisited = true;
                stack.push(v);
                displayVertex(currentVertex);
                System.out.print("-");
                displayVertex(v);
                System.out.print(" ");
            }
        }
    }

    @Test
    public void testGraph() {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');


        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        //graph.dfs();
        System.out.println("------------------");
        //graph.wfs();

        graph.mst();
    }


}
