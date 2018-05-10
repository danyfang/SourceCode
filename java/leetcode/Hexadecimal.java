//Leetcode problem 405 Convert a Number to Hexadecimal
//Solution written by Xuqiang Fang on 9 May, 2018
class Solution{
    public String toHex(int num){
        if(num == 0)
            return "0";
        

        char[] digit = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num < 0){
            char[] minus = toHex(-num-1).toCharArray();
            char[] complement = {'f','f','f','f','f','f','f','f'};
            int offset = complement.length - minus.length;
            for(int i=0; i<minus.length; ++i){
                int index = 0;
                if(minus[i] >= 'a'){
                    index = 10 + minus[i] - 'a';
                }
                else{
                    index = minus[i] - '0';
                }
                complement[i+offset] = digit[15 - index];
            }
            return String.valueOf(complement);
        }
        num = Math.abs(num);
        int pow = 0;
        long res = 1;
        while(res <= num){
            pow++;
            res = res * 16;
            System.out.println(res);
        }
        StringBuilder sb = new StringBuilder();
        res /= 16;
        for(int i=pow-1; i>=0; --i){
            int d = (int)(num / res);
            num = (int)(num - res * d);
            sb.append(digit[d]);
            res /= 16;
        }

        return sb.toString();
    }
}

public class Hexadecimal{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.toHex(Integer.valueOf(args[0])));
        //System.out.println(Integer.parseUnsignedInt(s.toHex(Integer.valueOf(args[0])), 16) + Integer.parseUnsignedInt(s.toHex(Integer.valueOf(args[1])), 16));
	}
}
