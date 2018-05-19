//Leetcode problem  632 Smallest Range
//Solution written by Xuqiang Fang on 19 May, 2018
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Solution{
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        if(k == 1){
            return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        }
        int[] index = new int[k];
        int lower = nums.get(0).get(0);
        int upper = nums.get(0).get(0);
        for(int i=0; i<k; ++i){
            lower = Math.min(lower, nums.get(i).get(index[i]));
            upper = Math.max(upper, nums.get(i).get(index[i]));
        }
        return new int[]{lower, upper};
    }
}

public class SmallestRange{
	public static void main(String[] args){
		Solution s = new Solution();
        List<Integer> list1 = Arrays.asList(4,10,15,24,26);
        List<Integer> list2 = Arrays.asList(0,9,12,20);
        List<Integer> list3 = Arrays.asList(5,18,22,30);
        List<List<Integer>> nums = Arrays.asList(list1, list2, list3);
        int[] range = s.smallestRange(nums);
        System.out.println(range[0] + "\t" + range[1]);
	}
}
