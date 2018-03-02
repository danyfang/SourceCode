class Node{
    private Node left;
    private Node right;
    private int data;

    //constructors
    public Node(){
        this.left = null;
        this.right = null;
    }
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //setters and getters
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return this.data;
    }
    public void setLeft(Node left){
        this.left = left;
    }
    public void setRight(Node right){
        this.right = right;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    //methods
    public void addNode(Node newNode){
        if(newNode.getData()<this.data){
            if(this.left == null){
                this.left = newNode;
            }else {
                this.left.addNode(newNode);
            }
        }else{
            if(this.right== null){
                this.right = newNode;
            }else{
                this.right.addNode(newNode);
            }
        }
    }

    public void printNode(){
        if(this.left != null){
            this.left.printNode();
        }
        System.out.println(this.data);
        if(this.right != null){
            this.right.printNode();
        }
    }
    public boolean searchNode(int data){
        if(data<this.data){
            if(this.left == null){
                return false;
            }else{
                return this.left.searchNode(data);
            }

        }else if (this.data == data){
            return true;
        }else {
            if(this.right == null){
                return false;
            }else{
                return this.right.searchNode(data);
            }
        }

    }
    public void deleteNode(int data){
        if(data < this.data){
            if(this.left.data == data && this.left.left == null && this.left.right == null){//  has no child
                this.left = null;
            }else if(this.left.data == data && this.left.left == null && this.left.right != null){// only has one child, right
                this.left = this.left.right;
            }else if(this.left.data == data && this.left.left != null && this.left.right == null){//only has one child. left
                this.left = this.left.left;
            }else if(this.left.data == data && this.left.left != null && this.left.right != null){// has two children
                this.left.data = this.left.right.getMaximum();
                this.left.right.setMaxiNull();
            }else{
                this.left.deleteNode(data);
            }
        }
        if(data >= this.data){
            if(this.right.data == data && this.right.left == null && this.right.right == null){
                this.right = null;
            }else if(this.right.data == data && this.right.left == null && this.right.right != null){
                this.right = this.right.right;
            }else if(this.right.data == data && this.right.left != null && this.right.right == null){
                this.right = this.right.left;
            }else if(this.right.data == data && this.right.left != null && this.right.right != null){
                this.right.data = this.right.left.getMinimum();
                this.right.left.setMiniNull();
            }else{
                this.right.deleteNode(data);
            }
        }
    }

    public int getMinimum(){
        Node temp = this;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }
    public void setMiniNull(){
        Node temp = this;
        while(temp.left != null){
            temp = temp.left;
        }
        temp = null;
    }
    public int getMaximum(){
        Node temp = this;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.data;
    }
    public void setMaxiNull(){
        Node temp = this;
        while(temp.right != null){
            temp = temp.right;
        }
        temp = null;
    }

}

public class BinaryTree{
    private Node root;
    private int size;
    public BinaryTree(Node root){
        this.root = root;
        this.size = 1;
    }
    public BinaryTree(){}
    public void setRoot(Node root){
        this.root = root;
        this.size = 1;
    }
    public Node getRoot(){
        return this.root;
    }
    public int getSize(){
        return this.size;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
        this.size++;
    }
    public boolean search(int data){
        if(this.root != null){
            return this.root.searchNode(data);
        }else{
            return false;
        }

    }
    public void print(){
        if(this.root == null){
            return;
        }
        this.root.printNode();
		/*
		if(this.root.getLeft() != null){
			this.root.getLeft().printNode();
		}
		System.out.println(this.root.getData());
		if(this.root.getRight() != null){
			this.root.getRight().printNode();
		}
		*/
    }
    public void delete(int data){
        if(!this.search(data)){
            System.out.println("Error, node to be deleted doesn't exist!");
            return;
        }
        while(this.search(data)){
            if(this.root.getData() == data && this.root.getLeft() == null && this.root.getRight() == null){
                this.root = null;
            }else{
                this.root.deleteNode(data);
            }
            this.size--;
        }
    }
    public int minimum(){
        if(this.root == null){
            System.out.println("Error, no items in the tree");
            return 0;
        }else{
            return this.root.getMinimum();
        }
    }
    public int maximum(){
        if(this.root == null){
            System.out.println("Error, no items in the tree");
            return 0;
        }else{
            return this.root.getMaximum();
        }
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(43);
        tree.add(2);
        tree.add(3433);
        tree.add(1);
        tree.add(1);
        System.out.println(tree.search(1));
        System.out.println(tree.search(2));
        System.out.println(tree.search(9));
        tree.print();
        System.out.println(tree.minimum());
        System.out.println(tree.maximum());
        System.out.println("after deleting 2");
        tree.delete(2);
        tree.print();
        System.out.println("Binary tree size: "+tree.getSize());
        System.out.println("after deleting 2");
        tree.delete(2);
        tree.print();
        System.out.println("after deleting 1");
        tree.delete(1);
        tree.print();
        System.out.println("Binary tree size: "+tree.getSize());
        System.out.println("after deleting 1");
        tree.delete(1);
        tree.print();
        System.out.println("Binary tree size: "+tree.getSize());
    }
}
