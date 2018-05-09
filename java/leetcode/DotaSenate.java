//Leetcode problem 692 Dota2 Senate
//Solution written by Xuqiang Fang on 9 May, 2018

import java.util.Queue;
import java.util.LinkedList;

class Solution{
    public String predictPartyVictory(String senate){
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for(int i=0; i<n; ++i){
            if(senate.charAt(i) == 'R')
                radiant.offer(i);
            else
                dire.offer(i);
        }
        if(radiant.size() >= dire.size() * 2)
            return "Radiant";
        else if(dire.size() >= radiant.size() * 2)
            return "Dire";
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int r = radiant.poll();
            int d = dire.poll();
            if(r < d)
                radiant.offer(r + n);
            else
                dire.offer(d + n);
        }

        return (radiant.size() > dire.size()) ? "Radiant" : "Dire";
    }
}

public class DotaSenate{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
