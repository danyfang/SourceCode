//Leetcode problem 19. Remove N-th node from the end of list
//Solution written by xuqiang fang on 26 Feb, 2018

/*
given n will always be valid and try to do it in one pass
*/


class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n){
		return head;
	}
}


public class RemoveNode{
	public static void main(String[] args){
		Solution s = new Solution();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		print(a);

		print(s.removeNthFromEnd(a, 2));
	}
	public static void print(ListNode a){
		while(a != null){
			System.out.println(a.val);
			a = a.next;
		}
	}
}
