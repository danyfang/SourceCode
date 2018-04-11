//Morris Traversal
//Leetcode Problem No 99 Recover Binary Tree
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

class Morris{
    public void morrisTraversal_inorder(TreeNode root){
        TreeNode first = null;
        TreeNode second = null;
        TreeNode temp = null;
        TreeNode pre = null;
        while(root != null){
            if(root.left != null){
                temp = root.left;
                while(temp.right != null && temp.right != root)
                    temp = temp.right;
                
                //restore the tree
                if(temp.right != null){
                    temp.right = null;
                    if(pre != null && pre.val > root.val){
                        if(first == null)
                            first = pre;
                        second = root;
                    }
                    pre = root;
                    root = root.right;
                }
                //thread the tree
                else{
                    temp.right = root;
                    root = root.left;
                }
            }
            else{
                if(pre != null && pre.val > root.val){
                    if(first == null)
                        first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        if(first != null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }	
}

public class MorrisTraversal{
	public static void main(String[] args){
		Morris s = new Morris();
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(4);
        TreeNode d = new TreeNode(3);
        TreeNode c = new TreeNode(2);
        TreeNode b = new TreeNode(6);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(8);
        root.left = b;
        root.right = e;
        b.left = c;
        b.right = a;
        e.left = d;
        e.right = f;

        print(root);
        s.morrisTraversal_inorder(root);
        print(root);
	}
    public static void print(TreeNode root){
        if(root != null){
            print(root.left);
            System.out.println(root.val);
            print(root.right);
        }
    }
}
