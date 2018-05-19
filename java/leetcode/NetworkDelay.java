//Leetcode problem  743 Network Delay Time
//Solution written by Xuqiang Fang on 19 May, 2018
import java.util.Arrays;
class Solution{
    /**
    This question is a graph problem: single source all destinations shortest path

    */
    public int networkDelayTime(int[][] times, int N, int K){
        int[] distance = new int[N];
        Arrays.fill(distance, MAX_TIME);
        distance[K-1] = 0;

        for(int i=1; i<N; ++i){
            for(int[] time : times){
                int u = time[0]-1;
                int v = time[1]-1;
                int w = time[2];
                distance[v] = Math.min(distance[v], distance[u]+w);
            }
        }

        int max_distance = 0;
        for(int dist : distance){
            max_distance = Math.max(max_distance, dist);
        }

        return max_distance == MAX_TIME ? -1 : max_distance;
    } 
    private int MAX_TIME = 100 * 101;
}

public class NetworkDelay{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(s.networkDelayTime(times, 4, 2));
	}
}
