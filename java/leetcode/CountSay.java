//Leetcode problem 38 Count and Say
//Solution written by Xuqiang Fang on 25 March 2018 

class Solution{
	public String countAndSay(int n){
		String s = "1";
		if(n == 1)
			return s;
		
		int num = 0, next = 0, count = 1;
		String str = "";
		for(int i=2; i<=n; i++){
			num = Integer.valueOf(s.substring(0,1));
			for(int j=1; j<s.length(); j++){
				next = Integer.valueOf(s.substring(j,j+1));
				if(next != num){
					str += "" + count + num;
					num = next;
					count = 1;
				}
				else{
					count++;
				}
			}
			s = str + "" + count + num;
			count = 1;
			str = "";
		}
		return s;
	}	
	public String convert(String s){
		String result = "";
		if(s == null || s.length() < 1)
			return result;
		int count = 1;
		int num = Integer.valueOf(s.substring(0,1));
		int next = num;
		for(int i=1; i<s.length(); i++){
			next = Integer.valueOf(s.substring(i,i+1));
			if(next != num){
				result +=  "" + count + num;	
				num = next; 
				count = 1;
			}else{
				count++;
			}
		}
		result += "" + count + num; 
		return result;
	}
}

public class CountSay{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.countAndSay(Integer.valueOf(args[0])));
	}
}
