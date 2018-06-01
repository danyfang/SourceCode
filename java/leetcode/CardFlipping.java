//Leetcode problem  822 Card Flipping Game
//Solution written by Xuqiang Fang on 31 May, 2018
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
    public int flipgame(int[] f, int[] b){
        int[] a = new int[2001];
        int n = f.length;
        for(int i=0; i<n; ++i){
            if(f[i] == b[i]){
                a[f[i]] = Integer.MIN_VALUE;
            }
            else{
                a[f[i]]++;
                a[b[i]]++;
            }
        }
        for(int i=1; i<=2000; ++i){
            if(a[i] >= 1){
                return i;
            }
        }
        return 0;
    }
}

public class CardFlipping{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] f = {1,2,4,4,7};
        int[] b = {1,3,4,1,3};
        System.out.println(s.flipgame(f,b));
	}
}
