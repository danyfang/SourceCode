//Leetcode Problem No 853 Car Fleet
//Solution written by Xuqiang Fang on 18 June, 2018

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
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        const int n = position.size();
        if(n == 0){
            return 0;
        }
        vector<pair<int, int>> time(n);
        for(int i=0; i<n; ++i){
            time[i].first = target - position[i];
            time[i].second = speed[i];
        }
        sort(time.begin(), time.end());
        int ans = 1;
        double prev = (double)time[0].first / (double)time[0].second;
        for(int i=1; i<n; ++i){
            double t = (double)time[i].first / (double)time[i].second;
            if(t > prev){
                prev = t;
                ans++;
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> position{10,8,0,5,3};
    vector<int> speed{2,4,1,1,3};
    cout << s.carFleet(12, position, speed) << endl;
    return 0;
}
