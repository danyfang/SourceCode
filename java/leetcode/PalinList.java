//Leetcode problem 234 Palindrome Linked List
//Solution written by Xuqiang Fang on 23 March 2018 

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}

class Solution{
	public boolean isPalindrome(ListNode head) {
		int size = 0;
		ListNode h = head;
		while(h != null){
			size++;
			h = h.next;
		}
		int[] nums = new int[size];
		for(int i=0; i<size; i++){
			nums[i] = head.val;
			head = head.next;
		}
		for(int begin = 0, end = size-1; begin <= end; begin++, end--){
			if(nums[begin] != nums[end])	
				return false;
		}
		return true;
    }	
}

public class PalinList{
	public static void main(String[] args){
		Solution s = new Solution();
		ListNode root = new ListNode(1);
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(6);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(1);
		root.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		System.out.println(s.isPalindrome(root));
	}
	public static void print(ListNode root){
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}	
}
