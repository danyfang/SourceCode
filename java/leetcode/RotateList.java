//Leetcode problem 61 Rotate List
//Solution written by Xuqiang Fang on 21 March 2018 
//the trick is to maintain a key node list, then we can do it in O(n) time
//Solution accepted
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}
class Solution{
	public ListNode rotateRight(ListNode head, int k){
		ListNode current = head;
		if(head == null){
			return null;
		}
		if(k == 0)
			return head;
		int size = 1;
		ListNode oldHead = head;
		ListNode newTail = head;
		while(current.next != null){
			if(size >= k){
				newTail = head;
				head = head.next;
			}
			size++;
			current = current.next;
		}
		if(size > k){
			current.next = oldHead;
			newTail.next = null;
			return head;
		}else{
			return rotateRight(head, k%size);
		}
	}	
}

public class RotateList{
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
		System.out.println("Before: ");
		print(a);
		
		System.out.println("After: ");
		print(s.rotateRight(a,5));
	}
	public static void print(ListNode root){
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}
}
