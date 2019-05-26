//Leetcode Problem No 1052. Grumpy Bookstore Owner
//Solution written by Xuqiang Fang on 26 May, 2019

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
    int maxSatisfied(vector<int>& cus, vector<int>& g, int X) {
        int ans = 0;
        const int n = cus.size();
        vector<int> extra(n-X+1, 0);
        for(int i=0; i<n; ++i){
            if(g[i] == 0){
                ans += cus[i];
            }
            if(i < X && g[i] == 1){
                extra[0] += cus[i];
            }
        }
        auto m = extra[0];
        for(int i=X; i<n; ++i){
            if(g[i] == 1 ){
                if(g[i-X] == 0){
                    extra[i-X+1] = extra[i-X]+cus[i];
                }
                else{
                    extra[i-X+1] = cus[i]+extra[i-X]-cus[i-X];
                }
            }
            else{
                if(g[i-X] == 0){
                    extra[i-X+1] = extra[i-X];
                }
                else{
                    extra[i-X+1] = extra[i-X]-cus[i-X];
                }
            }
            m = max(m, extra[i-X+1]);
        }
        return ans + m;
    }
};

int main(){
  Solution s;
  vector<int> customers{1,0,1,2,1,1,7,5}, grumpy{0,1,0,1,0,1,0,1};
  cout << s.maxSatisfied(customers, grumpy, 3) << endl;
  return 0;
}
