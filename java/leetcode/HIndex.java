//Leetcode problem 274 H-Index
//Leetcode problem 275 H-Index II
//Solution written by Xuqiang Fang on  15 April, 2018

class Solution{
    //follow up, question 275
    //citations array is sorted
    public int hdex(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(len - i <= nums[i])
                return (len-i);
        }
        return 0;
    }
    //O(n) solution provided by user@pythonicjava
    //idea is bucket sort
    public int index(int[] citations){
        if(citations == null || citations.length == 0)
            return 0;
        int len = citations.length;
        int[] bucket = new int[len+1];
        for(int i=0; i<len; i++){
            if(citations[i] > len)
                bucket[len] += 1;
            else
                bucket[citations[i]] += 1;
        }
        int count = 0;
        for(int i=len; i>=0; i--){
            count += bucket[i];
            if(count >= i)
                return i;
        }

        return 0;
    }
    public int Hindex(int[] citations){
        //brutal force
        if(citations == null || citations.length == 0) 
            return 0;
        int n = citations.length;
        System.out.println("Total N papers " + n);
        int cite = 0; 
        for(int h=n; h>=0; h--){
            cite = 0;
            for(int j=0; j<n; j++){
                if(citations[j] >= h){
                    cite++; 
                }
            }
            System.out.println("h = " + h + " cite = " + cite);
            if(cite >= h){
                cite = 0;
                for(int j=0; j<n; j++){
                    if(citations[j] <= h){
                        cite++;
                    }
                }
                System.out.println( cite + " papers has no more than " + h);
                return h;
            }
        }
        return cite;
    }	
    public int hIndex(int[] citations){
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int cite = 0;
        int sum = 0;
        int H = 0;
        for(int i=0; i<n; i++){
            sum += citations[i];
        }
        H = Math.min((int)Math.sqrt(sum), n);
        for(int h=H; h>=0; h--){
            cite = 0;
            for(int j=0; j<n; j++){
                if(citations[j] >= h){
                    cite++; 
                }
            }
            if(cite >= h){
                return h;
            }
        }

        return 0; 
    }


}

public class HIndex{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,0,6,1,5,4,2,3,4,5,7,8,9,4,9,9,4,5,3,4,4,2,2,3,2,9,4839};
        int[] nums2 = {1,2,3,4,5,6,7,7,9};
        int[] nums3 = {9,9,9,9,9,9};
        int[] nums4 = {1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(s.index(nums2));
        System.out.println(s.hdex(nums2));
        System.out.println(s.hdex(nums3));
        System.out.println(s.index(nums3));
        System.out.println(s.hdex(nums4));
	}
}
