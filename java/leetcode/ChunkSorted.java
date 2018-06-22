//Leetcode problem 769 Max Chunks to Make Sorted
//Leetcode problem 768 Max Chunks to Make Sorted II
//Solution written by Xuqiang Fang on 6 May, 2018
import java.util.Arrays;
class Solution{
    //No 769
    public int maxChunksToSorted_1(int[] arr){
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
    
    //No 768
    //O(n^2) solution
    public int maxChunksToSorted_(int[] arr) {
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        int ans = 0;
        int[] copy = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(copy);
        int max = arr[0];
        int p = 0;
        for(int i=0; i<n; ++i){
            max = Math.max(max, arr[i]);
            if(max == copy[i]){
                int count = 0;
                for(int j=p; j<=i; ++j){
                    if(arr[j] == max){
                        --count;
                    }
                    if(copy[j] == max){
                        ++count;
                    }
                }
                if(count == 0){
                    ans++;
                    p = i+1;
                }
            }
        }
        return ans;
    }

    //another O(n) solution
    //max of left VS min of right
    public int maxChunksToSorted(int[] arr){
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n-1] = arr[n-1];
        for(int i=1; i<n; ++i){
            left[i] = Math.max(left[i-1], arr[i]);
        }
        for(int i=n-2; i>=0; --i){
            right[i] = Math.min(right[i+1], arr[i]);
        }
        int ans = 0;
        for(int i=0; i<n-1; ++i){
            if(left[i] <= right[i+1]){
                ans++;
            }
        }
        return ans+1;
    }
}

public class ChunkSorted{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {4,3,2,1,0};
        int[] arr = {1,0,2,3,4};
        System.out.println(s.maxChunksToSorted(nums));
        System.out.println(s.maxChunksToSorted(arr));

        //test for No768
        int[] a = {2,1,3,4,4};
        System.out.println(s.maxChunksToSorted(a));
	}
}
