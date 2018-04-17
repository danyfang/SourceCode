//Leetcode problem 372 Super Pow
//Solution written by Xuqiang Fang on 17 April, 2018
/*
* One knowledge: ab % k = (a%k)(b%k)%k
* Since the power here is an array, we’d better handle it digit by digit.
* One observation:
* a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
*/
class Solution{
    private final int base = 1337;
    public int superPow(int a, int[] b){
        if(b == null || b.length == 0)
            return 1;
        int last = b[b.length-1];
        int[] new_b = new int[b.length-1];
        for(int i=0; i<b.length-1; i++)
            new_b[i] = b[i];
        return powmd(superPow(a,new_b), 10) * powmd(a, last) % base;
    }	
    private int powmd(int a, int k){// a^k mod base where 0 <= k <= 10
        a %= base;
        int result = 1;
        for(int i=0; i<k; i++)
            result = (result * a) % base;
        return result;
    }
}

public class SuperPow{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,3};
        System.out.println(s.superPow(2, nums));
	}
}
