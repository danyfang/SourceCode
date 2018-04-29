//Leetcode Summary Regular Expression
class Solution{
    public String[] evaluateExpression(String exp){
        String[] tokens = exp.split("(?=[-+])");
        return tokens; 
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
