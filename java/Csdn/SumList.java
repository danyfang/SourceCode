import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		//first case: either 1 null or both are null;
        if(l1 == null){
            return l2==null? null : l2;
        }
		if(l2 == null){
			return l1==null? null: l1;
		}
		//second case: both are size 1;
		ListNode result = new ListNode(0);
		int flag = 0;
		result.val = l1.val + l2.val;
		ListNode second = new ListNode(1);
		if(result.val >= 10){
			flag = 1;
			result.val = result.val - 10;
			if(l1.next == null && l2.next == null){
				result.next = second;
				return result;
			}
		}
		// third case: both are longer than 1;
		boolean once = true;
		while(l1.next != null || l2.next != null){
			ListNode newNode = new ListNode(l1.val + l2.val + flag);
			if(once){
				result.next = newNode;
				once = false;
			}
			flag = 0;
			if(newNode.val >= 10){
				flag = 1;
				newNode.val = newNode.val - 10;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return result;

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

		printList(a);
		printList(x);
		printList(s.addTwoNumbers(z,c));
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
