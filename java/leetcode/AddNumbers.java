//Leetcode problem  445 Add Two Numbers II
//Solution written by Xuqiang Fang on 12 May, 2018
import java.util.Stack;
class ListNode{
    int val;
    ListNode next;
    ListNode (int x){val = x;}
}
class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        Stack<Integer> first = new Stack<>(); 
        Stack<Integer> second = new Stack<>(); 
        while(l1 != null){
            first.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            second.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        ListNode head = null;
        while(!first.isEmpty() || !second.isEmpty()){
            int x = 0;
            int y = 0;
            if(!first.isEmpty())
                x = first.pop();

            if(!second.isEmpty())
                y = second.pop();

            int res = x + y + flag;
            flag = res / 10;
            res %= 10;

            ListNode temp = new ListNode(res);
            temp.next = head;
            head = temp;
        }
        if(flag == 1){
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }

        return head;
    }
}

public class AddNumbers{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        print(s.addTwoNumbers(l1,r1));
	}

    private static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
