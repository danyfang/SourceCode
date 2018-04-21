//Leetcode problem 338 Counting Bits
//Solution written by Xuqiang Fang on 19 April, 2018 
/*
An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
@userlixx2100
public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}

Take number X for example, 10011001.
Divide it in 2 parts:
<1>the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " )
<2>the other digits ( the number of 1, which is " f[i >> 1] ", equivalent to " f[i/2] " )
*/
class Solution{
    public int[] countBits(int num){
        int[] result = new int[num+1]; 
        result[0] = 0;
        for(int i=1; i<=num; ++i){
            //System.out.println((int)Math.log(i));
            //System.out.print((int)Math.pow(2,(int)log2(i)) + "\t");
            result[i] = result[i - (int)Math.pow(2,(int)log2(i))] + 1;
        }
        return result;
    }	
    public static double log2(int n)
    {
        return (Math.log(n) / Math.log(2));
    }
}

public class CountingBits{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] result = s.countBits(Integer.valueOf(args[0]));
        for(int i : result)
            System.out.println(i);
	}
}
