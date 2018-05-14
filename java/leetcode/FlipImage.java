//Leetcode problem 832 Flipping an Image
//Solution written by Xuqiang Fang on 14 May, 2018
class Solution{
    public int[][] flipAndInvertImage(int[][] A){
        for(int[] a : A){
            int l = 0;
            int r = a.length-1;
            while(l < r){
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            }
            for(int i=0; i<a.length; ++i){
                a[i] = Math.abs(1-a[i]);
            }
        } 
        return A;
    }
}

public class FlipImage{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
