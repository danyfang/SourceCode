//Leetcode problem 143 Reorder List
//Solution written by Xuqiang Fang on 23 March 2018 
//current solution exceeded the memory limit
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}
class Solution{
	public void reorderList(ListNode head){
		int size = 0;
		ListNode cur = head;
		while(cur != null){
			size++;
			cur = cur.next;
		}

		ListNode front = head;
		ListNode back = head;
		ListNode temp = head;
		for(int i=0; i<size/2; i++){
			temp = back;
			back = back.next;	
		}
		temp.next = null;
		//now the original list has been cut into two parts
		System.out.println("Front");
		//print(front);
		System.out.println("Back");
		//print(reverseList(back));
		back = reverseList(back);
		print(back);
		//now the back list has been reversed
		System.out.println("After merge");
		print(merge(front, back));
	}	
	public void print(ListNode root){
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null)	
			return head;

		ListNode temp = head.next;
		ListNode current = head.next;
		head.next = null;
		while(temp != null){
			current = temp;
			temp = temp.next;
			current.next = head;
			head = current;
		}
		return head;
	}

	public ListNode merge(ListNode front, ListNode back){
		ListNode temp1 = front;
		ListNode temp2 = back;
		ListNode newHead = front;
		while(front != null && back != null){
			temp1 = front.next;
			front.next = back;
			temp2 = back.next;
			front = temp1;
			if(front != null)
				back.next = temp1;
			back = temp2;
		}
		return newHead;
	}
}

public class ReorderList{
	public static void main(String[] args){
		Solution s = new Solution();
		ListNode root = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(7);
		ListNode f = new ListNode(7);
		root.next = a;
		a.next = b;
		b.next = c;
		c.next = d;

		e.next = f;
		//printList(s.merge(e,root));
		//printList(root);
		s.reorderList(root);
		//printList(root);
	}
	public static void printList(ListNode root){
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}
}
