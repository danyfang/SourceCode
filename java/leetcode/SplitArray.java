//Leetcode problem 410 Split Array Largest Sum
//Solution written by Xuqiang Fang on 24 May,2018
import java.util.HashMap;
import java.util.Map;
class Solution{
    //TLE and overflow
    public int splitArray_(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n];
        Map<Tuple, Integer> map = new HashMap<>();
        sum[0] = nums[0];
        for(int i=1; i<n; ++i){
            sum[i] = sum[i-1] + nums[i]; 
        }

        return recursion(nums, sum, 0, n, m, map);
    }

    private int recursion(int[] nums, int[] sum, int s, int e, int m, Map<Tuple, Integer> map){
        int n = nums.length;
        if(m == 1 || e-s == 1){
            return sum[e-1]-sum[s]+nums[s];
        }
        int min = sum[sum.length-1];
        //split it into [s,...,i]
        for(int i=s+1; i<e; ++i){
            Tuple t = new Tuple(s,m);
            if(map.containsKey(t)){
                min = Math.min(min, Math.max(sum[i-1]-sum[s]+nums[s], map.get(t)));
                continue;
            }
            min = Math.min(min, Math.max(sum[i-1]-sum[s]+nums[s], recursion(nums, sum, i, e, m-1, map)));
        }
        map.put(new Tuple(s,m), min);
        return min;
    }
    class Tuple{
        int start;
        int m;
        Tuple(int s, int p){
            start = s;
            m = p;
        }
    }


    //answer provided by user@dax1ng
    public int splitArray(int[] nums, int m){
        int max = 0;
        long sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        if(m == 1){
            return (int)sum;
        }
        long l = max;
        long r = sum;
        while(l <= r){
            long mid = (l + r) / 2;
            if(valid(mid, nums, m)){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return (int)l;
    }

    private boolean valid(long target, int[] nums, int m){
        int count = 1;
        long total = 0;
        for(int num : nums){
            total += num;
            if(total > target){
                total = num;
                count++;
                if(count > m){
                    return false;
                }
            }
        }
        return true;
    }
}

public class SplitArray{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {7,2,5,10,8};
        System.out.println(s.splitArray(nums, 2));
	}
}
