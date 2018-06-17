//Leetcode problem 780 Reaching Points
//Solution written by Xuqiang Fang on 16 Junw, 2018
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
    /*sx, sy, tx, ty will all be integers in the range [1, 10^9].*/
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx == tx && sy == ty){
            return true;
        }    
        else if(ty > tx && sy < ty){
            if((ty-sy)/tx >= 1){
                return reachingPoints(sx, sy, tx, ty - ((ty-sy)/tx)*tx);
            }
            return reachingPoints(sx, sy, tx, ty - tx);
        }
        else if(ty < tx && sx < tx){
            if((tx-sx)/ty >= 1){
                return reachingPoints(sx, sy, tx-((tx-sx)/ty)*ty, ty);
            }
            return reachingPoints(sx, sy, tx-ty, ty);
        }
        return false;
    }

    //another iterative solution
    public boolean reaching(int sx, int sy, int tx, int ty){
        while(tx >= sx && ty >= sy){
            if(tx > ty){
                if(sy == ty){
                    return (tx-sx)%ty == 0;
                }
                tx %= ty;
            }
            else{
                if(sx == tx){
                    return (ty-sy)%tx == 0;
                }
                ty %= tx;
            }
        }
        return false;
    }
}

public class ReachingPoints{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.reachingPoints(1,1,3,5));
        System.out.println(s.reachingPoints(1,1,2,2));
        System.out.println(s.reachingPoints(6,5,11,16));
        System.out.println(s.reachingPoints(1,1,10000000,1));
        System.out.println(s.reaching(1,2,999999999,2));
	}
}
