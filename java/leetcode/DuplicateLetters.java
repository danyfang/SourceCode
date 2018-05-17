//Leetcode problem 316 Remove Duplicate Letters
//Solution written by Xuqiang Fang on 2 May, 2018 
class Solution{
    //Solution provided by user@lixx2100
    public String removeDuplicateLetters(String s){
        if(s.length() == 0){
            return "";
        }
        int[] count = new int[26];
        int position = 0;
        for(int i=0; i<s.length(); ++i){
            count[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) < s.charAt(position)){
                position = i;
            }
            if(--count[s.charAt(i)-'a'] == 0){
                break;
            }
        }
        String next = s.substring(position+1).replaceAll(""+s.charAt(position),"");
        return s.charAt(position) + removeDuplicateLetters(next);
    }	
}

public class DuplicateLetters{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.removeDuplicateLetters(args[0]));
	}
}
