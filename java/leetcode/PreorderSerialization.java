//Leetcode problem 331 Verify Preorder Serialization of a Binary Tree
//Solution written by Xuqiang Fang on 19 April, 2018 
import java.util.Stack;
class Solution{
    public boolean isValidSerialization(String preorder){
        //the input string format is always valid
        if(preorder == null || preorder.length() == 0)
            return false;

        if(preorder.length() == 1 && preorder.charAt(0) == '#')
            return true;
        
        String[] ch = preorder.split("\\,");
        Stack<String> stack = new Stack<>();
        int len = ch.length;
        for(int i=len-1; i>=0; i--){
            if(!ch[i].equals("#")){
                if(stack.size() >= 2&&stack.pop().equals("#")&&stack.pop().equals("#")){
                    stack.push("#");
                    continue;
                }
                return false;
            }
            stack.push(ch[i]);
        }
        if(stack.size() == 1)
            return true;
        return false;
    }	
}

public class PreorderSerialization{
	public static void main(String[] args){
		Solution s = new Solution();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String preorder2 = "1,#";
        String preorder3 = "9,#,92,#,#";
        System.out.println(s.isValidSerialization(preorder));
        System.out.println(s.isValidSerialization(preorder2));
        System.out.println(s.isValidSerialization(preorder3));
	}
}
