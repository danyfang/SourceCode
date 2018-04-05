//Leetcode problem 93 Restore IP address
//Solution written by Xuqiang Fang on 24 March 2018 

import java.util.ArrayList;
import java.util.List;
//Solution accepted
class Solution{
	public List<String> restoreIpAddresses(String s){
		List<String> list = new ArrayList<>();
		//the valid address is 0.0.0.0  to 255.255.255.255
		if(s == null || s.length() < 4 || s.length() > 12)
			return list;
		//the idea is to place the three dots between the digits
		int x = 0;
		int y = 0;
		int z = 0;
		int n = s.length();
		int count = 0;
		for(x=1; x<=n-3;x++){
			for(y=x+1; y<=n-2;y++){
				for(z=y+1; z<=n-1; z++){
					count++;
					if(valid(s.substring(0,x)) && valid(s.substring(x,y)) 
					&& valid(s.substring(y,z)) && valid(s.substring(z,n))){
						list.add(s.substring(0,x)+"."+
						s.substring(x,y)+"."+
						s.substring(y,z)+"."+
						s.substring(z,n));
					}
				}
			}
		}
		System.out.println("Searched " + count + " times");
		return list;
	}	
	private boolean valid(String s){
		int value = Integer.valueOf(s);
		if(value >=0 && value <= 255){
			if(value > 0 && s.charAt(0) != '0' || s.equals("0"))
				return true;
		}
		return false;
	}
}

public class RestoreAddress{
	public static void main(String[] args){
		Solution s = new Solution();
		String str = "25525511135";
		System.out.println(s.restoreIpAddresses(args[0]));
	}
}
