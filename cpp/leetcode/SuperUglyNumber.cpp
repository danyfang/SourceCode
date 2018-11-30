//Leetcode Problem No 313 Super Ugly Number
//Solution written by Xuqiang Fang on 14 Nov, 2018

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
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        /*
            the final output must be in the format of
            a^x0b^x1c^x2...
            each element comes after ugly[i] must be a multiple of ugly[i]

            that is for i < j, ugly[j] = ugly[i] * a^x0b^x1c^x2...
        */
        const int m = primes.size();
        vector<int> num(m, 0);       
        vector<int> ans(n, 0);
        ans[0] = 1;
        for(int i=1; i<n; ++i){
            int tmp = ans[num[0]] * primes[0];
            for(int j=0; j<m; ++j){
                if(ans[num[j]] * primes[j] < tmp) 
                    tmp = ans[num[j]] * primes[j];
            } 
            ans[i] = tmp;
            for(int j=0; j<m; ++j){
                if(ans[num[j]]*primes[j] == tmp)
                    num[j]++;
            }
        }
        for(auto& x : num)
            cout << x << "\t";
        cout << endl;
        return ans[n-1];
    }
};
int main(){
    Solution s;
    vector<int> primes{2,7,13,19};
    cout << s.nthSuperUglyNumber(12, primes) << endl;
    return 0;
}
