//Leetcode Problem No 945 minimum Increment to Make Array Unique
//Solution written by Xuqiang Fang on 29 Nov, 2018

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
    int minIncrementForUnique(vector<int>& A) {
        if(A.size() == 0){
            return 0;
        }
        sort(A.begin(), A.end());
        int curr_max = A[0];
        int ans = 0;
        for(auto& a : A){
            if(a <= curr_max){
                ans += curr_max - a;
                curr_max++;
            }
            else{
                curr_max = a + 1;
            }
        }
        return ans;
    }
};
int main(){
    Solution s;
    vector<int> A{3,2,1,2,1,7};
    cout << s.minIncrementForUnique(A) << endl;
    return 0;
}
