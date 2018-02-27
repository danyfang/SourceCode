//Leetcode problem 19. Remove N-th node from the end of list
//Solution written by xuqiang fang on 26 Feb, 2018

/*
given n will always be valid and try to do it in one pass
*/
//solution accepted

/*
the idea is to keep two pointers separated at interval of size n
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
		ListNode first = head;
		ListNode second = head;
		RemoveNode.print(head);
		while(first != null){
			first = first.next;
			n--;
			if(n < 0){
				if(first == null){
					second.next = second.next.next;
					return head;
				}
				second = second.next;
			}
		}
		if(n >= 0){
			head = head.next;
		}

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
		ListNode e = new ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		//print(s.removeNthFromEnd(a, 2));
		print(s.removeNthFromEnd(d, 2));
	}
	public static void print(ListNode a){
		while(a != null){
			System.out.println(a.val);
			a = a.next;
		}
	}
}
