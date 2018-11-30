//Leetcode Problem No 318 Maximum Product of Word Lengths
//Solution written by Xuqiang Fang on 14 Nov, 2018

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
    int maxProduct(vector<string>& words){
        const int n = words.size();
        vector<int> length;
        for(auto& w : words){
            int c[26] = {};
            for(auto x: w){
                c[x-'a'] = 1;
            }
            string tmp = "";
            for(auto x : c){
                tmp += to_string(x);
            }
            length.push_back(stoi(tmp, nullptr, 2));
        }
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                if((length[i] & length[j])== 0){
                    int tmp = words[i].length()* words[j].length();
                    ans = max(ans, tmp);
                }
            }
        }
        return ans;
    }
    int maxProduct_(vector<string>& words){
        const int n = words.size();
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                if(!common(words[i], words[j])){
                    int tmp = words[i].length()* words[j].length();
                    ans = max(ans, tmp);
                }
            }
        }
        return ans;
    }
private:
    bool common(string& a, string& b){
        int c[26] = {0};
        for(auto x : a){
            c[x-'a']++;
        }
        for(auto x : b){
            if(c[x-'a'] > 0)
                return true;
        }
        return false;
    }
};

int main(){
    Solution s;
    vector<string> words = {"abcw","baz","foo","bar","xtfn","abcdef"};
    cout << s.maxProduct(words) << endl;
    return 0;
}
