package com.company;

import com.company.Node;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.function.DoubleToIntFunction;

public class BreathFirst {

    public Node CreateGraph(){
        Node node_root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        LinkedList<Node> root_adj = new LinkedList<>();
        root_adj.add(node2);
        root_adj.add(node3);
        node_root.setSubnodes(root_adj);

        LinkedList<Node> node2_adj = new LinkedList<>();
        node2_adj.add(node4);
        node2_adj.add(node5);
        node2.setSubnodes(node2_adj);

        LinkedList<Node> node3_adj = new LinkedList<>();
        node3_adj.add(node5);
        node3.setSubnodes(node3_adj);

        LinkedList<Node> node4_adj = new LinkedList<>();
        node4_adj.add(node6);
        node4.setSubnodes(node3_adj);

        LinkedList<Node> node5_adj = new LinkedList<>();
        node5_adj.add(node6);
        node5.setSubnodes(node5_adj);
        return node_root;
    }


    public void BreathFirstSearch(Node root, int searchValue){
        int steps = 0;
        Queue<Node> queue = new PriorityQueue<>();
        if (root.getValue() == searchValue){
            System.out.println("Found in "+steps+" steps");
            return;
        }
        root.setVisited(true);
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            steps++;
            System.out.println("Node: "+node.getValue());
            if (node.getValue() == searchValue){
                System.out.println("Found in "+steps+" steps");
                return;
            }
            LinkedList<Node> subnodes = node.getSubnodes();
            for (Node subnode: subnodes) {
                if (!subnode.isVisited()){
                    subnode.setVisited(true);
                    queue.add(subnode);
                }
            }
        }
    }
}


