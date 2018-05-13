//Leetcode problem  738 Monotone Increasing Digits
//Solution written by Xuqiang Fang on 12 May, 2018
class Solution{
    public int monotoneIncreasingDigits(int N){
        if(N <= 9)
            return N;
        char[] ch = String.valueOf(N).toCharArray();
        for(int i=ch.length-2; i>=0; --i){
            if(ch[i] > ch[i+1]){
                ch[i+1] = '9';
                ch[i] = (char)(ch[i] - 1);
            } 
        }
        for(int i=1; i<ch.length; ++i){
            if(ch[i] == '9'){
                for(int j=i+1; j<ch.length; ++j){
                    ch[j] = '9';
                }
                break;
            }
        }
        if(ch[0] == '0'){
            return Integer.valueOf(String.valueOf(ch, 1, ch.length-1));
        }
        return Integer.valueOf(String.valueOf(ch));
    }
}

public class MonotoneDigits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.monotoneIncreasingDigits(Integer.valueOf(args[0])));
	}
}
