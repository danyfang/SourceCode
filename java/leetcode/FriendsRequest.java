//Leetcode problem 825 Friends of Appropriate Ages
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
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int[] b = new int[121];
        int c = 0;
        for(int i=0; i<n; ++i){
            b[ages[i]]++;
        }
        for(int i=1; i<=120; ++i){
            if(b[i] > 0){
                for(int j=1; j<i; ++j){
                    if(j <= 0.5*i+7){
                        continue;
                    }
                    c += b[i] * b[j];
                }
                if(i > 0.5*i+7){
                    c += b[i]*(b[i]-1);
                }
            }
        }
        return c;
    }
}

public class FriendsRequest{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] a = {20,30,100,110,120};
        System.out.println(s.numFriendRequests(a));
	}
}
