//Leetcode problem 817 Linked List Components
//Solution written by Xuqiang Fang on 7 may, 2018
import java.util.HashSet;
import java.util.Set;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
class Solution{
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int i : G){
            set.add(i);
        }

        int index = 0;
        int count = 0;
        boolean once = false;
        while(head != null && index < G.length){
            if(set.contains(head.val)){
                G[index] = head.val;
                index++;
                once = true;
            } 
            else if(once){
                count++;
                once = false;
            }
            head = head.next;
        }
        if(once){
            count++;
        }
        return count;
    }
}

public class LinkedListComponents{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode head = new ListNode(0);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        int[] G = {0,3,1,4};
        System.out.println(s.numComponents(head, G));
	}
}
