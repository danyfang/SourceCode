//Leetcode Problem No 151 Reverse Words in a String 
//Solution written by Xuqiang Fang on 23 Oct, 2018

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
    void reverseWords(string &t) {
        vector<string> ans;
        const int n = t.length();
        int l = 0, r = 0;
        while(l < n && r < n){
            if(t[l] == ' '){
                l++;
                r++;
            }
            else{
                while(r < n && t[r] != ' '){
                    r++;
                }
                ans.push_back(t.substr(l, r-l));
                l = r;
            }
        }
        int m = ans.size();
        t.clear();
        for(int j=m-1; j>=0; --j){
            for(auto c : ans[j]){
                t.push_back(c);
            } 
            t.push_back(' ');
        }
        if(t.size() > 0 && t[t.size()-1] == ' '){
            t.pop_back();
        }
    }
};

int main(){
    Solution s;
    string t = "the sky is blue";    
    s.reverseWords(t);
    cout << "aaa" << t << "bbb" << endl;
    t = "";
    s.reverseWords(t);
    cout << "aaa" << t << "bbb" << endl;
    t = "   a   b ";
    s.reverseWords(t);
    cout << "aaa" << t << "bbb" << endl;
    t = " 1";
    s.reverseWords(t);
    cout << "aaa" << t << "bbb" << endl;
    t = "";
    s.reverseWords(t);
    cout << "aaa" << t << "bbb" << endl;
    return 0;
}
