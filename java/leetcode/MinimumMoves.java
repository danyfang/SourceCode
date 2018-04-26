//Leetcode problem 453 Minimum Moves to Equal Array Elements
//Leetcode problem 462 Minimum Moves to Equal Array Elements II
//Solution written by Xuqiang Fang on 26 April, 2018 

class Solution{
    public int minMoves(int[] nums){
        if(nums == null || nums.length <= 1)
            return 0;
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int sum = 0;

        for(int i : nums){
            min = Math.min(i, min);
            max = Math.max(i, max);
            sum += i;
        }

        return sum - min * n; 
    }	


    //exceeded time limit
    public int minMoves3(int[] nums){
        if(nums == null || nums.length <= 1)
            return 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : nums){
            min = Math.min(i, min);
            max = Math.max(i, max);
            sum += i;
        }
        int moves = (max-min) * n;
        for(int i=min; i<=max; ++i){
            int temp = 0;
            for(int j=0; j<n; ++j){
                temp += Math.abs(i-nums[j]); 
            }
            moves = Math.min(temp, moves);
        }

        return moves;
    }
    
    public int minMoves2(int[] A){
        int sum = 0;
        int median = quickSelect(A, A.length/2+1, 0, A.length-1);
        for(int i : A){
            sum += Math.abs(i-median);
        }
        return sum;
    }

    public int quickSelect(int[] A, int k, int start, int end){
        int l = start;
        int r = end;
        int pivot = A[(l+r)/2];
        while(l <= r){
            while(A[l] < pivot)
                l++;
            while(A[r] > pivot)
                r--;
            if(l >= r)
                break;
            swap(A,l++,r--);
        }

        if(l - start + 1 > k)
            return quickSelect(A,k,start,l-1);
        if(l - start + 1 == k && l == r)
            return A[l];
        return quickSelect(A, k - r + start - 1, r + 1, end);
    }
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}

public class MinimumMoves{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,3};
        int[] nums1 = {1,2,3,7};
        int[] nums2 = {1,2,3,7,3,1,2,4,5,7,8,9,10};
        System.out.println(s.minMoves2(nums));
        System.out.println(s.minMoves2(nums1));
        System.out.println(s.minMoves2(nums2));
        System.out.println(s.minMoves3(nums));
        System.out.println(s.minMoves3(nums1));
        System.out.println(s.minMoves3(nums2));

	}
}
