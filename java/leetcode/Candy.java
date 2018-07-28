//Leetcode problem 135 Candy
//Solution written by Xuqiang Fang on 26 July, 2018
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
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] child = new int[n+2];
        child[0] = Integer.MAX_VALUE;
        child[n+1] = Integer.MAX_VALUE; 
        for(int i=1; i<=n; ++i){
            child[i] = ratings[i-1];
        }
        int[] candy = new int[n+2];
        for(int i=1; i<=n; ++i){
            if(child[i] <= child[i-1] && child[i] <= child[i+1]){
                candy[i] = 1;
            }
        }
        for(int i=1; i<=n; ){
            if(candy[i] == 1){
                int j=i+1;
                while(candy[j] != 1 && j <= n){
                    if(child[j] > child[j-1]){
                        candy[j] = candy[j-1]+1;
                    }
                    else if(child[j] == child[j-1]){
                        candy[j] = 1;
                    }
                    else if(child[j] < child[j-1]){
                        break;
                    }
                    j++;
                }
                i = j;
            }
            else{
                i++;
            }
        }
        for(int i=n; i>=1; ){
            if(candy[i] == 1){
                int j=i-1;
                while(candy[j] != 1 && j >= 1){
                    if(child[j] > child[j+1]){
                        candy[j] = Math.max(candy[j], candy[j+1]+1);
                    }
                    else if(child[j] < child[j+1]){
                        break;
                    }
                    j--;
                }
                if(candy[j] == 1 && child[j] > child[j+1]){
                    candy[j] = candy[j+1] + 1;
                }
                i = j;
            }
            else{
                i--;
            }
        }
        int sum = 0;
        for(int i=1; i<=n; ++i){
            //System.out.print(candy[i] + "\t");
            sum += candy[i];
        }
        return sum;
    }
}

public class Candy{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] ratings = {1,2,2};
        System.out.println(s.candy(ratings));
        ratings = new int[]{1,0,2,1,2,303,202,3032,2912,293,32932,2};
        System.out.println(s.candy(ratings));
        ratings = new int[]{1,0,2,1,2,3,0,3,2,0,2,3,0,3,2,2,9,1,2,2,9,3,3,2,9,3,2,2};
        System.out.println(s.candy(ratings));
	}
}
