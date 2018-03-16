//Leetcode problem 2 Add two numbers
//Solution written by Xuqiang Fang on 22 feb 2018

//all combing works are done by foot node;
//all return head;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int flag = 0;
        while(l1 != null || l2 != null || flag != 0 ){
            ListNode current = l1 != null ? l1 : (l2 != null ? l2 : (new ListNode(0)));
            int sum = ((l2 == null)? 0 : l2.val ) + ((l1 == null) ? 0 : l1.val) + flag;
            current.val = sum % 10;
            flag = sum/10;
            prev.next = current;
            prev = current;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}

public class SumList{
    public static void main(String[] args){
        Solution s = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ListNode x = new ListNode(9);
        ListNode y = new ListNode(8);
        ListNode z = new ListNode(7);
        x.next = y;
        y.next = z;

        //c.next = x;
        //printList(a);
        //printList(x);
        //printList(s.addTwoNumbers(z,c));
        //printList(s.addTwoNumbers(z,null));
        //printList(s.addTwoNumbers(null,c));
        //printList(s.addTwoNumbers(null,null));
        printList(s.addTwoNumbers(a,x));
        //printList(s.addTwoNumbers(a,a));
    }
    public static void printList(ListNode a){
        if (a == null){
            return;
        }else{
            System.out.println(a.val);
            while(a.next != null){
                System.out.println(a.next.val);
                a = a.next;
            }
        }
    }
}
