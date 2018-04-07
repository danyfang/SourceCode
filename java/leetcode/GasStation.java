//Leetcode problem 134 Gas Station
//Solution written by Xuqiang Fang on 6 April, 2018 

class Solution{
    public int canCompleteCircuit(int[] gas, int[] cost){
        int n = gas.length;
        int start = 0;
        int sum = 0;
        int total = 0;
        for(int i=0; i<n; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0){
                start = i+1;
                sum = 0;
            }
        }
        if(total >= 0)
            return start;
        else
            return -1;
    }	
}

public class GasStation{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(s.canCompleteCircuit(gas, cost));
	}
}
