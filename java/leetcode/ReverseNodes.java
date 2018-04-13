//Leetcode problem 25 Reverse Nodes in k-Group
//Solution written by Xuqiang Fang on 11 April, 2018 

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

class Solution{
    class NodePair{
        ListNode head;
        ListNode tail;
        NodePair(ListNode h, ListNode t){
            head = h;
            tail = t;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;        
        int times = 0;
        ListNode curr = head;
        ListNode tail = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        if(length < k)
            return head;
    
        times = length / k;
        while(times > 0){
            //first record the next head
             
            times--;
        }
        return head;
    }	
    public NodePair reverseList(ListNode head){
		if(head == null || head.next == null)	
			return null;
        ListNode oldHead = head;
		ListNode temp = head.next;
		ListNode current = head.next;
		head.next = null;
		while(temp != null){
			current = temp;
			temp = temp.next;
			current.next = head;
			head = current;
		}
		return new NodePair(head,oldHead);
	}	
}

public class ReverseNodes{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        //print(head);
        s.reverseKGroup(head, 2);
	}
    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
