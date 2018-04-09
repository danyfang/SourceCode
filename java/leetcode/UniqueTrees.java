//Leetcode problem 96 Unique Binary Search Trees
//Leetcode problem 95 Unique Binary Search Trees II
//Solution written by Xuqiang Fang on 25 March 2018 
import java.util.ArrayList;
import java.util.List;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x){
		val = x;
	}
}
class Solution{
	public int numTrees(int n){
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				dp[i] += dp[j-1] * dp[i-j];
			}
		}
		return dp[n];
	}	
    public List<TreeNode> generateTrees(int n){
        List<TreeNode> list = recursive(0, n); 
        return list;
    }
    public List<TreeNode> recursive(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start == end)
            return list;
        else if(start == end - 1){
            list.add(new TreeNode(end));
            return list;
        }
        else{
            for(int i=end; i>start; i--){
                List<TreeNode> left = recursive(start, i-1);
                List<TreeNode> right = recursive(i, end);
                //System.out.println("left size" + left.size());
                //System.out.println("right size" + right.size());
                if(right.size() == 0){
                    for(TreeNode l : left){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        list.add(root);
                    }
                }else if(left.size() == 0){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(i);
                        root.right = r;
                        list.add(root);
                    }
                }else{
                    for(TreeNode l : left){
                        for(TreeNode r : right){
                            TreeNode root = new TreeNode(i);
                            root.left = l;
                            root.right = r;
                            list.add(root);
                        }
                    }
                }
            }
            return list;
        }
    }
}

public class UniqueTrees{
	public static void main(String[] args){
		Solution s = new Solution();
		//System.out.println(s.numTrees(Integer.valueOf(args[0])));
        List<TreeNode> list = s.generateTrees(10);
		System.out.println(s.numTrees(10));
        System.out.println(list.size());
        /*
        for(TreeNode t : list){
            print(t);
        }
        */
	}
    public static void print(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            print(root.left);
            print(root.right);
        }
        else
            return;
    }
}
