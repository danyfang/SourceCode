//Leetcode problem 857 Minimum Cost to Hire K Workers
//Solution written by Xuqiang Fang on 24 June, 2018
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
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        int[][] work = new int[n][2];
        for(int i=0; i<n; ++i){
            work[i][0] = wage[i];
            work[i][1] = quality[i];
        }
        Arrays.sort(work, (a,b)->(Double.compare((double)a[0]/a[1], (double)b[0]/b[1])));
        /*
        for(int[] w : work){
            System.out.println(w[1]);
        }
        */
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->(b-a));
        int sum = 0;
        for(int i=0; i<K; ++i){
            q.offer(work[i][1]);
            sum += work[i][1];
        }
        double ans = sum * (double)work[K-1][0]/work[K-1][1];
        //System.out.println(ans);
        for(int i=K; i<n; ++i){
            int qua = q.poll();
            q.offer(work[i][1]);
            sum = sum - qua + work[i][1];
            double t = sum * (double)work[i][0]/work[i][1];
            //System.out.println(sum - qua + work[i][1]);
            ans = Math.min(ans, t);
            //System.out.println("ans = " + ans);
        }
        /*
        while(q.size() > 0){
            System.out.println(q.poll());
        }
        */
        return ans;
    }
}

public class HireCost{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        /*
        System.out.println(s.mincostToHireWorkers(quality, wage, 1));
        System.out.println(s.mincostToHireWorkers(quality, wage, 2));
        System.out.println(s.mincostToHireWorkers(quality, wage, 3));
        quality = new int[]{3,1,10,10,1};
        wage = new int[]{4,8,2,2,7};
        System.out.println(s.mincostToHireWorkers(quality, wage, 1));
        System.out.println(s.mincostToHireWorkers(quality, wage, 2));
        System.out.println(s.mincostToHireWorkers(quality, wage, 3));
        System.out.println(s.mincostToHireWorkers(quality, wage, 4));
        System.out.println(s.mincostToHireWorkers(quality, wage, 5));
        quality = new int[]{2,1,5};
        wage = new int[]{17, 6, 4};
        System.out.println(s.mincostToHireWorkers(quality, wage, 2));//25.5
        */
        quality = new int[]{14,56,59,89,39,26,86,76,3,36};
        wage = new int[]{90,217,301,202,294,445,473,245,415,487};
        System.out.println(s.mincostToHireWorkers(quality, wage, 2));//399.53846
	}
}
