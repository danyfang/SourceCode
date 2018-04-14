//Leetcode problem 190 Reverse Bits
//Leetcode problem 191 Number of 1 Bits 
//Solution written by Xuqiang Fang on 12 April, 2018 
import java.lang.StringBuilder;
class Solution{
    public int reverseBits(int n){
        int[] nums = new int[32];
        String s = Integer.toBinaryString(n);
        //System.out.println(s);
        //System.out.println(s.length());
        for(int i=0; i<s.length(); i++){
            nums[32-s.length()+i] = Integer.valueOf(s.substring(i,i+1));
        }
        int temp = 0;
        for(int i=0; i<16; i++){
            temp = nums[i];
            nums[i] = nums[31-i];
            nums[31-i] = temp;
        }
        StringBuilder result = new StringBuilder();
        for(int i : nums)
            result.append(i);
        //System.out.println(Integer.parseUnsignedInt(s)); 
        return Integer.parseUnsignedInt(result.toString(),2);
    }	

    public int hammingWeight(int n){
        int[] nums = new int[32];
        String s = Integer.toBinaryString(n);
        int count = 0; 
        for(char c : s.toCharArray()){
            if(c == '1')
                count++;
        }
        return count;
    }
}

public class ReverseBits{
	public static void main(String[] args){
		Solution s = new Solution();
            
        //System.out.println(s.reverseBits(Integer.valueOf(args[0])));
        /*
        System.out.println(s.reverseBits(Integer.MIN_VALUE));
        System.out.println(s.reverseBits(Integer.MAX_VALUE));
        System.out.println(s.reverseBits(0));
        System.out.println(s.reverseBits(1));
        System.out.println(s.reverseBits(-1));
        */
        System.out.println(s.hammingWeight(Integer.valueOf(args[0])));
	}
}
