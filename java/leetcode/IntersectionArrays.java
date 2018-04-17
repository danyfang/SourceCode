//Leetcode problem 349 Intersection of Two Arrays
//Leetcode problem 350 Intersection of Two Arrays II
//Solution written by Xuqiang Fang on 15 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
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
        return result;
    }	

    public int[] intersect(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        if(nums1 == null || nums2 == null)
            return nums1;
        //assume nums1 is always the smaller one
        if(nums2.length < nums1.length){
            int[] num = nums1;
            nums1 = nums2;
            nums2 = num;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i : nums2){
            if(!map.containsKey(i))
                continue;
            else if(map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i)-1);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}

public class IntersectionArrays{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums1 = {1,1,2,2,3,4};
        int[] nums2 = {2,2};
        int[] result = s.intersect(nums1, nums2);
        for(int i : result)
            System.out.println(i);
	}
}
