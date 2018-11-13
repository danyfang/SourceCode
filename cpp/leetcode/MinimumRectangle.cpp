//Leetcode Problem No 939 Minimum Area Rectangle
//Solution written by Xuqiang Fang on 12 Nov, 2018

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
    int minAreaRect(vector<vector<int>>& points) {
        for(auto&p : points){
            m[p[0]].insert(p[1]);
        }
        int ans = INT_MAX;
        const int n = points.size();
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                auto& a = points[i];
                auto& b = points[j];
                if(a[0]!= b[0] && a[1]!=b[1]){
                    if(m[a[0]].count(b[1]) != 0 && m[b[0]].count(a[1])!= 0){
                        ans = min(ans, abs((a[0]-b[0])*(a[1]-b[1])));
                        //cout << a[0] <<"," << a[1] << "), (" << b[0] << "," << b[1] << endl;
                        //cout <<  abs((a[0]-b[0])*(a[1]-b[1])) << endl;
                    }
                }
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
private:
    unordered_map<int, unordered_set<int>> m;
};

int main(){
    Solution s;
    vector<vector<int>> points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
    cout << s.minAreaRect(points) << endl;
    return 0;
}
