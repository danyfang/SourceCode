//Leetcode problem 228 Summary Ranges
//Solution written by Xuqiang Fang on 17 April, 2018 
import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<String> summaryRanges(int[] nums){
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;
        int len = nums.length;
        int begin = nums[0];
        int prev = nums[0];
        int next = nums[0];
        for(int i=1; i<len; i++){
            next = nums[i];
            if(next == prev + 1){
                prev = next;
                continue;
            }
            else if(prev == begin){
                list.add("" + begin);
            }
            else{
                list.add(begin + "->" + prev);
            }
            begin = next;
            prev = next;

        }
        if(begin == next)
            list.add("" + begin);
        else
            list.add(begin + "->" + next);
        return list;
    }	
}

public class SummaryRange{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {0,1,2,4,5,7};
        int[] nums2 = {0,2,3,4,6,8,9};
        System.out.println(s.summaryRanges(nums2));
	}
}
