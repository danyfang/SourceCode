//Leetcode problem 383 Ransom Note
//Solution written by Xuqiang Fang on 19 April, 2018

class Solution{
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] num = new int[26];
        for(char c : magazine.toCharArray()){
            num[c-'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            if(--num[c-'a'] < 0)
                return false;
        }
        return true;
    }	
}

public class RansomNote{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.canConstruct(args[0], args[1]));
	}
}
