class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}

class Solution{
	public ListNode swapParis(ListNode head){
		ListNode current = head;
		while(current != null && current.next != null){
			int temp  = current.val;
			current.val = current.next.val;
			current.next.val = temp;
			current = current.next.next;
		}
		return head;
	}
	public void print(ListNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}

public class Swap{
	public static void main(String[] args){
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(7);
		ListNode c = new ListNode(8);
		a.next = b;
		b.next = c;
		Solution s = new Solution();
		s.print(a);
		s.swapParis(a);
		s.print(a);
	}
}
