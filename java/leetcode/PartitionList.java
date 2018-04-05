//Leetcode problem 86 Partition List
//Solution written by Xuqiang Fang on 23 March 2018

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}

class Solution{
	public ListNode partition(ListNode head, int x) {
		if(head == null){
			return head;
		}
   		ListNode less = new ListNode(head.val);     
   		ListNode prev = new ListNode(head.val);     
   		ListNode less_ = less;     
   		ListNode prev_ = prev;     

		while(head!= null){
			if(head.val < x){
				less.next = head;
				less = less.next;
			}
			else{
				prev.next = head;
				prev = prev.next;
			}
			head = head.next;
		}
		less.next = prev_.next;
		head = less_.next;
		return head;
    }	

}

public class PartitionList{
	public static void main(String[] args){
		Solution s = new Solution();
		ListNode root = new ListNode(1);
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(6);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(1);
		ListNode f = new ListNode(5);
		root.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		System.out.println("Before: ");
		print(root);

		System.out.println("After: ");
		print(s.partition(root, 3));
	}
	public static void print(ListNode root){
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}

}
