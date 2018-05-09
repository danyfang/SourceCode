//Leetcode problem 198 House Robber
//Leetcode problem 213 House Robber II
//Leetcode problem 337 House Robber III
//Solution written by Xuqiang Fang on 11 April, 2018 
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}

class Solution{
    //No 198
    public int rob(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        //dp[i] stores the largest benefit until i
        int[] dp = new int[nums.length];
        if(nums.length == 1)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]); 
        }

        return dp[nums.length-1];
    }	

    //No 213
    public int rob2(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int begin = nums[0];
        int end = nums[nums.length-1];
        nums[0] = 0;
        int no_begin = rob(nums);
        nums[0] = begin;
        nums[nums.length-1] = 0;
        int no_end = rob(nums);
        return Math.max(no_end, no_begin);
    }


    //No 337
    public int rob3(TreeNode root){
        //two cases, root is included OR root is not included
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return root.val;
        else if(root.left == null){
            int grandson = rob3(root.right.left) + rob3(root.right.right);
            int son = rob3(root.right);
            if(root.val + grandson > son)
                return grandson + root.val;
            return son;
        }
        else if(root.right == null){
            int grandson = rob3(root.left.left) + rob3(root.left.right);
            int son = rob3(root.left);
            if(root.val + grandson > son)
                return grandson + root.val;
            return son;
        }
        int grandson = rob3(root.left.left) + rob3(root.left.right) 
                        + rob3(root.right.left) + rob3(root.right.right);
        int son = rob3(root.left) + rob3(root.right);
        if(root.val + grandson > son)
            return root.val + grandson;
        return son;
    }
}

public class HouseRobber{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        //System.out.println(s.rob2(nums));



		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(5);
		root.left = a;
		root.right = b;

		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(0);
		TreeNode f = new TreeNode(1);
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;
        System.out.println(s.rob3(root)); 
	}
}
