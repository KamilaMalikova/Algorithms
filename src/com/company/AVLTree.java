package com.company;

public class AVLTree<T extends Comparable>{
    private AVLnode root;

    public AVLTree() {};

    public AVLTree(AVLnode root) {
        this.root = root;
    }

    protected class AVLnode<T extends Comparable>{
        private T key;
        private AVLnode parent;
        private AVLnode left;
        private AVLnode right;
        private int height = -1;

        public AVLnode() {}

        public AVLnode(T key) {
            this.key = key;
            this.height++;
        }

        public AVLnode(T key, AVLnode parent, AVLnode left, AVLnode right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        public AVLnode getParent() {
            return parent;
        }

        public AVLnode getLeft() {
            return left;
        }

        public AVLnode getRight() {
            return right;
        }

        public int getHeight() {
            return height;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public void setParent(AVLnode parent) {
            this.parent = parent;
        }

        public void setLeft(AVLnode left) {
            this.left = left;
            this.update_height();
        }

        public void setRight(AVLnode right) {
            this.right = right;
            this.update_height();
        }

        public int update_height(){
            if (hasBothSubNodes()){
                height = (Math.max(this.left.height, this.right.height))+1;
            }
            else if (hasLeftSubNode()){
                height = this.left.height+1;
            }
            else if (hasRightSubNode()){
                height = this.right.height+1;
            }
            return height;
        }


        public boolean hasLeftSubNode(){
            if (this.left != null) return true;
            else return false;
        }
        public boolean hasRightSubNode(){
            if (this.right != null) return true;
            else return false;
        }

        public boolean hasSubNodes(){
            if (hasRightSubNode() || hasLeftSubNode()) return true;
            else return false;
        }

        public boolean hasBothSubNodes(){
            if (this.right!= null && this.left != null){
                return true;
            }
            else return false;
        }
    }

    public void insert(T value){
        AVLnode node = new AVLnode(value);
        this.insert(node);
    }
    public void insert(AVLnode new_node){
        if (root == null) {
            root = new_node;
            System.out.println("Root: "+root.getKey());
        }
        else {
            AVLnode node = root;
            while (true){
                if (node.getKey().compareTo(new_node.getKey()) == -1){
                    System.out.print("Right -> ");
                    if (!node.hasRightSubNode()){
                        node.setRight(new_node);
                        new_node.setParent(node);
                        node = new_node;
                        System.out.println("Value: "+new_node.getKey()+" | "+new_node.getHeight());
                        break;
                    }
                    node = node.getRight();
                }
                else if (node.getKey().compareTo(new_node.getKey()) == 1){
                    System.out.print("Left -> ");
                    if (!node.hasLeftSubNode()){
                        node.setLeft(new_node);
                        new_node.setParent(node);
                        System.out.println("Value: "+new_node.getKey()+" | "+new_node.getHeight());
                        node = new_node;
                        break;
                    }
                    node = node.getLeft();
                }
                else if (node.getKey().compareTo(new_node.getKey()) == 0){
                    System.out.println("There cannot be two equal nodes");
                    break;
                }
            }
            this.balanceTree(node);

        }
        System.out.println("Done\n");
    }

    public void balanceTree(AVLnode node){
        while (node != null){
            node.update_height();
            if (node.hasBothSubNodes()){
                if (node.getLeft().getHeight() >= (2+node.getRight().getHeight())){
                    int left_left_height = (node.getLeft().getLeft() == null) ? -1 : node.getLeft().getLeft().getHeight();
                    int left_right_height = (node.getLeft().getRight() == null) ? -1 : node.getLeft().getRight().getHeight();

                    if ( left_left_height >= left_right_height)
                        this.rotateRight(node);
                    else {
                        this.rotateLeft(node.getLeft());
                        this.rotateRight(node);
                    }
                }
                else if (node.getRight().getHeight() >= (2+ node.getLeft().getHeight())){
                    int right_right_height = (node.getRight().getRight() == null) ? -1 : node.getRight().getRight().getHeight();
                    int right_left_height = (node.getRight().getLeft() == null) ? -1 : node.getRight().getLeft().getHeight();

                    if (right_right_height >= right_left_height){
                        this.rotateLeft(node);
                    }
                    else {
                        this.rotateRight(node.getRight());
                        this.rotateLeft(node);
                    }
                }
                System.out.println("Val: "+node.getKey()+" | "+node.getHeight());
            }
            node = node.getParent();
        }

    }

    private void rotateRight(AVLnode x){
        AVLnode y = x.left;
        y.parent = x.parent;
        if (y.parent == null){
            this.root = y;
        }
        else {
            if (y.parent.left == x){
                y.parent.left = y;
            }
            else if (y.parent.right == x){
                y.parent.right = y;
            }
        }
        x.left = y.right;
        if (x.left != null){
            x.left.parent = x;
        }
        y.right = x;
        x.parent = y;
        y.update_height();
        x.update_height();
        y.right.update_height();
    }

    private void rotateLeft(AVLnode x){
        AVLnode y = x.right;
        y.parent = x.parent;
        if (y.parent == null){
            this.root = y;
        }
        else{
            if (y.parent.left == x){
                y.parent.left = y;
            }
            else if (y.parent.right == x){
                y.parent.right = y;
            }
        }
        x.right = y.left;
        if (x.right != null){
            x.right.parent = x;
        }
        y.left = x;
        x.parent = y;
        x.update_height();
        y.update_height();
        //update height
    }

    public AVLnode find(T value){
        AVLnode node = null;
        if (this.root == null) {
            System.out.println("The AVL tree is empty: ");
        }
        else {
            int steps = 0;
            node = root;
            while (node != null){
                System.out.println("Search: "+node.getKey() +" | "+node.getHeight());
               // if (!node.hasSubNodes()) break;
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
                else if (!node.hasBothSubNodes()) break;
            }
        }
        return node;
    }

    public AVLnode delete(T value){
        AVLnode node = this.find(value);
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
                AVLnode successor = this.successor(node);
                this.replace(node, successor);
            }
        }
        AVLnode balancing_node = node;
        while (balancing_node != null){
            balancing_node.update_height();
            balanceTree(balancing_node);
            balancing_node = balancing_node.getParent();
        }
        return node;
    }

    private void replace(AVLnode nodeToRemove, AVLnode nodeToReplace){
        //has one subnode
        AVLnode nodeToReplaceParent = nodeToReplace.getParent();
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
        while (nodeToReplaceParent != null) {
            this.balanceTree(nodeToReplaceParent);
            nodeToReplaceParent = nodeToReplaceParent.getParent();
        }
        while (nodeToReplace != null){
            this.balanceTree(nodeToReplace);
            nodeToReplace = nodeToReplace.getParent();
        }
    }

    public void successor(T value){
        AVLnode node = find(value);
        this.successor(node);
    }
    public AVLnode successor(AVLnode node){
        AVLnode successor = node.getRight();
        while(successor.hasLeftSubNode()){
            successor = successor.getLeft();
        }
        System.out.println("Successor: "+successor.getKey());
        return successor;
    }
}
