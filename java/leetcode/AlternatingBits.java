//Leetcode problem 693 Binary Number with Alternating Bits
//Solution written by Xuqiang Fang on 10 May, 2018
class Solution{
    public boolean hasAlternatingBits(int n){
        char[] ch = Integer.toBinaryString(n).toCharArray();
        for(int i=1; i<ch.length; ++i){
            if(ch[i] == ch[i-1])
                return false;
        }

        return true;
    }
}

public class AlternatingBits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.hasAlternatingBits(Integer.valueOf(args[0])));
	}
}
