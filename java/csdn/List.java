/*
This code is written for data structure implementation in Java, by Xuqiang Fang on 24-01-2018
Anyone can freely reuse this piece of code.
*/
class Node{
	private String content;
	private Node next;
	
	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setNext(Node next){
		this.next = next;
	}
	
	public Node getNext(){
		return this.next;
	}


	public Node(String content, Node next){
		this.content = content;
		this.next = next;
	}
	public Node(String content){
		this(content,null);
	}
	public Node(){}
	
	public void addNode(Node newNode){
		if(this.next == null){
			this.next = newNode;
		}	
		else{
			this.next.addNode(newNode);
		}		
	}


}


public class List{
	private Node root;
	public void add(String data){
		if(data == null){
			return;
		}
		Node newNode = new Node(data);
		if(this.root == null){
			this.root = newNode;
		}
		else{
			this.root.addNode(newNode);
		}
	}
	public void add(String[] data){
		for (int i=0; i<data.length; i++){
			this.add(data[i]);
		}
	}
	public Node getRoot(){
		return this.root;
	}
	public int getLength(){// return the length of the list
		if (this.root == null){
			return 0;
		}
		int length = 1;
		Node pointer = this.root;
		while(pointer.getNext()!= null){
			length+=1;
			pointer = pointer.getNext();
			
		}
		return length;
	}
	public void delete(int length){// delete length # of nodes from the list
		if (this.getLength()< length){
			System.out.println("Error! Can't delete " + length+ " nodes!");
			return;
		}	
		else{//delete from the root node, otherwise we need a double linked list
			System.out.println("Delete "+length+" Nodes!");
			while(length >0){
				this.root = this.root.getNext();
				length--;
			}
		}
	}	
	public static void printList(Node pointer){
		while(pointer.getNext() != null){
			System.out.println(pointer.getContent());
			pointer = pointer.getNext();	
		}
		System.out.println(pointer.getContent());
	}


	public static void main(String[] agrs){
		List list = new List();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("Hellow");
		list.add("world");
		list.add("this is really fun");
		list.add("hahhahahh");
		printList(list.getRoot());
		System.out.println(list.getLength());
		list.delete(3);
		printList(list.getRoot());
		list.add(new String[]{"this","is","another","demo","for list"});
		printList(list.getRoot());
	}
	
}
