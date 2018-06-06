//Leetcode problem 480 Sliding Window Median
//Solution written by Xuqiang Fang on 5 June, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    public double[] medianSlidingWindow(int[] nums, int k){
        int n = nums.length;
        if(k == 0){
            double[] ans = new double[n-k];
            for(int i=0; i<n; ++i){
                ans[i] = (double)nums[i];
            }
            return ans;
        }
        double[] ans = new double[n-k+1];
        int[] s = new int[k];
        for(int i=0; i<k; ++i){
            s[i] = nums[i];
        }
        Arrays.sort(s);
        if(k % 2 == 0){
            ans[0] = (double)(s[k/2-1] + s[k/2]) / 2.0;
            for(int i=0; i<n-k; ++i){
                insertRemove(s, nums[i], nums[i+k]);
                ans[i+1] = (double)(s[k/2] + s[k/2-1]) / 2.0;
            } 
        }
        else{
            ans[0] = (double)(s[(k-1)/2]); 
            for(int i=0; i<n-k; ++i){
                insertRemove(s, nums[i], nums[i+k]);
                ans[i+1] = (double)(s[(k-1)/2]);
            }
        }
        return ans;
    }
    private void insertRemove(int[] nums, int out, int in){
        if(in < out){
            //in this case, we need to insert in before out
            //before we find the right spot, all elements must move one spot right
            for(int i=0; i<nums.length; ++i){
                if(nums[i] == out){
                    for(int j=i; j>=1; --j){
                        if(in >= nums[j-1]){
                            nums[j] = in;
                            return;
                        }
                        else{
                            nums[j] = nums[j-1];
                        }
                    }        
                    nums[0] = in;
                } 
            }
        }
        else if(in > out){
            //in this case, we need to insert in after out
            //before we find the right spot, all elements must move one spot left
            for(int i=nums.length-1; i>=0; --i){
                if(nums[i] == out){
                    for(int j=i; j<nums.length-1; ++j){
                        if(in <= nums[j+1]){
                            nums[j] = in;
                            return;
                        }
                        else{
                            nums[j] = nums[j+1];
                        }
                    }
                    nums[nums.length-1] = in;
                }
            } 
        }

    }
}

public class SlidingWindowMedian{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        double[] ans = s.medianSlidingWindow(nums, 3);
        for(double a : ans){
            System.out.println(a);
        }
	}
}
