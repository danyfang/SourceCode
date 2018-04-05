//Leetcode problem 76 Minimum Window Substring
//Solution written by Xuqiang Fang on 26 March 2018 

import java.util.HashMap;
import java.util.Map;

class Solution{
	public String minWindow(String s, String t){
		Map<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray())
			map.put(c,0);
		for(char c : t.toCharArray()){
			if(map.containsKey(c))
				map.put(c,map.get(c)+1);
			else
				return "";
		}

		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = t.length();

		while(end < s.length()){
			char c1 = s.charAt(end);
			if(map.get(c1) > 0)
				count--;
			map.put(c1,map.get(c1)-1);
			end++;

			while(count == 0){
				if(minLen > end - start){
					minLen = end - start;
					minStart = start;
				}

				char c2 = s.charAt(start);
				map.put(c2,map.get(c2)+1);

				if(map.get(c2) > 0)
					count++;

				start++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
	}	
}

public class MiniWindowSubstring{
	public static void main(String[] args){
		Solution s = new Solution();
		String str = "ADOBECODEBANABCBBAC";
		String t = "ABC";
		System.out.println(s.minWindow(str,t));
	}
}
