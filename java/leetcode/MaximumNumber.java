//Leetcode problem  321 Create Maximum Number
//Solution written by Xuqiang Fang on 
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
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k]; 
        for(int i=0; i<k; ++i){
            if(i < nums1.length){
                ans[i] = nums1[i];
            }
            else{
                ans[i] = nums2[i-nums1.length];
            }
        }
        for(int i=Math.max(0, k-nums2.length); i<=Math.min(nums1.length, k); ++i){
            int[] t = merge(helper(nums1, i), helper(nums2, k-i));
            ans = max(ans, t);
        }
        return ans;
    }
    private int[] max(int[] a, int[] b){
        int n = a.length;
        for(int i=0; i<n; ++i){
            if(a[i] > b[i]){
                return a;
            }
            else if(a[i] < b[i]){
                return b;
            }
        }
        return a;
    }
    public int[] helper(int[] a, int k){
        if(k == a.length){
            return a;
        }
        int[] ans = new int[k];
        int l = 0;
        int n = a.length;
        for(int i=0; i<k; ++i){
            int r = n-k+1+i;
            int j = l;
            while(j < r){
                if(a[j] > a[l]){
                    l = j;
                }
                j++;
            }
            ans[i] = a[l++];
        }
        return ans;
    }
    public int[] merge(int[] a, int[] b){
        int[] ans = new int[a.length+b.length];
        int i = 0; 
        int j = 0;
        while(i < a.length || j < b.length){
            if(i < a.length && j < b.length){
                if(a[i] > b[j]){
                    ans[i+j] = a[i];
                    i++;
                }
                else if(a[i] < b[j]){
                    ans[i+j] = b[j];
                    j++;
                }
                else{
                    int x = i;
                    int y = j;
                    int flag = 0;
                    while(x < a.length && y < b.length){
                        if(a[x] == b[y]){
                            x++;
                            y++;
                            if(x == a.length){
                                flag = 1;
                                break;
                            }
                        }
                        else if(a[x] < b[y]){
                            flag = 1;
                            break;
                        }
                        else if(a[x] > b[y]){
                            break;
                        }
                    }
                    if(flag == 1){
                        ans[i+j] = b[j];
                        j++;
                    }
                    else{
                        ans[i+j] = a[i];
                        i++;
                    }
                }
            }
            else if(i < a.length && j >= b.length){
                ans[i+j] = a[i];
                i++;
            }
            else if(i >= a.length && j < b.length){
                ans[i+j] = b[j];
                j++;
            }
        }
        return ans;
    }
}

public class MaximumNumber{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        print(s.helper(nums1, 1));
        print(s.helper(nums1, 2));
        print(s.helper(nums1, 3));
        print(s.helper(nums2, 1));
        print(s.helper(nums2, 2));
        print(s.helper(nums2, 3));
        print(s.helper(nums2, 4));
        print(s.helper(nums2, 5));
        print(s.helper(nums2, 6));
        print(s.maxNumber(nums1, nums2, 2));
        print(s.maxNumber(nums1, nums2, 3));
        print(s.maxNumber(nums1, nums2, 4));
        print(s.maxNumber(nums1, nums2, 5));
        int[] a1 = {8,5,9,5,1,6,9};
        int[] a2 = {2,6,4,3,8,4,1,0,7,2,9,2,8};
        print(s.merge(a1, a2));
	}
    private static void print(int[] a){
        for(int b : a){
            System.out.print(b + "  ");
        }
        System.out.println("");
    }
}
