//Leetcode problem 88 Merge Sorted Array
//Solution written by Xuqiang Fang 19 Feb 2018

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int foot1 = 0;
        int foot2 = 0;
        boolean increase = true;
        for(int i=0; i<m-1; i++){//to decide the sorted order, increase or decrease;
            if(nums1[i] > nums1[i+1]){
                increase = false;
            }
        }
        int[] result = new int[nums1.length];
        if(increase){// original order is increasing, all uninitialized elements in nums1 are in the beginning
            foot1 = nums1.length-1;
            foot2 = nums2.length-1;
            for(int i=nums1.length-1; i>=0; i--){
                if(foot1>=0 && foot2>= 0) {
                    if ( nums1[foot1] > nums2[foot2]) {
                        result[i] = nums1[foot1];
                        foot1--;
                    } else {
                        result[i] = nums2[foot2];
                        foot2--;
                    }
                }
                else{
                    result[i] = 0;
                }
            }
        }else{//original order is decreasing, all unitialized elements in nums1 are at the end;
            for(int i=0; i<nums1.length; i++){
                if(foot1<nums1.length && foot2<nums2.length) {
                    if ( nums1[foot1] > nums2[foot2]) {
                        result[i] = nums1[foot1];
                        foot1++;
                    } else {
                        result[i] = nums2[foot2];
                        foot2++;
                    }
                }
                else{
                    result[i] = 0;
                }
            }
        }
        this.printArr(result);
    }

    public void printArr(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
    public void merge2(int A[], int m, int B[], int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
        while (j>-1)         A[k--]=B[j--];
        this.printArr(A);
    }
}


public class MergeSort {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] num1 = {0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9,10};
        int[] num2 = {2,3,4,5,6,7,8,9,10};
        int[] num3 = {10,9,8,7,6,5,4,3,2,1,0,0,0,0,0,0,0,0,0,0};
        int[] num4 = {11,10,9,8,7,6,5,4,3};
        //s.merge(num1,10,num2,9);
        System.out.println("new job");
        //s.merge(num3,10,num4,8);
        s.merge2(num3,10,num4,8);
        return;
    }
}
