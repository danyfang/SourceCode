//Leetcode Problem No 841 Keys and Rooms
//Solution written by Xuqiang Fang on 28 May, 2018

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
    bool canVisitAllRooms(vector<vector<int>>& r) {
        int n = r.size();
        vector<int> v(n, 0);
        v[0] = 1;
        dfs(r, v, 0);
        for(auto i : v){
            if(i == 0){
                return false;
            }
        }
        return true;
    }
private:
    void dfs(vector<vector<int>>&r, vector<int> &v, int i){
        for(auto j : r[i]){
            if(v[j] == 1){
                continue;
            }
            v[j] = 1;
            dfs(r, v, j);
        }
    }
};

int main(){
    Solution s;
    vector<vector<int>> r{{1,3},{3,0,1},{2},{0}};
    cout << s.canVisitAllRooms(r) << endl;
    return 0;
}
