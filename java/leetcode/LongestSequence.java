//Leetcode problem 128 Longest Consecutive Sequence
//Solution written by Xuqiang Fang on 9 April, 2018 
import java.util.HashMap;
class Solution{
    int longestConsecutive(int[] num){
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i : num){
            if(map.containsKey(i)) 
                continue;
            if(map.containsKey(i-1) && map.containsKey(i+1)){
                int l = map.get(i-1);
                int r = map.get(i+1);
                map.put(i, l+r+1);
                map.put(i-1, l+r+1);
                map.put(i+1, l+r+1);
            }else if(map.containsKey(i-1)){
                int l = map.get(i-1);
                map.put(i, l+1);
                map.put(i-1, l+1);
            }else if(map.containsKey(i+1)){
                int r = map.get(i+1);
                map.put(i, r+1);
                map.put(i+1, r+1);
            }else{
                map.put(i,1);
            }
            ans = Math.max(ans, map.get(i));
        }
        return ans;
    }	
}

public class LongestSequence{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] num = {100,5,5,7,9,8,0};
        int[] nms = {100,4,200,1,3,2};
        System.out.println(s.longestConsecutive(num));
        System.out.println(s.longestConsecutive(nms));
	}
}
