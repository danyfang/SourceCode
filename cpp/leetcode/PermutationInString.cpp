//Leetcode Problem No 567 Permutation in String
//Solution written by Xuqiang Fang on 24 Oct, 2018

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
    bool checkInclusion(string s1, string s2) {
        const int n = s1.length();    
        const int m = s2.length();
        int a[26] = {0};
        int b[26] = {0};
        for(int i=0; i<n; ++i){
            a[s1[i]-'a']++;
            b[s2[i]-'a']++;
        }
        if(compare(a,b)) return true;
        for(int i=n; i<m; ++i){
            b[s2[i-n]-'a']--; 
            b[s2[i]-'a']++;
            if(compare(a,b)) return true;
        }
        return false;
    }
private:
    bool compare(int* a, int* b){
        for(int i=0; i<26; ++i){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
};

int main(){
    Solution s;
    string s1 = "ab";
    string s2 = "eidbaooo";
    cout << s.checkInclusion(s1, s2) << endl;
    s2 = "eidboaoo";
    cout << s.checkInclusion(s1, s2) << endl;
    return 0;
}
