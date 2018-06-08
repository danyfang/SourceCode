//Leetcode problem 798 Smallest Rotation with Highest Score
//Solution written by Xuqiang Fang on 6 June, 2018
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
/*
* key point is to find out how score changes when K++
* Each time when we rotate, we make index 0 to index N-1, then we get one more point.
* (i - A[i] + N) % N is the value of K making A[i]'s index just equal to A[i].
* when K = (i - A[i] + 1) % N, we start to lose this point, making our score -= 1
* From the description in SmallestRotation.cpp, we know this original question equals to
* find the lower bound of most common interval
* So this is O(n) solution for it
*/
class Solution{
    public int bestRotation(int[] A) {
        int n = A.length;
        int[] change = new int[n];

        for(int i=0; i<n; ++i){
            change[(i-A[i]+1+n)%n] -= 1;
        }
        int max = 0;
        //now change denotes the accumulated score
        for(int i=1; i<n; ++i){
            change[i] += change[i-1] + 1;//each time we get one point and lose points in change[i]
            max = change[i] > change[max] ? i : max;
        }
        return max;
    }
}

public class SmallestRotation{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {2, 3, 1, 4, 0};
        System.out.println(s.bestRotation(A));
	}
}
