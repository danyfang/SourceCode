//Leetcode problem 508 Most Frequent Subtree Sum
//Solution written by Xuqiang Fang on 3 March 2018
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.Map;
import java.util.HashMap;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val = x;
	}
}
class Solution{
	private Map<Integer, Integer> sum = new HashMap<Integer, Integer>();
	private int maxCount = 0;
	public int[] findFrequentTreeSum(TreeNode root){
		this.SumSubtree(root);
		//System.out.println(sum);
		List<Integer> res = new ArrayList<>();
        for (int key : sum.keySet()) {
            if (sum.get(key) == maxCount) {
                res.add(key);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
	}	

	public int SumSubtree(TreeNode root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null){
			//System.out.println(root.val);
			//tree.add(root.val);
			int count = sum.getOrDefault(root.val,0) + 1;
			maxCount = maxCount > count ? maxCount : count;
			sum.put(root.val, count);
			return root.val;
		}else{
			int x = 0;
			x = root.val + SumSubtree(root.left) + SumSubtree(root.right);
			//tree.add(x);
			int count = sum.getOrDefault(x,0) + 1;
			maxCount = maxCount > count ? maxCount : count;
			sum.put(x,count);
			//System.out.println(x);
			return x;
		}
		/*
		SumSubtree(root.left);
		SumSubtree(root.right);
		System.out.println(root.val);
		return 0;
		*/
	}
}

public class SubtreeSum{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(3);
		root.left = a;
		root.right = b;
		//a.left = c;
		//a.right = d;
		//s.SumSubtree(root);
		print(s.findFrequentTreeSum(root));
	}
	public static void print(int[] nums){
		for(int i=0; i<nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
