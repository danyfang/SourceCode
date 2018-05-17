//Leetcode problem  621 Task Scheduler
//Solution written by Xuqiang Fang on 16 May, 2018
class Solution{
    public int leastInterval(char[] tasks, int n){
        int[] letters = new int[26];
        for(char c : tasks){
            letters[c-'A']++;
        }
        int maxFreq = 0;
        for(int i : letters){
            maxFreq = Math.max(maxFreq, i);
        }
        int p = 0;
        for(int i : letters){
            if(i == maxFreq)
                p++;
        }
        int ans = (maxFreq-1)*(n+1)+p;
        return Math.max(ans, tasks.length);
    }
}

public class TaskScheduler{
	public static void main(String[] args){
		Solution s = new Solution();
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(s.leastInterval(tasks, 2));
	}
}
