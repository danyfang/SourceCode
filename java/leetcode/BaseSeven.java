//Leetcode problem 504 Base 7
//Solution written by Xuqiang Fang on 9 May, 2018
class Solution{
    public String convertToBase7(int num){
        if(num == 0)
            return "0";
        int sign = num < 0 ? -1 : 1;  
        num = Math.abs(num);
        int pow = 0;
        int res = 1;
        while(res <= num){
            pow++;
            res *= 7;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=pow-1; i>=0; --i){
            int unit = (int)Math.pow(7, i);
            int d = num / unit;
            num = num - unit * d;
            sb.append(d);
        }

        if(sign == -1)
            return "-" + sb.toString();
        return sb.toString();
    }

}

public class BaseSeven{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.convertToBase7(Integer.valueOf(args[0])));
	}
}
