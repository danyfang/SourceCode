//Leetcode Problem No 848 Shifting Letters
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
    string shiftingLetters(string S, vector<int>& shifts) {
        const int n = shifts.size();
        vector<long> s(n, 0);    
        s[n-1] = shifts[n-1];
        for(int i=n-2; i>=0; --i){
            s[i] = s[i+1] + shifts[i];
        }
        for(int i=0; i<n; ++i){
            S[i] = (char)((S[i]-'a'+(s[i]%26))%26+'a');
        }
        return S;
    }
};

int main(){
    Solution s;
    string S{"abc"};
    vector<int> shifts{3,5,9};
    cout << s.shiftingLetters(S, shifts) << endl;
    return 0;
}
