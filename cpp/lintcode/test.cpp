//Leetcode Problem No 
//Solution written by Xuqiang Fang on 

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution {
public:
    /**
     * @param cost: the cost
     * @param val: the val
     * @return: the all cost
     */
    long long doingHomework(vector<int> &cost, vector<int> &val) {
        // Write your code here.
        const int n = cost.size();
        if(n == 0)
            return 0;
        vector<int> s(n, 0);
        cout << "hello\n";
        sort(cost.begin(), cost.end());
        s[0] = cost[0];
        for(int i=1; i<n; ++i){
            s[i] = s[i-1] + cost[i];
        }
        
        int ans = 0;
        for(auto& v : val){
            int l = 0, r = n;
            while(l < r){
                auto m = (l+r)/2;
                if(s[m] == v){
                    ans += v;
                }
                else if(s[m] > v){
                    r = m;
                }
                else{
                    l = m+1;
                }
                if(l == r-1)
                  break;
                cout << "v" << endl;
            }
            if(l > 0){
                ans += s[l-1];
            }
        }
        
        return ans;
    }
};


int main(){
  Solution s;
  vector<int> cost{1,2,3,5}, val{6,10,4};
  cout << s.doingHomework(cost, val) << endl;
  return 0;
}
