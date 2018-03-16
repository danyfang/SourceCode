//Leetcode problem 83 Remove Duplicates from Sorted list
//Solution written by Xuqiang Fang on 18 Feb 2018
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode result = new ListNode(head.val);
        result.next = head.next;
        int flag = 0;
        while(head.next != null){
            if(head.next.val == head.val){
                head.next = head.next.next;
                if(flag == 0){
                    result.next = head.next;
                }
            }else{
                head = head.next;
                flag = 1;
            }
        }
        return result;
    }
    public void printList (ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}


public class Duplicate {
    public static void main(String[] args){
        Solution s = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        s.printList(a);
        System.out.println("after duplicates remove: ");
        s.printList(s.deleteDuplicates(a));
    }
}
