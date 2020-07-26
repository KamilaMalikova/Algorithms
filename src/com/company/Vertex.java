package com.company;

import java.util.HashMap;
import java.util.Map;

public class Vertex{
    private int weight = Integer.MAX_VALUE;
    private Map<Vertex, Integer> adjacency = new HashMap<>();

    public void setAdjacency(Vertex vertex, int edge) {
        this.adjacency.put(vertex, edge);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Map<Vertex, Integer> getAdjacency() {
        return adjacency;
    }

    @Override
    public String toString() {
        return  weight+" " ;
    }
}

