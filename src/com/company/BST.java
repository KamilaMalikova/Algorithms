package com.company;

import java.util.Comparator;

public class BST<T extends Comparable<T>> {
    private BSTnode root;

    public BST(BSTnode root) {
        this.root = root;
    }

    public BST() {

    }

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

    public void find(T value){
        if (this.root == null) {
            System.out.println("The binary tree is empty: ");
        }
        else {
            int steps = 0;
            BSTnode node = root;
            while (node != null){
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
    }
}
