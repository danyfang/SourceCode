//Leetcode Problem No 915 Partition Array into Disjoint Intervals
//Solution written by Xuqiang Fang on 30 Sep, 2018

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
    int partitionDisjoint(vector<int>& A) {
        const int n = A.size();
        vector<int> min_so_far(n, A[n-1]);
        for(int i=n-2; i>=0; --i){
            min_so_far[i] = min(min_so_far[i+1], A[i]);
        }
        vector<int> max_so_far(n, A[0]);
        for(int i=1; i<n; ++i){
            max_so_far[i] = max(max_so_far[i-1], A[i]);
        }
        int ans = n-1;
        for(int i=0; i<n-1; ++i){
            if(max_so_far[i] <= min_so_far[i+1]){
                ans = i+1;
                break;
            }
        }
        return ans;
    }
};
int main(){
    Solution s;

    return 0;
}
