//Leetcode problem 506 Relative Ranks
//Solution written by Xuqiang Fang on 26 April, 2018 
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
class Node{
    int index;
    int score;
    Node(int i, int s){
        index = i;
        score = s;
    }
}

class Solution{
    public String[] findRelativeRanks(int[] nums){
        int N = nums.length;
        Node[] original = new Node[N];
        for(int i=0; i<N; ++i){
            original[i] = new Node(i, nums[i]);
        }

        Arrays.sort(original, new score());
        String[] ret = new String[N];
        if(N >= 1){
            ret[original[0].index] = "Gold";
        }
        if(N >= 2){
            ret[original[1].index] = "Silver";
        }
        if(N >= 3){
            ret[original[2].index] = "Bronze";
        }
        for(int i=3; i<N; ++i){
            ret[original[i].index] = String.valueOf(original[i].index+1);
        }
        return ret;
    }	

    
}
class index implements Comparator<Node>{
    @Override
    public int compare(Node a, Node b){
        return a.index - b.index;
    }
}
class score implements Comparator<Node>{
    @Override
    public int compare(Node a, Node b){
        return b.score - a.score; 
    }
}

public class RelativeRanks{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {4,2,1,3,5};
        String[] result = s.findRelativeRanks(nums);
        for(String st : result){
            System.out.println(st);
        }
	}
}
