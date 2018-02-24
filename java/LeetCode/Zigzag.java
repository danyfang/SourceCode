//Leetcode problem 6 Zigzag convention
//solution written by Xuqiang Fang on 24 Feb 2018

class Solution{
	public String convert(String s, int numRows){
		//todo
		if(numRows <= 1){
			return s;
		}
		char[] chr = new char[2*numRows-2];
		String[] str = new String[numRows];
		for(int i=0; i<numRows; i++){
			str[i] = "";
		}
		int j = 0;
		for(int i=0; i<s.length(); i++){
			if(j == 2*numRows-2 ){
				System.out.println(chr);
				j = 0;
				while(j<numRows){
					str[j] = str[j] + (String.valueOf(chr[j]) + ((j>0 && j<numRows-1) ? String.valueOf(chr[2*numRows-2-j]) : "") );
					j++;
				}
				j = 0;	
			}
			if(j<2*numRows-2){
				chr[j] = s.charAt(i);
				if(i == s.length()-1){
					System.out.println(chr);
					j = 0;
					while(j<s.length()%numRows){
						str[j] = str[j] + (String.valueOf(chr[j]) + ((j>0 && j<numRows-1 && (2*numRows-2-j < (s.length()%numRows))) ? String.valueOf(chr[2*numRows-2-j]) : "") );
						j++;
					}
				}
				j++;
				continue;
			}
		}
		String result = "";
		for(int i=0; i<numRows; i++){
			System.out.println(str[i]);
			result = result + str[i];
		}
		return result;
	}
}

public class Zigzag{
	public static void main(String[] args){
		Solution s = new Solution();
		String a = "paypalishiring";//"PHANAPLSIIGYIR";
		System.out.println(s.convert(a, 3));
		return;
	}
} 
