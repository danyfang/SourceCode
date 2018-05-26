//Leetcode Problem No. 14 Longest Common Prefix
//Solution written by Xuqiang Fang on 25 May, 2018

#include <iostream>
#include <vector>
#include <string>

using namespace std;
class Solution{
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() == 0){
            return "";
        }            
        string res = strs[0];
        for(int i=1; i<strs.size(); ++i){
            res = common(res, strs[i]);
        }
        return res;
    }
private:
    string common(string a, string b){
        int len = min(a.length(), b.length());
        for(int i=0; i<len; ++i){
            if(a[i] != b[i]){
                return a.substr(0,i);
            }
        }
        return a.length() <= b.length() ? a : b;
    }
};

int main(){
    Solution s;
    vector<string> strs{"flower","flow","flight"};
    vector<string> str{"dog","racecar","car"};
    cout << s.longestCommonPrefix(strs) << endl;
    cout << s.longestCommonPrefix(str) << endl;
    return 0;
}
