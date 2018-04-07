//Leetcode problem 138 Copy List with Random Pointer
//Solution written by Xuqiang Fang on 6 April, 2018 
//Solution accepted
import java.util.LinkedList;
import java.util.List;
class RandomListNode{
    int label;
    RandomListNode next, random;
    RandomListNode(int x){this.label = x;}
}
class Solution{
    public RandomListNode copyRandomList(RandomListNode head){
        RandomListNode m = head;
        if(head == null)
            return head;
        while(m != null){
            RandomListNode temp = m.next;
            m.next = new RandomListNode(m.label); 
            m.next.next = temp;
            m = temp;
        }
        m = head;
        while(m != null){
            if(m.random != null){
                m.next.random = m.random.next;
            }
            m = m.next.next;
        }
        m = head;
        RandomListNode newHead = head.next;
        while(m != null && m.next != null && m.next.next != null){
            RandomListNode temp = m.next;
            m.next = m.next.next; 
            temp.next = m.next.next;
            m = m.next;
        }
        m.next = null;
        return newHead;
    }	
}

public class CopyList{
	public static void main(String[] args){
		Solution s = new Solution();
        RandomListNode head = new RandomListNode(1);
        RandomListNode a = new RandomListNode(2);
        RandomListNode b = new RandomListNode(3);
        RandomListNode c = new RandomListNode(4);
        RandomListNode d = new RandomListNode(5);
        head.next = a;
        head.random = d;
        d.random = c;
        c.random = b;
        b.random = a;
        a.next = b;
        b.next = c;
        c.next = d;
        //print(head);
        //printRandom(head);
        print(s.copyRandomList(head));
        //printRandom(s.copyRandomList(head));
	}
    public static void print(RandomListNode head){
        while(head != null){
            System.out.println(head.label);
            head = head.next;
        }
    }
    public static void printRandom(RandomListNode head){
        while(head != null){
            System.out.println(head.label);
            head = head.random;
        }
    }
}
