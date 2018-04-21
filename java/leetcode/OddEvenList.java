//Leetcode problem 328 Odd Even Linked List
//Solution written by Xuqiang Fang on 19 April, 2018 


class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

class Solution{
    public ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode fast = head.next.next;
        while(fast != null){
            odd.next = fast;
            even.next = fast.next;
            odd = odd.next;
            even = even.next;
            if(fast.next != null){
                fast = fast.next.next;
            }
            else 
                fast = null;
        }
        odd.next = evenHead;
        return oddHead;
    }	
}

public class OddEvenList{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        //b.next = c;
        //c.next = d;
        print(head);

        head = s.oddEvenList(head);
        print(head);
	}

    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
