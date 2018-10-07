'''
There are n types of coins, with [v1, ... vn] as their values, given a non-negative value S
return the min and max number of coins to make up the amount S
1 <= n <= 100, 1<=S<=10000, 1<=vi<=S

written by Xuqiang Fang on 22 June, 2018
'''

class CoinChange:
    def change(self, S, coins):
        dp_min = [-1 for x in range(S+1)]
        dp_min[0] = 0
        min_change = self.dfs_min(S, coins, dp_min)

        dp_max = [-1 for x in range(S+1)]
        dp_max[0] = 0
        visited = [0 for x in range(S+1)]
        visited[0] = 1
        max_change = self.dfs_max(S, coins, dp_max, visited)
        
        print('min number of coins is %d' %min_change)
        print('max number of coins is %d' %max_change)

        ###print the path
        self.print_path(dp_min, coins, S)
        self.print_path(dp_max, coins, S)
        return

    ##solution 1 dfs with memorization
    def dfs_min(self, S, coins, dp):
        #print('S = %d, dp[S] = %d' %(S, dp[S]))
        if dp[S] != -1:
            return dp[S]
        dp[S] = 1 << 30
        for i in range(len(coins)):
            if coins[i] <= S:
                tmp = self.dfs_min(S-coins[i], coins, dp) + 1
                dp[S] = min(dp[S], tmp)
        return dp[S] 
    def dfs_max(self, S, coins, dp, visited):
        if visited[S]:
            return dp[S]
        dp[S] = -1 << 30
        visited[S] = 1
        for i in range(len(coins)):
            if coins[i] <= S:
                tmp = self.dfs_max(S-coins[i], coins, dp, visited)+1
                dp[S] = max(dp[S], tmp)
        return dp[S]

    def print_path(self, dp, coins, S):
        ### print the path, i.e. the combinations
        for i in range(len(coins)):
            if coins[i] <= S and dp[S-coins[i]]+1 == dp[S]:
                print('use the coin %d'%coins[i])
                self.print_path(dp, coins, S-coins[i])
                break
        return

def main():
    s = CoinChange()
    coins = [1,2,3]
    s.change(6, coins)

    coins = [2,3,4,5,10,50]
    s.change(58, coins)
main()
