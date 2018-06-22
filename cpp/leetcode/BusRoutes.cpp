//Leetcode Problem No 815 Bus Routes
//Solution written by Xuqiang Fang on 21 June, 2018

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
    int numBusesToDestination(vector<vector<int>>& routes, int S, int T) {
        if(S == T){
            return 0;
        }
        const int n = routes.size();
        unordered_map<int, vector<int>> m;
        for(int i=0; i<n; ++i){
            for(const int s : routes[i]){
                m[s].push_back(i);
            }
        }
        vector<int> ride(n, 0);
        queue<int> q;
        q.push(S);
        int buses = 0;
        while(!q.empty()){
            ++buses;
            for(int i=q.size(); i>0; --i){
                int s = q.front();
                q.pop();
                for(const int b : m[s]){
                    if(ride[b]){
                        continue;
                    }
                    ride[b] = 1;
                    for(int t : routes[b]){
                        if(t == T){
                            return buses;
                        }
                        q.push(t);
                    }
                }
            }
        }
        return -1;
    }
};

int main(){
    Solution s;
    vector<vector<int>> routes{{1, 2, 7}, {3, 6, 7}};
    cout << s.numBusesToDestination(routes, 1, 6) << endl;
    return 0;
}
