package com.company;

import java.util.Comparator;

public class BST<T extends Comparable<T>> {
    private BSTnode root;
    private BSTnode current_node;

    public BST(BSTnode root) {
        this.root = root;
    }

    public BST(){};

    public void insert(T value){
        BSTnode new_node = new BSTnode(value);
        System.out.println("Value: "+value);
        if (this.root == null){
            this.root = new_node;
            System.out.println("Root");
        }
        else {
            BSTnode node = this.root;
            while (true){
                if (node.getKey().compareTo(new_node.getKey()) == 1){
                    System.out.print("Left ->");
                    if (node.getLeft() == null){
                        node.setLeft(new_node);
                        node.getLeft().setParent(node);
                        break;
                    }
                    node = node.getLeft();
                }
                else{
                    System.out.print("Right ->");
                    if (node.getRight() == null){
                        node.setRight(new_node);
                        node.getRight().setParent(node);
                        break;
                    }
                    node = node.getRight();
                }
            }
        }
    }

    public BSTnode delete(T value){
        BSTnode node = this.find(value);
        if (node != null){
            if (!node.hasLeftSubNode() && !node.hasRightSubNode()){
                System.out.println("Has no subnodes");
                if (node.getParent().getRight() == node)
                    node.getParent().setRight(null);
                else {
                    node.getParent().setLeft(null);
                }
            }
            else if (node.hasLeftSubNode() && !node.hasRightSubNode()){
                System.out.println("Has left subnode");
                this.replace(node, node.getLeft());
            }
            else if (!node.hasLeftSubNode() && node.hasRightSubNode()){
                System.out.println("Has right subnode");
                this.replace(node, node.getRight());
            }
            else {
                System.out.println("Has both subnodes");
                BSTnode successor = this.successor(node);
                this.replace(node, successor);
            }
        }
        return node;
    }

    private void replace(BSTnode nodeToRemove, BSTnode nodeToReplace){
        //has one subnode
        if (nodeToReplace.getParent() == nodeToRemove){
            if (nodeToRemove.getParent().getRight() == nodeToRemove){
                nodeToReplace.setParent(nodeToRemove.getParent());
                nodeToReplace.getParent().setRight(nodeToReplace);
            }
            else if (nodeToRemove.getParent().getLeft() == nodeToRemove){
                nodeToReplace.setParent(nodeToRemove.getParent());
                nodeToReplace.getParent().setLeft(nodeToReplace);
            }
        }
        //has two subnodes
        else {
            if (nodeToReplace.hasRightSubNode()){
                nodeToReplace.getRight().setParent(nodeToReplace.getParent());
                nodeToReplace.getParent().setLeft(nodeToReplace.getRight());
            }
            nodeToReplace.setParent(nodeToRemove.getParent());
            if (nodeToRemove.getParent().getLeft() == nodeToRemove){
                nodeToReplace.getParent().setLeft(nodeToReplace);
            }
            else if(nodeToRemove.getParent().getRight() == nodeToRemove){
                nodeToReplace.getParent().setRight(nodeToReplace);
            }
            nodeToReplace.setLeft(nodeToRemove.getLeft());
            nodeToReplace.getLeft().setParent(nodeToReplace);
            nodeToReplace.setRight(nodeToRemove.getRight());
            nodeToReplace.getLeft().setParent(nodeToReplace);
        }
    }
    public void Min(){
        BSTnode node = root;
        while (node.hasLeftSubNode()){
            node = node.getLeft();
        }
        System.out.println("Min: " + node.getKey());
    }

    public void Min(BSTnode node){
        while (node.hasLeftSubNode()){
            node = node.getLeft();
        }
        System.out.println("Min: " + node.getKey());
    }

    public void Min(T value){
        BSTnode node = find(value);
        if (node != null){
            while (node.hasLeftSubNode()){
                node = node.getLeft();
            }
        }
        System.out.println("Min: " + node.getKey());
    }

    public void Max(){
        BSTnode node = root;
        while (node.hasRightSubNode()){
            node = node.getRight();
        }
        System.out.println("Max: "+node.getKey());
    }

    public void Max(BSTnode node){
        while (node.hasRightSubNode()){
            node = node.getRight();
        }
        System.out.println("Max: "+node.getKey());
    }

    public void Max(T value){
        BSTnode node = find(value);
        if (node != null){
            while (node.hasRightSubNode()){
                node = node.getRight();
            }
        }
        System.out.println("Max: "+node.getKey());
    }

    public BSTnode find(T value){
        BSTnode node = null;
        if (this.root == null) {
            System.out.println("The binary tree is empty: ");
        }
        else {
            int steps = 0;
            node = root;
            while (node != null){
                if (!node.hasSubNodes()) break;
                if (node.getKey().compareTo(value) == 0){
                    steps++;
                    System.out.println("found in "+steps);
                    break;
                }
                else if (node.getKey().compareTo(value) == -1 && node.hasRightSubNode()){
                    if (!node.hasSubNodes()) break;
                    node = node.getRight();
                    steps++;
                    System.out.println("move to right on "+node.getKey());
                }
                else if (node.hasLeftSubNode()){
                    if (!node.hasSubNodes()) break;
                    node = node.getLeft();
                    steps++;
                    System.out.println("move to left on "+node.getKey());
                }
            }
        }
        current_node = node;
        return node;
    }

    public void successor(T value){
        BSTnode node = find(value);
        this.successor(node);
    }
    public BSTnode successor(BSTnode node){
        BSTnode successor = node.getRight();
        while(successor.hasLeftSubNode()){
            successor = successor.getLeft();
        }
        System.out.println("Successor: "+successor.getKey());
        return successor;
    }
}
