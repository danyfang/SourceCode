//Leetcode problem 129 Sum Root to Leaf Numbers
//Solution written by Xuqiang Fang on 6 April, 2018 

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return sum(root, 0);
    } 	

    public int sum(TreeNode root, int s){
        if(root == null)
            return 0;

        if(root.right == null && root.left == null)
            return 10*s+root.val;
        return sum(root.left, s*10+root.val) + sum(root.right, s*10+root.val);
    }
    public void printLeaf(TreeNode root){
        TreeNode cur = root;
        if(cur == null)
            return;
        else if(cur.left == null && cur.right == null){
            System.out.println(cur.val);
        }
        printLeaf(root.left);
        printLeaf(root.right);
    }
}

public class SumPath{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(1);
        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.right = f;
        s.printLeaf(a);
        System.out.println(s.sumNumbers(a));
	}
}
