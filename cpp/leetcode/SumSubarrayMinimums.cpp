//Leetcode Problem No 907 Sum of Subarray Minimums
//Solution written by Xuqiang Fang on 19 Oct, 2018

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
    int sumSubarrayMins(vector<int>& A) {
        int res = 0, n = A.size(), mod = 1e9 + 7;
        vector<int> left(n), right(n);
        /*
        left[i] is the # of subarrays on the left of A[i] that has A[i] as minimum, strictly bigger
        right[i] is the # of subarrays on the right of A[i] that has A[i] as minimum, bigger 
        */
        stack<pair<int, int>> s1,s2;
        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.empty() && s1.top().first > A[i]) {
                count += s1.top().second;
                s1.pop();
            }
            s1.push({A[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.empty() && s2.top().first >= A[i]) {
                count += s2.top().second;
                s2.pop();
            }
            s2.push({A[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i){
            res = (res + A[i] * left[i] * right[i]) % mod;
        }
        return res;
    }
};

int main(){
    Solution s;
    vector<int> A{3,1,2,4};
    cout << s.sumSubarrayMins(A) << endl;
    A = {81,55,2};
    cout << s.sumSubarrayMins(A) << endl;
    A = {48,87,27};
    cout << s.sumSubarrayMins(A) << endl;
    return 0;
}
