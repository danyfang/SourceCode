//Leetcode problem No 179 Larget Number
//Solution written by Xuqiang Fang on 12 April, 2018 
import java.util.Arrays;
import java.util.Comparator;
import java.lang.StringBuilder;

class Solution{
    public String largestNumber(int[] nums){
        if(nums == null || nums.length == 0)
            return "";
        
        String[] str_arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            str_arr[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };

        Arrays.sort(str_arr, comp);
        if(str_arr[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : str_arr){
            sb.append(s);
        }

        return sb.toString();
    }	
}

public class LargestNumber{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(s.largestNumber(nums));
	}
}
