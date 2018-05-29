//Leetcode Problem No 837 New 21 Game
//Solution written by Xuqiang Fang on 29 May, 2018 

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
    double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W){
            return 1.0;
        }    
        vector<double> p(N+1, 0.0);
        p[0] = 1.0;
        double s = 1.0;
        double ans = 0.0;
        for(int i=1; i<=N; ++i){
            p[i] = s / W;
            if(i < K){
                s += p[i];
            }
            else{
                ans += p[i];
            }
            if(i >= W){
                s -= p[i-W];
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    cout << s.new21Game(10,1,10) << endl;
    cout << s.new21Game(6,1,10) << endl;
    cout << s.new21Game(21,17,10) << endl;
    return 0;
}
