//Leetcode problem 670 Maximum Swap
//Solution written by Xuqiang Fang on 6 May, 2018
class Solution{
    public int maximumSwap(int num){
        char[] ch = Integer.toString(num).toCharArray();  
        for(int i=0; i<ch.length; ++i){
            char max = ch[i];
            int index = i;
            for(int j=i+1; j<ch.length; ++j){
                if(ch[j] >= max){
                    max = ch[j];
                    index = j;
                }
            }
            if(max > ch[i]){
                char c = ch[index];
                ch[index] = ch[i];
                ch[i] = c;
                break;
            }
        }

        return Integer.valueOf(String.valueOf(ch));
    }
}

public class MaximumSwap{
	public static void main(String[] args){
		Solution s = new Solution();
        int test = 11111011;
        int test2 = 33330123;
        System.out.println(s.maximumSwap(test));
        System.out.println(s.maximumSwap(test2));
        System.out.println(s.maximumSwap(Integer.valueOf(args[0])));
	}
}
