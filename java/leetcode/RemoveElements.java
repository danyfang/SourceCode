//Leetcode problem 203 Remove Linked List Elements
//Leetcode problem 237 Delete Node in a Linked List 
//Solution written by Xuqiang Fang on 13 April, 2018 
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

class Solution{
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        while(head != null){
            if(head.val == val){
                prev.next = head.next; 
            }
            else{
                prev = head;
            }
            head = head.next;
        }
        return newHead.next;
    } 	
    public void deleteNode(ListNode node){
        //given node won't be the tail node, it always has its first next
        ListNode next = node.next;
        while(next != null){
            node.val = next.val;
            next = next.next;
            if(next != null)
                node = node.next;
        }
        node.next = null;
    }
}

public class RemoveElements{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(1);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        head = s.removeElements(head, 1);
        print(head);
        s.deleteNode(b);
        print(head);
	}
    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
