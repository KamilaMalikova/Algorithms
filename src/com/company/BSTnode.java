package com.company;

public class BSTnode <T extends Comparable<T>> {
    private T key;
    private BSTnode parent = null;
    private BSTnode left = null;
    private BSTnode right = null;

    public BSTnode(T key) {
        this.key = key;
    }

    public BSTnode(T key, BSTnode parent, BSTnode left, BSTnode right) {
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public BSTnode getParent() {
        return parent;
    }

    public BSTnode getLeft() {
        return left;
    }

    public BSTnode getRight() {
        return right;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setParent(BSTnode parent) {
        this.parent = parent;
    }

    public void setLeft(BSTnode left) {
        this.left = left;
    }

    public void setRight(BSTnode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTnode{" +
                "key=" + key +
                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public boolean hasSubNodes(){
        if (this.left != null || this.right != null) return true;
        else return false;
    }

    public boolean hasLeftSubNode(){
        if (this.left != null) return true;
        else return false;
    }

    public boolean hasRightSubNode(){
        if (this.right != null) return true;
        else return false;
    }
}
