//Leetcode problem 894 All Possible Full Binary Trees
//Solution written by Xuqiang Fang on 26 Aug, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
class Solution{
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if(N % 2 == 0){
            return ans;
        }  
        TreeNode root = new TreeNode(0); 
        if(N == 1){
            ans.add(root);
            return ans;
        }
        for(int l = 1; l <= (N-2); l += 2){
            List<TreeNode> left = allPossibleFBT(l);
            List<TreeNode> right = allPossibleFBT(N-1-l);
            for(TreeNode nl : left){
                for(TreeNode nr : right){
                    root.left = copy(nl);
                    root.right = copy(nr);
                    ans.add(root);
                    root = new TreeNode(0);
                }
            }
        }
        return ans;
    }
    private TreeNode copy(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode ans = new TreeNode(0);
        ans.left = copy(root.left);
        ans.right = copy(root.right);
        return ans;
    }
    public String serialize(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                sb.append("null");
                sb.append(",");
            }
            else{
                sb.append(temp.val);
                sb.append(",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return sb.toString().substring(0, sb.length()-1);
    }	
}

public class BinaryTreePossible{
	public static void main(String[] args){
		Solution s = new Solution();
        List<TreeNode> ans = s.allPossibleFBT(Integer.parseInt(args[0]));
        for(TreeNode n : ans){
            System.out.println(s.serialize(n));
        }
	}
}
