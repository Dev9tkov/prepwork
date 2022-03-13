package com.prep.graph;

import com.prep.stack.Stack;
import lombok.Data;

@Data
public class Graph {

    private int maxN = 6;
    private int[][] mas;
    Vertex[] vertexList;
    private int curN;
    private Stack stack;

    public Graph() {
        vertexList = new Vertex[maxN];
        mas = new int[maxN][maxN];
        curN = 0;
        stack = new Stack();
    }

    public void addVertex(char name) {
        vertexList[curN++] = new Vertex(name);
    }

    public void addEdge(int start, int end, int val) {
        mas[start][end] = 1;
        mas[end][start] = val;
    }

    /**
     * @param v индекс вершины в массиве вершин
     */
    public int check(int v) {
        for (int i = 0; i < curN; i++) {
            if (mas[v][i] == 1 && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    public void deepFirst(int index) {
        System.out.println(vertexList[index].name);
        vertexList[index].isVisited = true;
        stack.push(index);
        while (!stack.isEmpty()) {
            int neigh = check(stack.peek());
            if (neigh == -1) {
                neigh = stack.pop();
            } else {
                System.out.println(vertexList[neigh].name);
                vertexList[neigh].isVisited = true;
                stack.push(neigh);
            }
        }
        for (int i = 0; i < curN; i++) {
            vertexList[i].isVisited = false;
        }

    }

    @Data
    static class Vertex {

        private char name;
        private boolean isVisited;

        public Vertex(char name) {
            this.name = name;
            this.isVisited = false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5

        graph.addEdge(0, 1, 1); //AB
        graph.addEdge(1, 2, 1); //BC
        graph.addEdge(2, 3, 1); //CD
        graph.addEdge(0, 4, 1); //AE
        graph.addEdge(4, 5, 1); //EF

        graph.deepFirst(0);

    }
}
