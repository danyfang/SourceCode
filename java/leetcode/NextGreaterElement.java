//Leetcode problem 496 Next Greater Element I
//Leetcode problem 503 Next Greater Element II
//Solution written by Xuqiang Fang on 3 May, 2018
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
class Solution{
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        if(nums1.length == 0 || nums2.length == 0)
            return nums1;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        stack.push(nums2[0]);
        for(int i=1; i<nums2.length; ++i){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                map.put(stack.pop(), nums2[i]);
            } 
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        int[] ret = new int[nums1.length];
        for(int i=0; i<ret.length; ++i){
            ret[i] = map.get(nums1[i]);
        }

        return ret;
    }	

    public int[] nextGreaterElements(int[] nums){
        if(nums == null || nums.length == 0)
            return nums;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int max = nums[0];
        for(int i : nums){
            max = Math.max(i, max);
        }
        int count = 0;
        while(count++ < 2*nums.length){
            while(!stack.isEmpty() && (nums[index] > nums[stack.peek()] || nums[stack.peek()] == max)){
                if(nums[stack.peek()] == max){
                    map.put(stack.pop(), -1);
                }
                else{
                    map.put(stack.pop(), index);
                }
            } 
            stack.push(index);
            index = (index+1)%nums.length;
        }
        int[] ret = new int[nums.length];
        for(int i=0; i<nums.length; ++i){
            if(map.get(i) == -1)
                ret[i] = -1;
            else
                ret[i] = nums[map.get(i)];
        }
        return ret;
    }

    public int nextGreaterElement(int n){
        long m = (long)n;
        char[] ch = Integer.toString(n).toCharArray();
        
        int low = 0;
        for(int i=ch.length-1; i>=1; --i){
            if(ch[i]>ch[i-1]){
                low = i;
                //now we need to find the smallest after i(include) that is larger than ch[i-1]
                //and exchange it with ch[i-1]
                char min = ch[i];
                int index = i;
                for(int j=i; j<ch.length; ++j){
                    if(ch[j] > ch[i-1] && ch[j] < min){
                        min = ch[j];
                        index = j;
                    } 
                }
                char c = ch[index];
                ch[index] = ch[i-1];
                ch[i-1] = c;
                break;
            }
        }
        if(low != 0){
            //we just need to sort the partial array
            Arrays.sort(ch, low,ch.length);
        }
        long res = Long.parseLong(String.valueOf(ch));
        if(res > (long)Integer.MAX_VALUE || res == m){
            return -1;
        }
        return (int)res;
    }
}

public class NextGreaterElement{
	public static void main(String[] args){
		Solution s = new Solution();
        /*
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        //int[] nums = s.nextGreaterElement(nums1, nums2);
        int[] nums = s.nextGreaterElements(new int[]{1,2,1});
        int[] nums3 = {1,1,2,2343,2,342,4324,234,234,23};
        nums = s.nextGreaterElements(nums3);
        for(int i : nums){
            System.out.println(i);
        }
        */
        System.out.println(s.nextGreaterElement(Integer.valueOf(args[0])));
	}
}
