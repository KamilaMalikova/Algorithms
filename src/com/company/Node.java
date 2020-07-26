package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Node implements Comparable<Node> {
    private int value;
    private LinkedList<Node> subnodes = new LinkedList<>();
    private boolean visited = false;

    public Node(int value,  LinkedList<Node> subnodes) {
        this.value = value;
        this.subnodes = subnodes;
    }

    public Node(int value) {
        this.value = value;
    }

    public void AddSubNode(Node node){
        if (subnodes == null){
            subnodes = new LinkedList<>();
        }
        subnodes.add(node);
    }

    public int getValue() {
        return value;
    }


    public LinkedList<Node> getSubnodes() {
        return subnodes;
    }

    public void setSubnodes(LinkedList<Node> subnodes) {
        this.subnodes = subnodes;
    }

    public Node getNodeInQueue(){
        return subnodes.poll();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int compareTo(Node o) {
        if (this.value > o.value) return 1;
        else if (this.value == o.value) return 0;
        else return -1;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}

