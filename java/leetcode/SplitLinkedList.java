//Leetcode problem 725 Split Linked List in Parts
//Solution written by Xuqiang Fang on 3 May, 2018
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
class Solution{
    public ListNode[] splitListToParts(ListNode root, int k){
        ListNode[] ret = new ListNode[k]; 
        for(int i=0; i<k; ++i){
            ret[i] = null;
        }
        int length = 0;
        ListNode prev = root;
        ListNode temp = root;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int unit = length / k;
        int remaing = length % k;
        temp = root;
        for(int i=0; i<k; ++i){
            if(temp == null)
                break;
            int j = unit;
            ret[i] = temp;
            if(remaing-- > 0){
                j++;
            }
            while(j-- > 1){
                temp = temp.next;
            }
            prev = temp.next;
            temp.next = null;
            temp = prev;
        }

        return ret;
    }	
}

public class SplitLinkedList{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode root = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(7);
        ListNode g = new ListNode(8);
        ListNode h = new ListNode(9);
        ListNode i = new ListNode(10);
        ListNode j = new ListNode(11);
        ListNode k = new ListNode(12);
        root.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        j.next = k;
        ListNode[] ret = s.splitListToParts(root, Integer.valueOf(args[0]));
        for(ListNode l : ret){
            print(l);
            System.out.println("**********");
        }
	}
    public static void print(ListNode root){
        while(root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }
}
