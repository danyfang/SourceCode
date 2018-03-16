//Leetcode problem 102 Binary Tree Level Order Traversal
//Solution written by Xuqiang Fang on 12 March 2018 
// This solution was taken from reference solution on programcreek.com
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
class Solution{
    public List<List<Integer>> levelOrder_(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

	public List<List<Integer>>	levelOrder(TreeNode root){
		if (root == null)	
			return null;
	
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		current.add(root);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> rootLevel = new ArrayList<Integer>(root.val);

		while(! current.isEmpty()){
			TreeNode node = current.remove();
			
			if(node.left != null)
				next.add(node.left);

			if(node.right != null)
				next.add(node.right);

			rootLevel.add(node.val);
			if(current.isEmpty()){
				current = next;
				next = new LinkedList<TreeNode>();
				result.add(rootLevel);
				rootLevel = new ArrayList<Integer>();
			}
			
		}
		return result;
			
	}
}

public class LevelTraversal{
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
		System.out.println(s.levelOrder(root));
	}
}
