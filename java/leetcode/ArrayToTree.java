//Leetcode problem 108 Converted Sorted Array to Binary Search Tree
//Leetcode problem 109 Converted Sorted List to Binary Search Tree
//Solution written by Xuqiang Fang on 16 March 2018
//Solution provided by user@jiaming2
//this is a test //this is a test //this is a test 
import java.util.ArrayList;
import java.util.List;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {val = x;}
}

class Solution{
	public TreeNode sortedArrayToBST(int[] nums){
		if(nums.length == 0)
			return null;

		TreeNode head = insert(nums, 0, nums.length-1);
		return head;
	}	
	private TreeNode insert(int[] nums, int low, int high){
		if (low > high)
			return null;

		int mid = low + (high - low)/2;
		TreeNode node = new TreeNode (nums[mid]);
		node.left = insert(nums, low, mid-1);
		node.right = insert(nums, mid+1, high);
		return node;
	}
	public TreeNode sortedListToBST(ListNode head) {
       	List<Integer> list = new ArrayList<Integer>();
		while(head != null){
			list.add(head.val);
			head = head.next;
		}
		int[] nums = new int[list.size()];
		for(int i=0; i<nums.length; i++){
			nums[i] = list.get(i);
		}
		return sortedArrayToBST(nums);
    }
}

public class ArrayToTree{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {-10,-3,0,5,9};
		print(s.sortedArrayToBST(nums));
	}
	public static void print(TreeNode root){
		if(root != null){
			print(root.left);
			System.out.println(root.val);
			print(root.right);
		}
	}

}
