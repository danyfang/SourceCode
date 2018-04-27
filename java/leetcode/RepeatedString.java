//Leetcode problem 459 Repeated Substring Pattern
//Solution written by Xuqiang Fang on 27 April, 2018 

class Solution{
    public boolean repeatedSubstringPattern(String s){
        //s is non-empty 
        int n = s.length();
        if(n == 1)
            return false;
        
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n/2; ++i){
            if(n % i == 0){
                int j = i;
                while(j-->0){
                    sb.append(s.substring(0,n/i));  
                }
                if(sb.toString().equals(s)){
                    return true;
                }
                sb.delete(0,n);
            }
        }
        while(n-->0){
            sb.append(s.substring(0,1));
        }
        if(sb.toString().equals(s))
            return true;
        return false;
    }	
}

public class RepeatedString{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern(args[0]));
	}
}
