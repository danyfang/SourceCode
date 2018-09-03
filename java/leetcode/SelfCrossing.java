//Leetcode problem 335 Self Crossing
//Solution written by Xuqiang Fang on 3 Sep, 2018 
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
    public boolean isSelfCrossing(int[] x){
        int n = x.length;
        if(n <= 3){
            return false;
        }
        for(int i=3; i<n; ++i){
            //case 1: fourth line crosses first line
            if(x[i] >= x[i-2] && x[i-1] <= x[i-3]){
                return true;
            }
            //case 2: fifth line crosses meets line
            if(i >= 4 && x[i-1] == x[i-3] && x[i]+x[i-4] >= x[i-2]){
                return true;
            }
            //case 3: sixth line crosses first line
            if(i >= 5 && x[i-2] -x[i-4] >= 0 && x[i] >= x[i-2] -x[i-4] && x[i-1] >= x[i-3]-x[i-5] && x[i-1] <= x[i-3]){
                return true;
            }
        }
        return false;
    }
}

public class SelfCrossing{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] x = {1,2,3,4,5,6,7,8};
        System.out.println(s.isSelfCrossing(x));
	}
}
