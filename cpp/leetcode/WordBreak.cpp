//Leetcode Problem No. 139 Word Break
//Solution written by Xuqiang Fang on 23 May, 2018 

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>

using namespace std;

class Solution{
public:
    bool wordBreak_(string s, vector<string>& wordDict) {
        unordered_set<string> dict{wordDict.begin(), wordDict.end()};
        bool dp[s.length()+1]; 
        dp[0] = true;
        for(int i=0; i<=s.length(); ++i){
            dp[i] = false;
        }
        for(int i=1; i<=s.length(); ++i){
            if(!dp[i] && dict.count(s.substr(0,i))){
                dp[i] = true;
            } 
            if(dp[i]){
                if(i == s.length()){
                    return true;
                }
                for(int j=i+1; j<=s.length(); ++j){
                    if(!dp[j] && dict.count(s.substr(i,j-i))){
                        dp[j] = true; 
                    }
                    if(dp[j] && j == s.length()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    bool wordBreak__(string s, vector<string> &wordDict){
        unordered_set<string> dict{wordDict.begin(), wordDict.end()};
        int n = s.length();
        s = " " + s;
        vector<int> f(n+1, 0);
        f[0] = 1;
        
        for(int i=1; i<=n; ++i){
            for(int j=0; j<i; ++j){
                if(f[j] == 1){
                    if(dict.count(s.substr(j+1, i-j))){
                        f[i] = 1;
                        break;
                    }
                }
            }
        }
        return f[n];
    }

    
    //for word break II
    vector<string> wordBreak(string s, vector<string>& wordDict){
        unordered_set<string> dict(wordDict.cbegin(), wordDict.cend());
        return wordBreak(s, dict);
    } 

private:
    vector<string> append(const vector<string>& prefixes, const string& word){
        vector<string> results;
        for(const auto& prefix : prefixes){
            results.push_back(prefix + " " + word);
        }
        return results;
    }
    //the key part of this solution to word break II
    /**
    *recursive break the left part, for every possible result of the left part, append the right and
    *form the final result
    *at the same time, use a map to store itermediate results to avoid re-breaking
    */
    const vector<string>& wordBreak(string s, unordered_set<string>& dict){
        if(mem_.count(s)){
            return mem_[s];
        }

        vector<string> ans;

        if(dict.count(s)){
            ans.push_back(s);
        }

        for(int j=1; j<s.length(); ++j){
            const string& right = s.substr(j);
            if(!dict.count(right)){
                continue;
            }

            const string& left = s.substr(0,j);
            const vector<string> left_ans = append(wordBreak(left, dict), right);

            ans.insert(ans.end(), left_ans.begin(), left_ans.end());
        }

        mem_[s].swap(ans);
        return mem_[s];
    }

    unordered_map<string, vector<string>> mem_;
};

int main(){
    Solution s;
    string S("applepenappleaaaaaaaaa");
    vector<string> wordDict{"apple", "pen", "a"};
    cout << wordDict.size() << endl;
    //cout << s.wordBreak(S, wordDict) << endl;
    vector<string> ans = s.wordBreak(S, wordDict);
    for(auto& a : ans){
        cout << a << endl;
    }
    return 0;
}
