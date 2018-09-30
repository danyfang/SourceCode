//Leetcode Problem No 916 Word Subsets
//Solution written by Xuqiang Fang on 30 Sep, 2018

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
    vector<string> wordSubsets(vector<string>& A, vector<string>& B) {
        vector<string> ans;
        int check[26] = {0};
        for(auto& b : B){
            int alpha[26] = {0};
            for(int i=0; i<b.size(); ++i){
                alpha[b[i]-'a'] += 1;
            }
            for(int i=0; i<26; ++i){
                check[i] = max(check[i], alpha[i]);
            }
        }
        /*
        for(int i=0; i<26; ++i){
            cout << check[i] << " ";
        }
        cout << endl;
        */
        for(auto& a : A){
            int alpha[26] = {0};
            for(int i=0; i<a.size(); ++i){
                alpha[a[i]-'a'] += 1;
            }
            bool flag = false;
            for(int i=0; i<26; ++i){
                if(alpha[i] < check[i]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans.push_back(a);
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<string> A{"amazon","apple","facebook","google","leetcode"};
    vector<string> B{"ec","oc","ceo"};
    vector<string> ans = s.wordSubsets(A, B);
    for(auto& s : ans){
        cout << s << endl;
    }
    return 0;
}
