//Leetcode Problem No 301 Remove Invalid Parentheses
//Solution written by Xuqiang Fang on 5 July, 2018

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
    vector<string> removeInvalidParentheses(string s) {
        int l = 0;
        int r = 0;
        for (const char c : s){
            l += (c == '(');
            if(l == 0){
                r += (c == ')');
            }
            else{
                l -= (c == ')');
            }
        }
        vector<string> ans;
        dfs(s, 0, l, r, ans);
        return ans;
    }
private:
    bool isValid(const string& s){
        int count = 0;
        for(const char c : s){
            if(c == '('){
                ++count;
            }
            if(c == ')'){
                --count;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
    void dfs(const string& s, int start, int l, int r, vector<string>& ans){
        if(l == 0 && r == 0){
            if(isValid(s)){
                ans.push_back(s);
            }
            return;
        }
        for(int i=start; i<s.length(); ++i){
            if(i != start && s[i] == s[i-1]){
                continue;
            }
            if(s[i] == '(' || s[i] == ')'){
                string curr = s;
                curr.erase(i, 1);
                if(r > 0){
                    dfs(curr, i, l, r-1, ans);
                }
                else if(l > 0){
                    dfs(curr, i, l-1, r, ans);
                }
            }
        }
    }
};

int main(){
    Solution s;
    vector<string> ans;
    string s1 = "()())()";
    ans = s.removeInvalidParentheses(s1);
    for(auto& t : ans){
        cout << t << endl;
    }
    return 0;
}
