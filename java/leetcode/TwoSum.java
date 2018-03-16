//Leetcode problem 167 Two Sum II input array is sorted
//Leetcode problem 653 Two Sum IV- Input is a BST
//Solution written by Xuqiang Fang on 15 March 2018 
import java.util.ArrayList;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}


class Solution{
	public int[] twoSum(int[] numbers, int target){
		int i = 0;
		int j = numbers.length-1;
		int[] result = new int[2];
		while(i < j){
			if(numbers[j] > target-numbers[i]){
				j--;
				continue;
			}
			else if(numbers[j] == target-numbers[i]){
				result[0] = i+1;
				result[1] = j+1;
				break;
			}else {
				i++;
				continue;
			}
		}
		return result;
	}	
	public boolean findTarget(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();
		inOrder(root, list);
		//System.out.println(list);
		int i = 0;
		int j = list.size()-1;
		while(i < j){
			if(list.get(j) > k - list.get(i)){
				j--;
				continue;
			}
			else if(list.get(j) < k - list.get(i)){
				i++;
				continue;
			}
			else{
				return true;
			}
		}
    	return false; 
    }
	public void inOrder(TreeNode root, List<Integer> list){
		if(root != null){
			inOrder(root.left,list);
			list.add(root.val);
			inOrder(root.right,list);
		}
		else{
			return;
		}
	}
}

public class TwoSum{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] numbers = {2,7,11,15};
		int target = 9;
		int[] result = s.twoSum(numbers, target);
		//System.out.println(result[0]);
		//System.out.println(result[1]);

		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(7);
		
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;

		//s.inOrder(root);
		System.out.println(s.findTarget(root,2));
	}
}
