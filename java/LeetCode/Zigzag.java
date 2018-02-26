//Leetcode problem 6 Zigzag convention
//solution written by Xuqiang Fang on 24 Feb 2018
//solution accepted
//also added another solution with better control about index!

//the length of each str[i] 
class Solution{
	public String convert(String s, int numRows){
		if(numRows <= 1 || s.length() <= numRows){
			return s;
		}
		int len = s.length()/numRows;
		String[] str = new String[numRows];
		for(int i=0; i<numRows; i++){
			str[i] = "";
		}
		for(int i=0; i<numRows; i++){
			int j = 0;
			while((2*numRows-2)*j+i < s.length()){
				str[i] = str[i] + s.substring((2*numRows-2)*j+i, (2*numRows-2)*j+i+1);
				if((i != 0 && i != (numRows-1)) && (2*numRows-2)*(j+1)-i < s.length()){
					str[i] = str[i] + s.substring((2*numRows-2)*(j+1)-i,(2*numRows-2)*(j+1)-i+1);
				}
				j++;
			}
		}
		//System.out.println(str[0]);
		//System.out.println(str[1]);
		String result = "";
		for(int i=0; i<numRows; i++){
			result = result + str[i];
		}
		return result;
	}

	public String convert_new(String s, int nRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
		
		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
				sb[idx].append(c[i++]);
			for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
				sb[idx].append(c[i++]);
		}
		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);
		return sb[0].toString();
	}
}

public class Zigzag{
	public static void main(String[] args){
		Solution s = new Solution();
		String a = "paypalbaslfsdljfdsfjdsijfdsiojfsdaiofishiring";//"PHANAPLSIIGYIR";
		String b = "ABAB";
		System.out.println(s.convert(a, 5));
		System.out.println(s.convert_new(a, 5));
		System.out.println(s.convert(b, 2));
		return;
	}
} 
