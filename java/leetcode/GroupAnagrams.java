//Leetcode problem 49 Group Anagrams
//Leetcode problem 242 Valid Anagram 
//Solution written by Xuqiang Fang on 20 March 2018
//Solution for 42 was provided by user@legendaryengineer
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution{
	public List<List<String>> groupAnagrams(String[] strs) {
       	if(strs == null || strs.length == 0)
			return new ArrayList<List<String>>();

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s : strs){
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if(!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		return new ArrayList<List<String>>(map.values());
    }	
	public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length())
			return false;

		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		Arrays.sort(s_arr);
		Arrays.sort(t_arr);
		if(String.valueOf(s_arr).equals(String.valueOf(t_arr)))
			return true;
		return false;
    }
}

public class GroupAnagrams{
	public static void main(String[] args){
		Solution s = new Solution();
		String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
		System.out.println(s.groupAnagrams(strs));
		System.out.println(s.isAnagram(strs[0],strs[1]));
	}
}
