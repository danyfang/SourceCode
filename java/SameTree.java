import java.util.ArrayList;
import java.lang.Integer;



class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       ArrayList<Integer> pList = new ArrayList<>(); 
       ArrayList<Integer> qList = new ArrayList<>(); 
	   pList = this.traverse(p);
	   qList = this.traverse(q);
	   if(pList.equals(qList)){
	   		return true;
	   }else{
	   		return false;
	   }
    }
	public ArrayList<Integer> traverse(TreeNode p){
		ArrayList<Integer> tra = new ArrayList<>();
			if (p == null){
				tra.add(null);
                return tra;
            }
			else if(p.left == null && p.right == null){
				tra.add(p.val);
			}else{
				tra.addAll(traverse(p.left));
				tra.add(p.val);
				tra.addAll(traverse(p.right));
			}
		return tra;
	}	
}

public class SameTree{
	public static void main(String[] args){
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		a.left = b;
		a.right = c;
		TreeNode d = new TreeNode(2);
		d.left = b;
		d.right = c;
		Solution s = new Solution();
		System.out.println(s.isSameTree(a,d));
	}
}
