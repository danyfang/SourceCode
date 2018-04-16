//Leetcode problem 349 Intersection of Two Arrays
//Solution written by Xuqiang Fang on 15 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
class Solution{
    public int[] intersection(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        if(nums1 == null || nums2 == null)
            return nums1;
        //we may always build hashmap on the smaller set
        if(nums2.length < nums1.length){
            int[] num = nums1;
            nums1 = nums2;
            nums2 = num;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums1){
            if(!set.contains(i))
                set.add(i);
        }
        System.out.println(set.size());
        for(int i : nums2){
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            result[i] = list.get(i);
    }	
}

public class IntersectionArrays{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums1 = {1,1,2,2,3,4};
        int[] nums2 = {2,2};
        System.out.println(s.intersection(nums1, nums2));
	}
}
