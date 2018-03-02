//Leetcode Problem 23 Merge k sorted lists
//Solution written by Xuqiang Fang on 27 Feb 2018
/*
Given k sorted linked lists and return it as one sorted list
first assume list is sorted in accending order
*/
//current solution exceeds time limit

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {//use recursion
    public ListNode mergeKLists(ListNode[] lists) {
		ListNode result = lists[0];
		for(int i=0; i<lists.length; i++){
			if(lists[i] != null){
				result = lists[i];
				break;
			}
		}
		if(result == null)//the ListNode list contains all null list
			return result;
		//result is not null
		int foot = 0;
		for(int i=0; i<lists.length; i++){
			if(lists[i] != null && lists[i].val < result.val){
				result = lists[i];
				foot = i;
			}
		}
		lists[foot] = lists[foot].next;
		result.next = this.mergeKLists(lists);
       	return result; 
    }
}

public class SortedList{
	public static void main(String[] args){
		Solution s = new Solution();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode x = new ListNode(8);
		ListNode y = new ListNode(11);
		ListNode z = new ListNode(23);
		a.next = b;
		b.next = c;
		c.next = x;
		x.next = y;
		y.next = z;

		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		d.next = e;
		e.next = f;

		ListNode g = new ListNode(7);
		ListNode h = new ListNode(8);
		ListNode i = new ListNode(9);
		g.next = h;
		h.next = i;
		

		ListNode[] lists = new ListNode[]{a,d,null};
		print(s.mergeKLists(lists));
	}
	public static void print(ListNode a){
		while(a != null){
			System.out.println(a.val);
			a = a.next;
		}
	}
}
