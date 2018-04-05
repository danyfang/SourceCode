//Leetcode problem 43 Multiply Strings 415 Add Strings
//Solution written by Xuqiang Fang on 20 March 2018 
//the addition solution exceeded the time limit
//Solution provided by user@yavinci
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuffer;

class Solution{
	public String multiply(String num1, String num2){
		if(num1 == "0" || num2 == "0")
			return "0";
		String result = new String();
		int index = num1.length()-1;
		while(index >= 0){
			int times = Integer.valueOf(num1.substring(index,index+1));
			String temp = new String(num2);
			while(--times > 0){
				temp = sum(temp, num2);
			}
			int j = num1.length()-1-index;
			while(--j >= 0){
				temp += "0";	
			}

			result = sum(result,temp);
			index--;
		}
		return result;	
	}	
	public String sum(String num1, String num2){
		int flag = 0;
		int i = num1.length()-1;
		int j = num2.length()-1;
		List<Integer> list = new ArrayList<>();
		while(flag != 0 || i >= 0 || j >= 0){
			int temp = 0;
			if (i >= 0 && j >= 0 ) 
				temp = flag + Integer.valueOf(num1.substring(i,i+1)) + Integer.valueOf(num2.substring(j,j+1)); 
			else if (i < 0 && j >= 0 )
				temp = flag + Integer.valueOf(num2.substring(j,j+1));
			else if (j < 0 && i >= 0 ) 
				temp = flag + Integer.valueOf(num1.substring(i,i+1));
			else 
				temp = flag;

			
			flag = temp / 10;
			temp = temp % 10;
			list.add(temp);
			i--;
			j--;
		}
		String result = new String();
		while(!list.isEmpty()){
			result += String.valueOf(list.get(list.size()-1));
			list.remove(list.size()-1);
		}
		return result;
	}


	/*
	num1[i]*num2[j] will be placed at indices [i+j, i+j+1]
	*/
	public String mul(String num1, String num2){
		int m = num1.length();
		int n = num2.length();
		int[] pos = new int[m+n];

		for(int i=m-1; i>=0; i--){
			for(int j=n-1; j>=0; j--){
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i+j;
				int p2 = i+j+1;
				int sum = mul + pos[p2];
				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}
}

public class MultiplyStrings{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.mul("12343","322534543"));
	}
}
