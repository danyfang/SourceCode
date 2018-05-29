//Leetcode Problem No  522 Longest Uncommon Subsequence II
//Solution written by Xuqiang Fang on 28 May, 2018

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
    int findLUSlength(vector<string>& strs) {
        vector<unordered_map<string, int>> m(11, unordered_map<string, int>());    
        for(auto s : strs){
            if(m[s.length()].count(s) == 0){
                m[s.length()].insert({s, 1});
            }
            else{
                m[s.length()][s] += 1;
            }
        }
        for(int i=10; i>=0; --i){
            for(auto iter = m[i].begin(); iter != m[i].end(); ++iter){
                if(m[i][iter->first] == 1){
                    if(i == 10){
                        return i;
                    }
                    else{
                        bool isSub = false;
                        for(int j=i+1; j<=10; ++j){
                            for(auto it = m[j].begin(); it != m[j].end(); ++it){
                                if(sub(iter->first, it->first)){
                                    isSub = true;
                                    break;
                                }
                            }
                            if(isSub){
                                break;
                            }
                        }
                        if(!isSub){
                            return i;
                        }
                    }
                } 
            }
        }
        return -1;
    }
private:
    int sub(string K, string L){
        if(K.length() == 0){
            return 1;
        }
        int k = 0, l = 0;
        for(int i=0; i<max(K.length(), L.length()); ++i){
            if(K[k] == L[l]){
                k++;
                if(k == K.length()){
                    return 1;
                }
            }
            l++;
        }
        return 0;
    }
};

int main(){
    Solution s;
    vector<string> strs{"aba", "cdc", "eae"};
    cout << s.findLUSlength(strs) << endl;
    return 0;
}
