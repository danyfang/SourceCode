//Leetcode problem 606 Construct String from Binary Tree
//Solution written by Xuqiang Fang on 

class Solution{
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if(left.equals("") && right.equals("")){
            return String.valueOf(t.val);
        }
        else if(right.equals("")){
            return t.val + "(" + left + ")";
        }
        else if(left.equals("")){
            return t.val + "()" + "(" + right + ")";
        }
        else
            return t.val + "(" + left + ")" + "(" + right + ")";
    }	
}

public class BinaryTreeConstructString{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
        System.out.println(s.tree2str(root));
	}
}
