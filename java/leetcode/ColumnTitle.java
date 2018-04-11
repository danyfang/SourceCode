//Leetcode problem 168 Excel Sheet Column Title
//Leetcode problem 171 Excel Sheet Column Title
//Solution written by Xuqiang Fang on 11 April, 2018 

class Solution{
    public String convertToTitle(int n) {
        String s = "";
        int digit = 0;
        while(n >= 1){
            digit = (n-1) % 26;
            s = String.valueOf((char)(digit+'A')) + s;
            n = (n-1) / 26;
        }
        return s;
    }	
    public int titleToNumber(String s){
        if(s == null)
            return 0;
        char[] ch = s.toCharArray();
        int sum = 0;
        for(char c : ch){
            sum = (c-'A'+1) + sum*26;
        }
        return sum;
    }
}

public class ColumnTitle{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.convertToTitle(Integer.valueOf(args[0])));
        System.out.println(s.titleToNumber(args[1]));
	}
}
