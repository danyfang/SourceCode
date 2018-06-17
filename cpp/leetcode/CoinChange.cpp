//Leetcode Problem No 518 Coin Change 2
//Solution written by Xuqiang Fang on 17 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution{
public:
    int change(int amount, vector<int>& coins) {
        if(amount == 0){
            return 0;
        }
        vector<int> mem(amount+1, 0);    
        sort(coins.begin(), coins.end());
        int res = dfs(coins, mem, amount, 0);
        /*
        for(int i : mem){
            cout << i << " ";
        }
        cout << endl;
        */
        return res;
    }
private:
    int dfs(vector<int>& coins, vector<int>& mem, int a, int s){
        int sum = 0;
        if(a < 0){
            return 0;
        }
        else if(a == 0){
            return 1;
        }
        for(int i=s; i<coins.size(); ++i){
            sum += dfs(coins, mem, a-coins[i], i);
        }
        mem[a] = sum;
        return sum;
    }
};

int main(){
    Solution s;
    vector<int> coins{1,2,5};
    cout << s.change(5, coins) << endl;
    return 0;
}
