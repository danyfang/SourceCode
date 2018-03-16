//Leetcode problem 148 Sort List
//Solution written by Xuqiang Fang on 6 March 2018
/*
Sort a linked list in O(nlogn) time using constant space complexity
*/
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}
class Solution{
	public ListNode sortList(ListNode head){
		if(head == null || head.next == null)
			return head;
		//at least two nodes
		ListNode current = head;
		ListNode next = head.next;
		while(current != null){
			
		}
	}	
}

public class SortList{
	public static void main(String[] args){
		Solution s = new Solution();
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(8);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(9);
		ListNode e = new ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		print(s.sortList(a));
	}

	public static void print(ListNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
