//Leetcode problem  786 k-th Smallest Prime Fraction
//Solution written by Xuqiang Fang on 18 June, 2018
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
    //TLE O(n^2) solution
    public int[] kthSmallestPrimeFraction_(int[] A, int K) {
        int n = A.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                int[] tmp = new int[]{A[i], A[j]};
                list.add(tmp);
            }
        }
        list.sort((a,b)->(a[0]*b[1]-b[0]*a[1]));
        /*
        for(int[] t : list){
            System.out.println(t[0] + ", " + t[1]);
        }
        */
        return list.get(K-1);
    }
    
    //Still TLE
    public int[] kthSmallestPrimeFraction__(int[] A, int K){
        int n = A.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((b,a)->(a[0]*b[1]-a[1]*b[0]));
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                int[] p = new int[]{A[i], A[j]};
                if(queue.size() < K){
                    queue.offer(p);
                }
                else if(queue.size() == K){
                    //System.out.println("here");
                    int[] t = queue.peek();
                    //System.out.println(t[0] + ", " + t[1]);
                    //System.out.println(p[0] + ", " + p[1]);
                    if(p[0]*t[1] < p[1]*t[0]){
                        queue.poll();
                        queue.offer(p);
                    }
                }
            }
        }
        return queue.peek();
    }
    

    //Define a virtual matrix, each row is increasing(left to right) and each column is increasing(up to down)
    public int[] kthSmallestPrimeFraction(int[] A, int K){
        int n = A.length;
        double l = 0;
        double r= 1.0;
        while(l < r){
            double m = (l+r) / 2;
            double max = 0;
            int total = 0;// to denote the number of elements that s.t. A[i]/A[j] > m
            int p = 0, q = 0;//to denote the index of the max element
            int j = 1;
            for(int i=0; i<n-1; ++i){// it's n-1 because the virtual matrix has only n-1 rows
                while(j < n && A[i] > m * A[j]){
                    ++j;
                }
                total += n - j;
                if(n == j){
                    break;
                }
                double f = (double)A[i] / (double)A[j];
                if(f > max){
                    p = i;
                    q = j;
                    max = f;
                }
            }
            if (total == K){
                return new int[]{A[p], A[q]};
            }
            else if(total > K){
                r = m;
            }
            else{
                l = m;
            }
        }
        throw null;
    }
}

public class PrimeFraction{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {1,2,3,5};
        int[] ans = s.kthSmallestPrimeFraction(A, 3);
        System.out.println(ans[0] + ", " + ans[1]);
	}
}
