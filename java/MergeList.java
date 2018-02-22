//LeetCode problem 21. Merge two sorted Lists
//Solution written by Xuqiang Fang on 22, Feb, 2018


class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       	if(l1 == null && l2 == null){
			return null;
		} 
		if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}
		ListNode current = new ListNode(0);
		ListNode head = current;
		while(l1 != null || l2 != null){
			if(l1 == null){
				current.next = l2;
				head = head.next;
				return head;
			}else if(l2 == null){
				current.next = l1;
				head = head.next;
				return head;
			}
			int val = 0;
			if(l1.val <= l2.val){
				val = l1.val;
				l1 = l1.next;
			}else{
				val = l2.val;
				l2 = l2.next;
			}
			ListNode newNode = new ListNode(val);
			current.next = newNode;
			current = newNode;
		}
		head = head.next;
		return head;
    }
}

public class MergeList{
	public static void main(String[] args){
		ListNode a = new ListNode(1);	
		ListNode b = new ListNode(2);	
		ListNode c = new ListNode(4);	
		a.next = b;
		b.next = c;
		
		ListNode x = new ListNode(1);	
		ListNode y = new ListNode(3);	
		ListNode z = new ListNode(4);	
		x.next = y;
		y.next = z;
		
		Solution s = new Solution();
		printList(a);
		printList(x);
		printList(s.mergeTwoLists(a,x));	
	}
	public static void printList(ListNode a){
		while(a != null){
			System.out.println(a.val);
			a = a.next;
		}
	}
}
