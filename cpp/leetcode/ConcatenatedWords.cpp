//Leetcode Problem No. 472 Concatenated Words
//Solution written by Xuqiang Fang on 24 May, 2018

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <algorithm>

using namespace std;

class Solution{
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        sort(words.begin(), words.end(), com);
        /** debug
        for(auto s : words){
            cout << s << endl;
        }
        */
        vector<string> ans;
        unordered_set<string> dict;
        for(int i=0; i<words.size(); ++i){
            if(can(words[i], dict)){
                ans.push_back(words[i]);
            }
            dict.insert(words[i]);
        }
        return ans;
    }
private:
    /*
    bool compare(const string &a, const string &b){
        return (a.size() < b.size());
    }
    */
    struct compare {
        bool operator()(const std::string& first, const std::string& second) {
            return first.size() < second.size();
        }
    } com;
    int can(string s, unordered_set<string> &d){
        if(d.empty()){
            return 0; 
        }
        int l = s.length();
        vector<int> dp(l+1, 0);
        dp[0] = 1;
        s = " " + s;
        for(int i=1; i<=l; ++i){
            for(int j=0; j<i; ++j){
                if(dp[j] == 1 && d.count(s.substr(j+1, i-j))){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[l];
    }
};

int main(){
    Solution s;
    vector<string> words{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    vector<string> ans = s.findAllConcatenatedWordsInADict(words);
    for(auto s : ans){
        cout << s << endl;
    }
    return 0;
}
