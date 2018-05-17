//Leetcode problem 169 Majority Element
//Leetcode problem 229 Majority Element II
//Solution written by Xuqiang Fang on 11 April, 2018 

import java.util.ArrayList;
import java.util.List;

class Solution{
    int majorityElement_(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int majority = nums[0];
        int count = 0;
        for(int i : nums){
            if(i == majority)
                ++count;
            else if(--count == 0){
                count = 1;
                majority = i;
            }
        }

        return majority;
    }	

    /** Boyer-Moore Algorithm, two passes, O(n) time and O(1) space*/
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        int count1 = 0;
        int count2 = 0;
        int a = nums[0], b = nums[0];
        for(int num : nums){
            if(num == a){
                count1++;
            }
            else if(num == b){
                count2++;
            }
            else if(count1 == 0){
                count1++;
                a = num;
            }
            else if(count2 == 0){
                count2++;
                b = num;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for(int num : nums){
            if(num == a){
                count1++;
            }
            else if(num == b){
                count2++;
            }
        }
        if(count1 > nums.length/3)
            res.add(a);
        if(count2 > nums.length/3)
            res.add(b);
        return res;
    }
}

public class MajorityElement{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {54,2,1,4,4,4,4};
        System.out.println(s.majorityElement(nums));
	}
}
