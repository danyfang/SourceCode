//Leetcode problem 617 Merge Two Binary Trees
//Solution written by Xuqiang Fang on 12 March 2018
/*
Merge two binary trees if two nodes are at the same position, sum them
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}

class Solution{
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
		if(t1 == null || t2 == null){
			if(t1 == null && t2 == null)
				return null;
			return (t1 == null) ? t2 : t1;
		}
		TreeNode newRoot = new TreeNode(t1.val+t2.val);
		newRoot.left = mergeTrees(t1.left, t2.left);
		newRoot.right = mergeTrees(t1.right, t2.right);

		return newRoot;
	}
	public void printNode(TreeNode t){
		if(t != null){
			this.printNode(t.left);
			System.out.println(t.val);
			this.printNode(t.right);
		}
		return;
	}
}

public class BTreeMerge{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(5);
		a.left = c;
		a.right = b;
		c.left = d;


		TreeNode j = new TreeNode(2);
		TreeNode k = new TreeNode(1);
		TreeNode l = new TreeNode(3);
		TreeNode m = new TreeNode(4);
		TreeNode n = new TreeNode(7);
		j.left = k;
		j.right = l;
		k.right = m;
		l.right = n;
		/*
		s.printNode(s.mergeTrees(a,null));
		s.printNode(s.mergeTrees(null,a));
		s.printNode(s.mergeTrees(null,null));
		*/

		s.printNode(s.mergeTrees(a,j));
	}
}
