//Leetcode problem 10 Regular Expression Matching
//Solution written by xuqiang Fang on 8 May, 2018
//Leetcode Summary Regular Expression

class Solution{
    public String[] evaluateExpression(String exp){
        String[] tokens = exp.split("(?=[-+])");
        return tokens; 
    } 	

    public boolean isMatch(String s, String p){
        if(p.length() == 0){
            if(s.length() == 0)
                return true;
            return false;
        }
        
    }
}

public class RegularExpression{
	public static void main(String[] args){
		Solution s = new Solution();
        String exp = "3x+8-9=7x-9+8";
        String[] tokens = s.evaluateExpression(args[0]);
        for(String t : tokens){
            System.out.println(t);
        }
	}
}
