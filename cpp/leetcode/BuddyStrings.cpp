//Leetcode Problem No 859 Buddy Strings
//Solution written by Xuqiang Fang on 24 June, 2018

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
    bool buddyStrings(string A, string B){
        if(A.length() != B.length()){
            return false;
        }
        int c = 0;
        vector<int> countA(26, 0);
        vector<int> countB(26, 0);
        for(int i=0; i<A.length(); ++i){
            if(A[i] != B[i]){
                c++;
            }
            countA[A[i]-'a']++;
            countB[B[i]-'a']++;
        }
        bool flag = false;
        for(int i=0; i<26; ++i){
            if(countA[i] != countB[i]){
                return false;
            }
            if(countA[i] >= 2 && !flag){
                flag = true;
            }
        }
        if(c == 2){
            return true;
        }
        else if(c == 0){
            return flag;
        }
        return false;
    }
};

int main(){
    Solution s;
    cout << s.buddyStrings("ab", "ba") << endl;
    cout << s.buddyStrings("ab", "ca") << endl;
    cout << s.buddyStrings("aaaabc", "aaaacb") << endl;
    return 0;
}
