//Leetcode Problem No 856 Score of Parentheses
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
    int scoreOfParentheses(string S) {
        int p = 0;     
        int t = 0;
        vector<string> ans;
        for(int i=0; i<S.length(); ++i){
            if(S[i] == '('){
                t++;
            }
            else{
                t--;
            }
            if(t == 0){
                ans.push_back(move(S.substr(p, i-p+1)));
                p = i+1;
            }
        }
        return helper(ans);
    }
private:
    int helper(vector<string>& l){
        int ans = 0;
        for(auto& s : l){
            if(s == "()"){
                ans += 1;
            }
            else{
                ans += 2 * scoreOfParentheses(s.substr(1, s.length()-2));
            }
        }
        return ans;
    } 
};

int main(){
    Solution s;
    cout << s.scoreOfParentheses("()") << endl;
    cout << s.scoreOfParentheses("(())") << endl;
    cout << s.scoreOfParentheses("()()") << endl;
    cout << s.scoreOfParentheses("(()(()))") << endl;
    return 0;
}
