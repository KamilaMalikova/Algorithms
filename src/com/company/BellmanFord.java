package com.company;

import org.w3c.dom.Entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BellmanFord {
    //Vertex
        //weight (default - MAX_INT)
        //Map(Vertex, Edge(weight))
    //Edges
    //Bellman - Ford

    public Vertex[] CreateGraph(){
        Vertex vertex_0 = new Vertex();
        Vertex vertex_1 = new Vertex();
        Vertex vertex_2 = new Vertex();
        Vertex vertex_3 = new Vertex();
        Vertex vertex_4 = new Vertex();
        vertex_0.setAdjacency(vertex_1, -1);
        vertex_0.setAdjacency(vertex_2, 4);

        vertex_1.setAdjacency(vertex_2, 3);
        vertex_1.setAdjacency(vertex_3, 2);
        vertex_1.setAdjacency(vertex_4, 2);

        vertex_3.setAdjacency(vertex_2, 5);
        vertex_3.setAdjacency(vertex_1, 1);

        vertex_4.setAdjacency(vertex_3, -3);
        Vertex[] vertices = {vertex_0, vertex_1, vertex_2, vertex_3, vertex_4};
        return vertices;
    }

    public void ShortestPathSearch(int S, Vertex[] allVertices){
        allVertices[S].setWeight(0);
//        int[] D = new int[allVertices.length];
//        for (int i = 0; i < D.length; i++) {
//            D[i] = Integer.MAX_VALUE;
//        }
//        D[S] = 0;
        for (int i = 0; i < allVertices.length; i++) {
            for (Map.Entry<Vertex, Integer> edge: allVertices[i].getAdjacency().entrySet()) {
                if ((allVertices[i].getWeight()+edge.getValue()) < edge.getKey().getWeight()){
                    edge.getKey().setWeight(allVertices[i].getWeight()+edge.getValue());
                }
            }
            System.out.println(i+": "+Arrays.toString(allVertices));
        }
        for (int i = 0; i < allVertices.length; i++) {
            for (Map.Entry<Vertex, Integer> edge: allVertices[i].getAdjacency().entrySet()) {
                if (edge.getKey().getWeight() > allVertices[i].getWeight() + edge.getValue()){
                    //edge.getKey().setWeight(allVertices[i].getWeight()+edge.getValue());
                    System.out.println("Graph contains negative cycle");
                }
            }
        }
        System.out.println(Arrays.toString(allVertices));
    }
}
