//Leetcode problem 131 Palindrome Partitioning
//Solution written by Xuqiang Fang on 7 April, 2018 
import java.util.ArrayList;
import java.util.List;
class Solution{
    public List<List<String>> partition(String s){
        List<List<String>> list = new ArrayList<>(); 
        if(s == null || s.length() <= 0)
            return list;
        int n = s.length();
        if(n == 1){
            List<String> temp = new ArrayList<>();
            temp.add(s);
            list.add(temp);
            return list;
        }
        List<List<String>> sub = partition(s.substring(0,n-1));
    }	
}

public class PalindromePart{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
