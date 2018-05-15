//Leetcode problem 659 Split Array into Consecutive Subsequences
//Solution written by Xuqiang Fang on 15 May, 2018

import java.util.HashMap;
import java.util.Map;
class Solution{
    //this solution is wrong, it can not handle the case where it needs walking back
    //176/180 cases passed
    public boolean isPossible_(int[] nums){
        if(nums.length < 3)
            return false;
        int min = nums[0];
        int max = nums[nums.length-1];
        int[] arr = new int[max-min+1];
        for(int i : nums){
            arr[i-min]++;
        }
        int begin = arr[0], length = 1, i = 0, j = 0;
        arr[0] = 0;
        while(begin != 0 ){
            for(i=j; i<arr.length-1; ++i){
                if(arr[i+1] > arr[i] && arr[i+1] >= begin){
                    arr[i+1] -= begin;
                    length++;
                }
                else {
                    break;
                }
            }
            for(int x : arr){
                System.out.print(x);
            }
            System.out.println("length = " + length);
            if(length < 3){
                return false;
            }
            for(j=0; j<arr.length; ++j){
                if(arr[j] != 0){
                    begin = arr[j];
                    arr[j] = 0;
                    length = 1;
                    break;
                }
            }
            if(j == arr.length)
                begin = 0;
        }
        return true;
    }


    //solution provided by user@compton_scatter
    public boolean isPossible(int[] nums){
        Map<Integer, Integer> freq = new HashMap<>(); 
        Map<Integer, Integer> appendfreq = new HashMap<>(); 
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        for(int i : nums){
            if(freq.get(i) == 0)
                continue;
            else if(appendfreq.getOrDefault(i, 0) > 0){
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0)+1);
            }
            else if(freq.getOrDefault(i+1, 0) > 0 && freq.getOrDefault(i+2, 0) > 0){
                freq.put(i+1, freq.get(i+1)-1);
                freq.put(i+2, freq.get(i+2)-1);
                appendfreq.put(i+3, appendfreq.getOrDefault(i+3, 0)+1);
            }
            else
                return false;
            freq.put(i, freq.get(i)-1);
        }
        return true;
    }
}

public class ConsecutiveSubsequences{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,8,9,10,11,12,13,14,15,16};
        int[] nums2 = {4,5,6,6,7,8,9,10,10,11};
        int[] nums3 = {13,13,14,14,15,15,16,16,17,18,19,20,21,22,23,23,24,24,25,
        25,26,26,27,27,28,28,29,29,30,30,31,31,32,32,33,33,34,34,35,35,36,36,37,37,
        38,38,39,39,40,40,41,41,42,42,43,43,44,44,45,45,45,46,46,46,47,47,47,47,48,
        48,48,48,49,49,49,49,50,50,50,50,51,51,51,51,52,52,52,52,53,53,53,53,54,54,
        54,54,55,55,55,55,56,56,56,56,57,57,57,57,57,58,58,58,58,59,59,59,60,60,60,
        61,61,61,62,62,62,63,63,63,64,64,64,65,65,65,66,66,66,67,67,67,68,68,68,69,
        69,69,70,70,70,71,71,71,72,72,72,73,73,73,73,73,74,74,74,74,74,75,75,75,75,
        75,76,76,76,76,77,77,77,77,78,78,78,78,79,79,79,79,80,80,80,80,81,81,81,81,
        82,82,82,82,83,83,83,83,84,84,84,84,85,85,85,86,86,86,87,87,87,88,88,88,89,
        89,89,90,90,90,91,91,91,92,92,92,92,93,93,93,93,94,94,94,94,95,95,95,95,96,
        96,96,96,96,97,97,97,97,97,98,98,98,98,98,99,99,99,99,99,100,100,100,100,100,
        101,101,101,101,101,102,102,102,102,102,103,103,103,103,103,104,104,104,104,
        105,105,105,105,106,106,106,106,107,107,107,107,108,108,108,109,109,109,110,
        110,110,111,111,111,112,112,112,113,113,113,114,114,114,115,115,115,116,116,
        116,117,117,117,118,118,118,119,119,119,120,120,120,121,121,121,122,122,122,
        123,123,123,124,124,124,125,125,125,126,126,126,127,127,127,128,128,128,129,
        129,130,130,131,131,132,132,133,133,134,134,135,135,136,136,137,137,138,138,
        139,139,140,140,141,141,142,143,144,145,146,147,148,149,150,151,152,153,154,
        155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172};
        int[] nums4 = {5,6,7,25,26,27,28,29,30,31,32,32,33,33,34,34,35,35,36,36,37,
        37,38,38,39,39,40,40,40,41,41,41,42,42,42,43,43,43,44,44,44,45,45,45,46,46,
        47,47,47,48,48,48,49,49,49,50,50,50,51,51,51,52,52,52,53,53,53,54,54,54,55,
        55,55,56,56,56,57,57,57,58,58,58,59,59,59,60,60,60,61,61,61,62,62,62,63,63,
        63,64,64,64,65,65,65,66,66,66,67,67,67,68,68,68,69,69,69,70,70,70,71,71,71,
        72,72,72,73,73,73,74,74,74,75,75,75,76,76,76,77,77,78,78,79,79,79,79,80,80,
        80,80,81,81,81,81,82,82,82,82,83,83,83,83,84,84,84,84,85,85,85,85,86,86,86,
        86,87,87,87,87,88,88,88,88,89,89,89,89,90,90,90,90,91,91,91,91,92,92,92,92,
        93,93,93,93,93,94,94,94,94,94,95,95,95,95,95,96,96,96,96,96,97,97,97,97,97,
        98,98,98,98,98,99,99,99,99,99,100,100,100,100,100,101,101,101,101,101,102,
        102,102,102,102,103,103,103,103,103,104,104,104,104,105,105,105,105,106,106,
        106,106,107,107,107,107,108,108,108,108,109,109,109,109,110,110,110,110,111,
        111,111,111,112,112,112,112,113,113,113,114,114,114,115,115,116,116,117,117,
        118,118,119,120};
        //System.out.println(s.isPossible(nums));
        //System.out.println(s.isPossible(nums2));
        //System.out.println(s.isPossible(nums3));
        System.out.println(s.isPossible(nums4));
	}
}
