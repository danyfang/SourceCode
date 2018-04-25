//Leetcode problem 421 Maximum XOR of Two Numbers in an Array
//Solution written by Xuqiang Fang on 24 April, 2018 
/*
to iteratively determine what would be each bit of the final result from left to right.
And it narrows down the candidate group iteration by iteration. e.g. assume input are
a,b,c,d,…z, 26 integers in total. In first iteration, if you found that a, d, e, h, u
differs on the MSB(most significant bit), so you are sure your final result’s MSB is set.
Now in second iteration, you try to see if among a, d, e, h, u there are at least
two numbers make the 2nd MSB differs, if yes, then definitely, the 2nd MSB will be set 
in the final result. And maybe at this point the candidate group shinks from a,d,e,h,u 
to a, e, h. Implicitly, every iteration, you are narrowing down the candidate group,
but you don’t need to track how the group is shrinking, you only cares about the final
result.
*/
import java.util.HashSet;
import java.util.Set;

class Solution{
    public int findMaximumXOR(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int max = 0;
        int mask = 0;
        for(int i=31; i>=0; --i){
            mask = mask | (1 << i);
            /*
            This is a routine to generate sequence like following:
            1000000000000
            1100000000000
            1110000000000
            1111000000000
            1111100000000
            1111110000000
            1111111000000
            1111111100000
            1111111110000
            1111111111000
            1111111111100
            1111111111110
            1111111111111
            */  
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }

            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)){
                    max = tmp;
                    break;
                }
            }
        }

        return max;
    }	
}

public class MaximumXOR{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,10,5,25,2,8};
        System.out.println(s.findMaximumXOR(nums));
	}
}
