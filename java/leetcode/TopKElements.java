//Leetcode problem 347 Top K Frequent Elements
//Solution written by Xuqiang Fang on 15 April, 2018 
//use bucket sort provided by user@mo10
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class Solution{
    public List<Integer> topKFrequent(int[] nums, int k){
        List<Integer> list = new ArrayList<>(); 
        if(nums == null)
            return list;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int frequency = 0;
        List<Integer>[] bucket = new List[n + 1];
        for(int i : nums){
            frequency = map.getOrDefault(i, 0);
            map.put(i, ++frequency);
        }

        for(int key : map.keySet()){
            frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        for(int i = n-1; i>=0 && list.size() < k; i--){
            if(bucket[i] != null)
                list.addAll(bucket[i]);
        }
        return list.subList(0,k);
    }	
}

public class TopKElements{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9};
        System.out.println(s.topKFrequent(nums, 2));
	}
}
