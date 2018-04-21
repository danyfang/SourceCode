//Leetcode problem 389 Find the Difference
//Solution written by Xuqiang Fang on 19 April, 2018 

class Solution{
    public char findTheDifference(String s, String t){
        int[] sa = new int[26];
        int[] ta = new int[26];
        for(char c : s.toCharArray())
            sa[c-'a']++;
        for(char c : t.toCharArray())
            ta[c-'a']++;

        char result = 'a';
        for(int i=0; i<26; i++){
            if(ta[i] - sa[i] == 1)
                result = (char)(i + 'a');
        }
        return result;
    }	
}

public class FindDifference{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.findTheDifference(args[0], args[1]));
	}
}
