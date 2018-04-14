//Leetcode problem 25 Reverse Nodes in k-Group
//Solution written by Xuqiang Fang on 11 April, 2018 

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

class Solution{
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1)
            return head;

        int count = 1;
        boolean once = true;
        ListNode current = head;
        ListNode newHead = head;
        ListNode oldTail = head;
        ListNode oldHead = head;
        ListNode oldOldTail = null;
        while(current != null){
            if(count == k){
                count = 1;
                newHead = current.next;
                //cut the list
                current.next = null;
                oldHead = reverseList(oldTail);
                if(oldOldTail != null){
                    oldOldTail.next = oldHead;
                }
                //link the list;
                oldTail.next = newHead;
                
                //update
                if(once){
                    head = oldHead;
                    once = false;
                }
                oldOldTail = oldTail;
                oldTail = newHead;
                current = newHead;
            } 
            count++;
            if(current == null)
                return head;
            current = current.next;
        }

        return head;
    }	
    public ListNode reverseList(ListNode head){
		if(head == null || head.next == null)	
			return head;

		ListNode temp = head.next;
		ListNode current = head.next;
		head.next = null;
		while(temp != null){
			current = temp;
			temp = temp.next;
			current.next = head;
			head = current;
		}
		return head;
	}	

    //another smart solution provided by user@ofLucas
    public ListNode reverseKGroup_(ListNode head, int k){
        int n = 0;
        for(ListNode i = head; i != null; n++, i = i.next);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for(ListNode prev = dummy, tail = head; n >= k; n -= k){
            for(int i = 1; i < k; i++){
                //first record the node that is cut out
                ListNode next = tail.next.next;
                //place the cut out link to the tail
                tail.next.next = prev.next;
                //get the link for new head(prev.next points to new head)
                prev.next = tail.next;
                //fix the cut out link
                tail.next = next;
            }

            prev = tail;
            tail = tail.next;
        }
        return dummy.next;
    }
}

public class ReverseNodes{
	public static void main(String[] args){
		Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        //print(head);
        print(s.reverseKGroup_(head, 5));
	}
    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
