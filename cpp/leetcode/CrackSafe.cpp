//Leetcode Problem No 753 Cracking the Safe
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
    string crackSafe(int n, int k){
        this->total_size = pow(k, n);
        string ans(n, '0');
        unordered_set<string> visited{ans};
        if(dfs(ans, n, k, visited)){
            return ans;
        }
        return "";
    }
private:
    int total_size;
    bool dfs(string& ans, const int n, const int k, unordered_set<string>& visited){
        if(visited.size() == total_size){
            return true;
        } 
        string node = ans.substr(ans.length()-n+1, n-1);
        for(char c='0'; c <'0'+k; ++c){
            node.push_back(c);
            if(!visited.count(node)){
                ans.push_back(c);
                visited.insert(node);
                if(dfs(, n, k, visited)){
                    return true;
                }
                visited.erase(node);
                ans.pop_back();
            }
            node.pop_back();
        }
        return false;
    }
};

int main(){
    Solution s;
    cout << s.crackSafe(2, 2) << endl;
    return 0;
}
