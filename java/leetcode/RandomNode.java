//Leetcode problem 382 Linked List Random Node
//Solution written by Xuqiang Fang on 16 May, 2018

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
class Solution{
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        r = new Random();
        list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int index = r.nextInt(list.size());
        return list.get(index).val;
    }
    private List<ListNode> list;
    private Random r;
}

public class RandomNode{
	public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
		Solution s = new Solution(head);
        while(true){
            String input = System.console().readLine();
            if(input.equals("q"))
                break;
            System.out.println(s.getRandom());
        }
	}
}
