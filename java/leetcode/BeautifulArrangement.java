//Leetcode problem 526 Beautiful Arrangement
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
}

public class BeautifulArrangement{
	public static void main(String[] args){
		Solution s = new Solution();
        s.countArrangement(Integer.valueOf(args[0]));
	}
}
