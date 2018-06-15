//Leetcode Problem No 87 Scramble String
//Solution written by Xuqiang Fang on 15 June, 2018

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
    bool isScramble(string s1, string s2){
        if(s1 == s2){
            return true;
        }
        const int n = s1.length();
        int count[26] = {0};
        for(int i=0; i<n; ++i){
            count[s1[i]-'a']++;
            count[s2[i]-'a']--;
        }
        for(int i=0; i<26; ++i){
            if(count[i] != 0){
                return false;
            }
        }
        for(int i=1; i<n; ++i){
            if((isScramble(s1.substr(0,i), s2.substr(0,i)) && isScramble(s1.substr(i), s2.substr(i)))
                || (isScramble(s1.substr(0,i), s2.substr(n-i)) && isScramble(s1.substr(i), s2.substr(0, n-i)))){
                return true;    
            } 
        }
        return false;
    }
};

int main(){
    Solution s;
    string s1 = "great";
    string s2 = "rgeat";
    string s3 = "rtgea";
    cout << s.isScramble(s1, s2) << endl;
    cout << s.isScramble(s3, s2) << endl;
    cout << s.isScramble(s1, s3) << endl;
    return 0;
}
