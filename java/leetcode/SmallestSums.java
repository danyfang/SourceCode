//Leetcode problem 373 Find K Paris with Smallest Sums
//Solution written by Xuqiang Fang on 17 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
class Solution{
    //this solution exceeded memory limit 
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k){
        List<int[]> list = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return list;

        int len1 = nums1.length;
        int len2 = nums2.length;
        int offset = nums1[0] + nums2[0];
        int size = nums1[len1-1] + nums2[len2-1]+1 - offset;
        List<int[]>[] bucket = new ArrayList[size];
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                int sum = nums1[i] + nums2[j] - offset;
                if(bucket[sum] == null){
                    List<int[]> temp = new ArrayList<>();
                    int[] arr = new int[2];
                    arr[0] = nums1[i];
                    arr[1] = nums2[j];
                    temp.add(arr);
                    bucket[sum] = temp;
                }
                else{
                    int[] arr = new int[2];
                    arr[0] = nums1[i];
                    arr[1] = nums2[j];
                    bucket[sum].add(arr);
                }
            }
        }

        for(List<int[]> temp : bucket){
            if(temp != null){
                list.addAll(temp);
            }
            if(list.size() >= k)
                break;
        }
        if(list.size() < k)
            return list;
        return list.subList(0,k);
    }	
    
    //provided by user@bbccyy1
    public List<int[]> kSmallestParis(int[] nums1, int[] nums2, int k){
        //define a priorityqueue with given comparator
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;
        for(int i=0; i<nums1.length && i < k; i++){
            que.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length - 1)
                continue;
            que.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}

public class SmallestSums{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums1 = {-10,-4,0,0,6};
        int[] nums2 = {3,5,6,7,8,100};
        List<int[]> list = s.kSmallestParis(nums1, nums2, 10);
        for(int[] temp : list){
            for(int i : temp)
                System.out.print(i + "\t");
            System.out.println("\n");
        }
	}
}
