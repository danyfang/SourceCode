//Leetcode problem 567 Permutation in String
//Solution written by Xuqiang Fang on 21 March 2018 

class Solution{
	public boolean checkInclusion(String s1, String s2){
		int n = s1.length();
		if(s2.length() < n)
			return false;
		for(int i=0; i<=s2.length()-n; i++){
			if(isPermu(s2.substring(i,i+n), s1))
				return true;
		}	
		return false;
	}	
	private boolean isPermu(String s1, String s2){
		int[] count = new int[26];
		for(char c : s1.toCharArray()){
			count[c-'a']++;
		}
		for(char c : s2.toCharArray()){
			count[c-'a']--;
		}
		for(int i : count){
			if(i != 0)
				return false;
		}
		return true;
	}
}

public class PermutationString{
	public static void main(String[] args){
		Solution s = new Solution();
		String s1 = "ab";
		String s2 = "eidboaoo";
		System.out.println(s.checkInclusion(s1,s2));
	}
}
