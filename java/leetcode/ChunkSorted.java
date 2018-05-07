//Leetcode problem 769 Max Chunks to Make Sorted
//Solution written by Xuqiang Fang on 
class Solution{
    public int maxChunksToSorted(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        int ans = 0;
        int max = arr[0];
        for(int i=0; i<arr.length; ++i){
            max = Math.max(max, arr[i]);
            if(max == i){
                ans++;
            }
        }

        return ans;
    }
}

public class ChunkSorted{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {4,3,2,1,0};
        int[] arr = {1,0,2,3,4};
        System.out.println(s.maxChunksToSorted(nums));
        System.out.println(s.maxChunksToSorted(arr));
	}
}
