//Leetcode problem  836 Rectangle Overlap
//Solution written by Xuqiang Fang on 20 May, 2018


/**
Given two ranges[a,b] and [c,d]
isOverlap(A, B)
    return Math.max(a,c) < Math.min(d,d)

Given two ranges [x1,x2], [y1,y2]

def is_overlapping(x1,x2,y1,y2):
    return max(x1,y1) <= min(x2,y2)
 
*/
class Solution{
    public boolean isRectangleOverlap(int[] A, int[] B) {
        return Math.max(A[0], B[0]) < Math.min(A[2], B[2]) && Math.max(A[1],B[1]) < Math.min(A[3],B[3]);
    }
}

public class RectangleOverlap{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
