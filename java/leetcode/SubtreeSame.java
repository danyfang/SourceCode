//Leetcode problem 572 Subtree of Another Tree
//Solution written by Xuqiang Fang on 5 April, 2018 
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}


class Solution{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return t == null;
        if(t == null)
            return s == null;

        if(s.val == t.val){
            return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        else{
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }	
    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null)
            return t == null;
        if(t == null)
            return s == null;
            
        if(s.val == t.val)
            return isSame(s.left, t.left) && isSame(s.right, t.right);

        return false;
    }
}

public class SubtreeSame{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root1 = new TreeNode(4);
        TreeNode a1 = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        root1.left = a1;
        root1.right = b1;
        TreeNode root2 = new TreeNode(4);
        TreeNode a2 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        root2.left = a2;
        root2.right = b2;
        System.out.println(s.isSame(root1, root2));
	}
}
