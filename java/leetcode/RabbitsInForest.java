//Leetcode problem 781 Rabbits in Forest
//Solution written by Xuqiang Fang on 14 May, 2018
import java.util.HashMap;
import java.util.Map;
class Solution{
    public int numRabbits(int[] answers) {
        if(answers.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>(); 
        int sum = 0;
        for(int i : answers){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i : map.keySet()){
            int num = map.get(i);
            if(num % (i+1) == 0)
                sum += num;
            else
                sum += num / (i+1) * (i+1) + i + 1;
        }
        return sum;
    }
}

public class RabbitsInForest{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] answers = {1,1,2};
        int[] answers2 = {10,10,10};
        int[] answers3 = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        System.out.println(s.numRabbits(answers));
        System.out.println(s.numRabbits(answers2));
	}
}
