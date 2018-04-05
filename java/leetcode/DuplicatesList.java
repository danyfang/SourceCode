//Leetcode problem 82 Remove Duplicates from Sorted List II
//Solution written by Xuqiang Fang on 22 March 2018
//Solution accepted
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}
class Solution{
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode valid = dummy;
		ListNode current = dummy.next;
		int count = 0;
		while(current != null){
			count = duplicate(current);
			if(count > 1){
				while(count > 0){
					current = current.next;
					count--;
				}
			}else{
				valid.next = current;
				valid = valid.next;
				current = current.next;
			}
		}
		valid.next = null;
		return dummy.next;
    }
	private int duplicate(ListNode current){
		int count = 1;
		while(current != null && current.next != null){
			if(current.val == current.next.val){
				count += 1;
			}	
			else{
				break;
			}
			current = current.next;
		}
		return count;
	}
}

public class DuplicatesList{
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
		d.next = e;
		e.next = f;
		ListNode cur = root;
		while(cur != null){
			//System.out.println(s.duplicate(cur));
			cur = cur.next;
		}
		print(s.deleteDuplicates(root));
	}
	public static void print(ListNode root){
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}
}
