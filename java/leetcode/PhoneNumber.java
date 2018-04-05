//Leetcode problem 17 Letter Combinations of a Phone Number
//Solution written by Xuqiang Fang on 21 March 2018 
import java.util.ArrayList;
import java.util.List;
class Solution{
	public List<String> letterCombinations(String digits){
		String[] map = new String[] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		List<String> list = new ArrayList<>();
		if(digits == null || digits.length() == 0)
			return list;
		if(digits.length() == 1){
			for(char c : map[Integer.valueOf(digits)].toCharArray()){
				list.add(Character.toString(c));
			}
			return list;
		}
		for(char c : map[Integer.valueOf(digits.substring(0,1))].toCharArray()){
			//System.out.println(c);
			for(String s : letterCombinations(digits.substring(1,digits.length()))){
				list.add(Character.toString(c) + s);
				//System.out.println("s = " + s);
			}
		}
		return list;
	}	
}

public class PhoneNumber{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.letterCombinations("23"));
	}
}
