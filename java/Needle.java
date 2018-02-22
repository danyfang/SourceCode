//Leetcode problem 28 Implement strStr()
//Solution written by Xuqiang Fang on 22 Feb, 2018

class Solution {
    public int strStr(String haystack, String needle) {
		if(haystack.equals(needle)){
			return 0;
		}
   		if(haystack.length() < needle.length() || haystack == null || needle ==null){
       		return -1;
     	}
	
		int result = -1;
		int length = needle.length();
		for(int i=0; i<=haystack.length()-length; i++){
			System.out.println(haystack.substring(i,i+length));
			if(haystack.substring(i,i+length).equals(needle)){
				result = i;
				break;
			}
		}
       	return result; 
    }
}

public class Needle{
	public static void main(String[] args){
		Solution s = new Solution();
		String a = "hello";
		String b = "ll";
		String c = "aaaaa";
		String d = "bba";
		String e = "mississippi";
		String f = "pi";
		String g = "mississippi";
		String h = "issi";

		System.out.println(s.strStr(a,b));
		System.out.println(s.strStr(c,d));
		System.out.println(s.strStr(e,f));
		System.out.println(s.strStr(g,h));
	}
}
