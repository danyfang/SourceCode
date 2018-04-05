//Leetcode problem 141 Linked List Cycle
//Leetcode problem 142 Linked List Cycle II
//Solution written by Xuqiang Fang on 23 March 2018 

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;		
	}
}

class Solution{
	//Solution exceeded time limit
	public boolean hasCycle_(ListNode head){
		if(head == null || head.next == null){
			return false;
		}
		while(head.next != null){
			if(head.next == head){
				return true;
			}
			head.next = head.next.next;
		}	
		return false;
	}	
	//Solution provided by user@
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
		ListNode walker = head;
		ListNode runner = head;
		while(runner.next!=null && runner.next.next!=null) {
			walker = walker.next;
			runner = runner.next.next;
			if(walker==runner) return true;
		}
		return false;
	}
	public ListNode detectCycle_(ListNode head) {
    	if(head == null || head.next == null){
			return null;
		}    
		ListNode cur = head;
		while(cur != null){
			if(hasCycle(cur))
				return cur;
			cur = cur.next;
		}
		return null;
    }
	public ListNode detectCycle(ListNode head){
		if(head == null || head.next == null)
			return null;
		ListNode slow = head, fast = head, start = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				while(slow != start){
					slow = slow.next;
					start = start.next;
				}
				return start;
			}
		}
		return null;
	}
}

public class LinkedCycle{
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
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = c;

		System.out.println(s.hasCycle(root));
		System.out.println(s.detectCycle(root));
	}
}
