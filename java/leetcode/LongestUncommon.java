//Leetcode problem 521 Longest Uncommon Subsequence I
//Solution written by Xuqiang Fang on 

class Solution{
    public int findLUSlength(String a, String b){
        if(a.length() != b.length())
            return Math.max(a.length(), b.length());
        else if(a.equals(b))
            return -1;
        return a.length();
    }	
}

public class LongestUncommon{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
