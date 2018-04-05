//Leetcode problem 206 Reverse Linked List
//Leetcode problem 92 Reverse Linked List II
//Solution written by Xuqiang Fang on 23 March 2018 
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}

class Solution{
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
	//answer provided by user@ardyadipta
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null) return null;
 		// create a dummy node to mark the head of this list
		ListNode dummy = new ListNode(0);
		dummy.next = head;
 		// make a pointer pre as a marker for the node before reversing
		ListNode pre = dummy;
		for(int i = 0; i<m-1; i++) pre = pre.next;
		 // a pointer to the beginning of a sub-list that will be reversed	
		ListNode start = pre.next;
		ListNode then = start.next; // a pointer to a node that will be reversed
		
		// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		// dummy-> 1 -> 2 -> 3 -> 4 -> 5
		
		for(int i=0; i<n-m; i++)
		{
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}
		
		// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
		
		return dummy.next;
	}
}

public class ReverseList{
	public static void main(String[] args){
		Solution s = new Solution();
		ListNode root = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(7);
		root.next = a;
		a.next = b;
		b.next = c;
		//c.next = d;
		d.next = e;
		e.next = f;
		
		print(s.reverseBetween(root,1,4));

	}
	public static void print(ListNode root){
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}	

}
