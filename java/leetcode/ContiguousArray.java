//Leetcode problem 525 Contiguous Array
//Solution written by Xuqiang Fang on 27 April, 2018
import java.util.HashMap;
import java.util.Map;

class Solution{
    public int findMaxLength(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int sum = 0;
        Map<Integer, Limit> map = new HashMap<>();
        map.put(0, new Limit(-1,-1));
        for(int i=0; i<n; ++i){
            if(nums[i] == 0){
                sum--;
            }
            else{
                sum++;
            }
            if(!map.containsKey(sum)){
                map.put(sum, new Limit(i,i));
            }
            else{
                Limit temp = map.get(sum);
                temp.right = i;
            }
        }
        int max = 0;
        for(Limit temp : map.values()){
            max = Math.max(max, temp.right-temp.left);
        }
        for(int i : map.keySet()){
            System.out.println("i = " + i + " key = "+ map.get(i).left + " " + map.get(i).right);
        }
        return max;
    }	

    class Limit{
        int left;
        int right;
        Limit(int l, int r){
            left = l;
            right = r;
        }
    }
}

public class ContiguousArray{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,0,0,0,1,1,1,1,0};
        System.out.println(s.findMaxLength(nums));
	}
}
