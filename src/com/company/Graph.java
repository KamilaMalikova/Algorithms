package com.company;

public class Graph {
    private int[][] AdjacencyMatrix;

    public Graph(int vertexes) {
        AdjacencyMatrix = new int[vertexes][vertexes];
    }
    public Graph() {
    }
    public void CreateRandomGraph(){
        if (AdjacencyMatrix == null) AdjacencyMatrix = new int[5][5];
        this.addAdjacencyEdge(0, 1, 10);
        this.addAdjacencyEdge(0, 3, 30);
        this.addAdjacencyEdge(0, 4, 100);
        this.addAdjacencyEdge(1, 2, 50);
        this.addAdjacencyEdge(2, 4, 10);
        this.addAdjacencyEdge(3, 2, 20);
        this.addAdjacencyEdge(3, 4, 60);

    }

    public void addAdjacencyEdge(int start, int end, int weight){
        AdjacencyMatrix[start][end] = weight;
    }
    public int getAdjacencyWeight(int start, int end){
        return AdjacencyMatrix[start][end];
    }

    public int[][] getAdjacencyMatrix() {
        return AdjacencyMatrix;
    }
}
