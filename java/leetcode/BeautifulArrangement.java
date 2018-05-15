//Leetcode problem 526 Beautiful Arrangement
//Leetcode problem 667 Beautiful Arrangement II
//Solution written by Xuqiang Fang on 27 April, 2018 

import java.util.ArrayList;
import java.util.List;

class Solution{
    public int countArrangement(int N){
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), N);
        for(List<Integer> l : list){
            System.out.println(l);
        }
        return list.size();
    }	

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int N){
        if(temp.size() == N){
            /*
            boolean flag = true;
            for(int i=0; i<N; ++i){
                if(!(temp.get(i) % (i+1) ==0 || (i+1)%temp.get(i) == 0)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(new ArrayList<>(temp));
            }
            */
            list.add(new ArrayList<>(temp));
        }
        else{
            for(int i=0; i<N; ++i){
                if(temp.contains(i+1)){
                    continue;
                }
                int size = temp.size() + 1;
                if(!(size % (i+1) ==0 || (i+1)%size == 0)){
                    continue;
                }
                temp.add(i+1);
                backtrack(list, temp, N);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    
    //provided by user@awice
    /*
    When k = n-1, a valid construction is [1, n, 2, n-1, 3, n-2, ....]. One way to see this is,
    we need to have a difference of n-1, which means we need 1 and n adjacent; then, we need a
    difference of n-2, etc.

    This leads to the following idea: we will put [1, 2, ...., n-k-1] first, and then we have 
    N = k+1 adjacent numbers left, of which we want k different differences. This is just the
    answer above translated by n-k-1: we'll put [n-k, n, n-k+1, n-1, ....] after.
    */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i=1; i<n-k; ++i){
            res[i-1] = i;
        }
        for(int i=0; i<=k; ++i){
            if(i % 2 == 0){
                res[n-k+i-1] = n-k+i/2;
            }
            else{
                res[n-k+i-1] = n-i/2;
            }
        }
        return res;
    }
}

public class BeautifulArrangement{
	public static void main(String[] args){
		Solution s = new Solution();
        //s.countArrangement(Integer.valueOf(args[0]));
	}
}
