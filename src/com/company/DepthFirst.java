package com.company;

import java.util.*;

public class DepthFirst {
    private Deque<Node> stack = new ArrayDeque<>();
    private Deque<Node> queue = new ArrayDeque<>();

    public Node CreateGraph(){
        Node node_root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        Node node6 = new Node(6);

        LinkedList<Node> root_adj = new LinkedList<>();
        root_adj.add(node1);
        root_adj.add(node2);
        root_adj.add(node3);
        node_root.setSubnodes(root_adj);

        LinkedList<Node> node1_adj = new LinkedList<>();
        node1_adj.add(node2);
        node1_adj.add(node_root);
        node1.setSubnodes(node1_adj);

        LinkedList<Node> node2_adj = new LinkedList<>();
        node2_adj.add(node4);
        node2_adj.add(node_root);
        node2_adj.add(node1);
        node2.setSubnodes(node2_adj);

        LinkedList<Node> node3_adj = new LinkedList<>();
        node3_adj.add(node_root);
        node3.setSubnodes(node3_adj);

        LinkedList<Node> node4_adj = new LinkedList<>();
        node4_adj.add(node2);
        node4.setSubnodes(node4_adj);

        return node_root;
    }


    public void DepthFirstTraversing(Node node){
        if (node == null) return;
        if (node.isVisited()) return;
        System.out.print(node.getValue());
        node.setVisited(true);
        queue.add(node);
        LinkedList<Node> adj = node.getSubnodes();
        if (adj.isEmpty() || adj == null) return;
        else System.out.print(" -> ");
        for (Node subnode: adj) {
            if (!subnode.isVisited()) {
                stack.add(subnode);
            }
        }


        DepthFirstTraversing(stack.pollLast());
    }
}
