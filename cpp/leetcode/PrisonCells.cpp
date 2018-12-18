//Leetcode Problem No 957 Prison Cells After N Days
//Solution written by Xuqiang Fang on 17 Dec, 2018

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
    vector<int> prisonAfterNDays(vector<int>& cells, int N) {
        unordered_map<int, int> m;
        int i = encode(cells);
        int j = 0;
        auto ncell = cells;
        cout << encode(ncell) << endl;
        while(m.count(i) == 0 && j < N){
            m[i] = j++;
            ncell = helper(ncell);
            i = encode(ncell);
            /*
            cout << "original = " << i << endl;
            auto tmp = decode(i);
            cout << "encode = " << encode(tmp) << endl;
            */
        }
        N = N % (j-m[i]);
        N += (j-m[i]);
        ncell = cells;
        for(int x=0; x<N; ++x){
            ncell = helper(ncell);
        }
        return ncell;
    }
private:
    vector<int> helper(vector<int>& cells){
        vector<int> ans(8, 0); 
        for(int i=1; i<7; ++i){
            if(cells[i-1] == cells[i+1]){
                ans[i] = 1;
            }
        }
        return ans;
    }
    int encode(vector<int>& cells){
        int ans = 0;
        for(int i=0; i<8; ++i){
            ans += p[i] * cells[i];
        }
        return ans;
    }
    vector<int> decode(int a){
        vector<int> ans(8,0);
        for(int i=7; i>=0; --i){
            ans[i] = a/p[i];
            a = a % p[i];
        }
        return ans;
    }
    int p[8] = {1,2,4,8,16,32,64,128};
};
int main(){
    Solution s;
    vector<int> cells{0,1,0,1,1,0,0,1};
    auto ans = s.prisonAfterNDays(cells, 7);
    /*
    for(auto a : ans){
        cout << a << ", ";
    }
    cout << endl;
    cells = {1,0,0,1,0,0,1,0};
    ans = s.prisonAfterNDays(cells, 1000000000);
    for(auto a : ans){
        cout << a << ", ";
    }
    cout << endl;
    cells = {1, 1, 0, 1, 1, 0, 1, 1};
    ans = s.prisonAfterNDays(cells, 6);
    for(auto a : ans){
        cout << a << ", ";
    }
    //[0,0,1,0,0,1,0,0]
    cout << endl;
    */
    cells = {1, 0, 0, 1, 0, 0, 0, 1};
    ans = s.prisonAfterNDays(cells, 826);
    for(auto a : ans){
        cout << a << ", ";
    }
    cout << endl;
    return 0;
}
