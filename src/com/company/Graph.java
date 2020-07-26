package com.company;

public class Graph {
    private Integer[][] AdjacencyMatrix;
    private int[] Vertexes;
    public Graph(int vertexes) {
        AdjacencyMatrix = new Integer[vertexes][vertexes];
        Vertexes =new int[vertexes];
        for (int i = 0; i< vertexes; i++){
            Vertexes[i] = i;
        }
    }
    public Graph() {
    }
    public void CreateRandomGraph(){
        if (AdjacencyMatrix == null) AdjacencyMatrix = new Integer[5][5];
        this.addAdjacencyEdge(0, 1, 10);
        this.addAdjacencyEdge(0, 3, 30);
        this.addAdjacencyEdge(0, 4, 100);
        this.addAdjacencyEdge(1, 2, 50);
        this.addAdjacencyEdge(2, 4, 10);
        this.addAdjacencyEdge(3, 2, 20);
        this.addAdjacencyEdge(3, 4, 60);
        Vertexes =new int[5];
        for (int i = 0; i< 5; i++){
            Vertexes[i] = i;
        }
    }

    public void addAdjacencyEdge(int start, int end, int weight){
        AdjacencyMatrix[start][end] = weight;
    }
    public int getAdjacencyWeight(int start, int end){
        return AdjacencyMatrix[start][end];
    }

    public Integer[][] getAdjacencyMatrix() {
        return AdjacencyMatrix;
    }

    public int[] getVertexes() {
        return Vertexes;
    }
}
