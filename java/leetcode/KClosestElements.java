//Leetcode problem  658 Find K Closest Elements
//Solution written by Xuqiang Fang on 5 May, 2018
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
class Solution{
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        int n = arr.length;
        int[][] copy = new int[n][2];
        for(int i=0; i<n; ++i){
            copy[i][0] = Math.abs(arr[i] - x);
            copy[i][1] = arr[i] > x ? 1 : -1;
        }
        Arrays.sort(copy, new com());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; ++i){
            if(copy[i][1] <= 0)
                list.add(x-copy[i][0]);
            else
                list.add(copy[i][0]+x);
        }
        list.sort(new order());
        return list;
    }

    class com implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            if(a[0] == b[0]){
                return a[1] - b[1];
            } 
            return a[0] - b[0];
        } 
    }

    class order implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return a - b;
        }
    }
}

public class KClosestElements{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,3,4,5};
        System.out.println(s.findClosestElements(nums, 4, Integer.valueOf(args[0])));
	}
}
