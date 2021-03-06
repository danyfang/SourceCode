//Leetcode problem 322 Coin Change
//Leetcode problem 518 Coin Change II
//Solution written by Xuqiang Fang on  18 April, 2018
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Solution{
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        int min = amount;
        for(int i : coins){
            min = Math.min(i, min);
        }
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            if(i < min){
                dp[i] = -1;
                continue;
            }
            for(int j=0; j<coins.length; j++){
                if(i - coins[j] >= 0 ){
                    if(i % coins[j] == 0){
                        dp[i] = Math.min(i/coins[j],dp[i]);
                    }
                    if(dp[i-coins[j]] != -1)
                        dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
                }
            } 
            if(dp[i] == amount+1)
                dp[i] = -1;

        }

        return dp[amount];
    }	
    

    //No 518
    /*
    * this questions is essentially the same with Combination Sum, can use the same element
    */
    //can use the same element unlimited times, this version can print the combinations,
    //but this solution will certainly cause TLE, see dynamic programming solution
	public int change_(int target, int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
        System.out.println(list);
		return list.size();
	}

	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int remain, int start){
		if(remain < 0){
			return;
		}else if(remain == 0){
			list.add(new ArrayList<>(templist));
		}else{
			for(int i=start; i<nums.length; i++){
				templist.add(nums[i]);
				backtrack(list,templist, nums, remain-nums[i], i);
				templist.remove(templist.size()-1);
			}
		}
	}
    

    /*Problem No 518*/
    //this solution will certainly TLE, see dynamic programming solution
    public int change__(int t, int[] nums){
        //specific to this problem
        if(t == 0){
            return 0;
        }
        Arrays.sort(nums);
        return dfs(nums, t, 0);
    }
    private int dfs(int[] nums, int t, int start){
        int sum = 0;
        if(t < 0){
            return 0;
        }
        else if(t == 0){
            return 1;
        }
        else{
            for(int i=start; i<nums.length; ++i){
                sum += dfs(nums, t-nums[i], i);
            }
        }
        return sum;
    }
    
    //dynamic programming solution , No 518 Coin change 2
    public int change(int t, int[] nums){
        int[] dp = new int[t+1];
        dp[0] = 1;
        for(int n : nums){
            for(int i=n; i<=t; ++i){
                dp[i] += dp[i-n];
            }
        }
        return dp[t];
    }

}

public class CoinChange{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] coins = {186,419,83,408};
        //System.out.println(s.coinChange(coins, Integer.valueOf(args[0])));
        coins = new int[]{1,2,5};
        System.out.println(s.change(5, coins));
        coins = new int[]{2};
        System.out.println(s.change(3, coins));
	}
}
