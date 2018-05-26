//Leetcode problem  324 Wiggle Sort II
//Solution written by Xuqiang Fang on 25 May, 2018
import java.util.Arrays;
class Solution{
    public void wiggleSort(int[] nums) {
        int n = nums.length;    
        int index = 0;
        int[] c = new int[n];
        for(int i=0; i<n; ++i){
            c[i] = nums[i];
        }
        Arrays.sort(c);
        if(n % 2 == 0){
            int i = n-2;
            while(index < n){
                nums[i] = c[index++];
                i = i - 2;
                if(i < 0){
                    i = n-1;
                }
            }
        }
        else{
            int i = 0 ;
            while(index < n){
                nums[i] = c[index++];
                i = i + 2;
                if(i >= n){
                    i = 1;
                }
            }
        }
    }
}

public class WiggleSort{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1, 5, 1, 1, 6, 4};
        int[] vect = {4,5,5,5,5,6,6,6};
        s.wiggleSort(nums);
        s.wiggleSort(vect);
        for(int n : nums){
            System.out.print(n + " ");
        }
        System.out.println("");
        for(int n : vect){
            System.out.print(n + " ");
        }
        System.out.println("");
	}
}
