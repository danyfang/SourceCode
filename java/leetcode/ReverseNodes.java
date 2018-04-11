//Leetcode problem 25 Reverse Nodes in k-Group
//Solution written by Xuqiang Fang on 11 April, 2018 

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

class Solution{
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;        
        int times = 0;
        ListNode curr = head;
        ListNode tail = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        System.out.println(length);
        if(length < k)
            return head;
    
        times = length / k;
        curr = head;
        while(times > 0){
            tail =  
            times--;
        }
        return head;
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
