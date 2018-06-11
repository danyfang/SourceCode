//Leetcode Problem No 849 Maximize Distance to Closest Person
//Solution written by Xuqiang Fang on 10 June, 2018

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
    int maxDistToClosest(vector<int>& s) {
        const int n = s.size();
        int m = 1;
        int l = 0, r = 0;
        for(int i=1; i<n; ++i){
            if(s[i] == 1){
                r = i;
                if(s[0] == 0 && l == 0){
                    m = max(m, 2*(r-l));
                }
                else{
                    m = max(m, r-l);
                }
                l = r;
            }
            else if(i == n-1){
                m = max(m, 2*(n-1-l));
            }
        }
        return m/2;
    }
};

int main(){
    Solution s;
    vector<int> seats{1,0,0,0,1,0,1};
    vector<int> seat{1,0,0,0};
    vector<int> sea{1,0};
    vector<int> se{0,0,0,0,0,1};
    cout << s.maxDistToClosest(seats) << endl;
    cout << s.maxDistToClosest(seat) << endl;
    cout << s.maxDistToClosest(sea) << endl;
    cout << s.maxDistToClosest(se) << endl;
    return 0;
}
