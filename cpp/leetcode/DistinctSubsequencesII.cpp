//Leetcode Problem No 940 Distinct Subsequences II
//Solution written by Xuqiang Fang on 12 Nov, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <numeric>

using namespace std;
class Solution{
public:
    int distinctSubseqII(string S) {
        const int mod = 1e9+7;
        long count[26] = {};
        for(char c : S){
            count[c-'a'] = accumulate(begin(count), end(count), 1L) % mod; 
        }
        return accumulate(begin(count), end(count), 0L) % mod;
    }
};

int main(){
    Solution s;
    string S = "abc";
    cout << s.distinctSubseqII(S) << endl;
    S = "aba";
    cout << s.distinctSubseqII(S) << endl;
    S = "aaa";
    cout << s.distinctSubseqII(S) << endl;
    return 0;
}
