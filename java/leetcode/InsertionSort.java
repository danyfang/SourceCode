//Leetcode problem 147 Insertion Sort List
//Leetcode problem 148 Sort List Uisng constant space in O(nlogn)
//Solution written by Xuqiang Fang on 9 April, 2018 
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
class Solution{
    public ListNode insertionSortList(ListNode head){
        if(head == null)
            return head;
        ListNode n = head.next;
        head.next = null;
        while(n != null){
            //System.out.println("next " + " "+ n.val);
            ListNode next = n.next;
            n.next = null;
            head = insert(head, n);
            n = next;
        }
        return head;
    }	
    public ListNode insert(ListNode head, ListNode newNode){
        //newHead won't be null
        //head is the first node of sorted list
        newNode.next = null;//make sure it's a single node
        if(head == null)
            return newNode;
        if(newNode.val <= head.val){
            //System.out.println("Here");
            newNode.next = head;
            return newNode;
        }
        else{
            head.next = insert(head.next, newNode);
        }
        return head;
    }
    public void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    //No 148 Merge Sort
    public ListNode sortList(ListNode head){
        if(head == null)
            return head;

        return null; 
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while(left != null || right != null){
            //System.out.println("Hello Debug");
            if(left == null){
                //System.out.println("Hello left");
                cur.next = right;
                return newHead.next;
            }
            else if(right == null){
                cur.next = left;
                return newHead.next;
            }
            else{
                if(left.val <= right.val){
                    cur.next = left;
                    left = left.next;
                    cur = cur.next;
                    continue;
                }else{
                    cur.next = right;
                    right = right.next;
                    cur = cur.next;
                    continue;
                }
            }
        }
        return newHead.next;
    }
}

public class InsertionSort{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(1);
        /*
        a.next = b;
        b.next = c;
        //c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        //g.next = f;
        //f.next = e;
        //ListNode n = s.insert(g, d);
        //ListNode n = s.insertionSortList(a);
        */
        

        //for merge sort test
        g.next = f;
        f.next = e;
        e.next = d;

        c.next = b;
        b.next = a;
        ListNode n = s.merge(g,c);
        print(n);
	}
    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
