package dany.fang.java;

public class BinaryTree {
    private class Node{
        private Comparable data;
        private Node left;
        private Node right;
        public Node(Comparable data) {
            this.data = data;
        }
        public void addNode(Node newNode){
            if(this.data.compareTo(newNode.data)<0){
                if(this.left == null){
                    this.left = newNode;
                }else{
                    this.left.addNode(newNode);
                }
            }else {
                if (this.right == null){
                    this.right = newNode;
                }else{
                    this.right.addNode(newNode);
                }
            }
        }
        public boolean searchNode(Node newNode){
            if(this.data.compareTo(newNode.data)<0){
                if(this.left == null){
                    return false;//没有找到
                }else {
                    return this.left.searchNode(newNode);//继续寻找
                }
            }else if(this.data.compareTo(newNode.data)==0){
                return true;//恰好是这个
            }else{
                if(this.right == null){
                    return false;
                }else {
                    return this.right.searchNode(newNode);
                }
            }
        }
        public void printNode(){
            if(this.left != null){
                this.left.printNode();
            }
            System.out.println(this.data);
            if(this.right != null)
            {
                this.right.printNode();
            }
        }
    }
    private Node root;
    public void add(Student data){
        if(data == null){
            return;
        }
        Node newNode = new Node(data);
        if(this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
    }
    public void print(){
        if(this.root != null){
            this.root.printNode();
        }
    }
    public boolean search (Student data){
        if (data == null){
            return false;
        }
        Node newNode = new Node(data);
        if(this.root == null){
            return false;
        } else {
            return this.root.searchNode(newNode);
        }
    }

}
