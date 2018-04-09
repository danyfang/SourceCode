//Leetcode problem 160 Intersection of Two Linked Lists
//Solution written by Xuqiang Fang on 9 April, 2018 

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        while(curA != null){
            lenA++;
            curA = curA.next;
        }
        ListNode curB = headB;
        while(curB != null){
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        while(lenA > 0 && lenB > 0){
            if(lenA > lenB){
                lenA--;
                curA = curA.next;
            }else if(lenB > lenA){
                lenB--;
                curB = curB.next;
            }else{
                if(curA == curB)
                    return curA;
                else{
                    lenA--;
                    lenB--;
                    curA = curA.next;
                    curB = curB.next;
                }
            }
        }
        return null;
    }	
}

public class IntersectList{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(1);
        ListNode c1 = new ListNode(9);
        ListNode c2 = new ListNode(10);
        ListNode c3 = new ListNode(11);
        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c2;
        c1.next = c2;
        c2.next = c3;
        ListNode result = s.getIntersectionNode(c1, c1); 
        if(result != null)
            System.out.println(result.val);
	}
}
