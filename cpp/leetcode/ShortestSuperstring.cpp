//Leetcode Problem No 943 Find the Shortest Superstring
//Solution written by Xuqiang Fang on 22 Nov, 2018

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
    string shortestSuperstring(vector<string>& A) {
        const int n = A.size();
        vector<vector<int>> graph(n, vector<int>(n, 0));
        /*first build the graph*/
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                graph[i][j] = dist(A[i], A[j]);
                graph[j][i] = dist(A[j], A[i]);
                //cout << "i,j = " << i << "," << j <<" = " << graph[i][j] << endl;
                //cout << "j,i = " << j << "," << i <<" = " << graph[j][i] << endl;
            }
        }
        vector<vector<int>> dp(1<<n, vector<int>(n, INT_MAX));
        vector<vector<int>> path(1<<n, vector<int>(n, 0));
        int last = -1, tmp= INT_MAX;
        for(int i=1; i<(1<<n); ++i){
            for(int j=0; j<n; ++j){
                if((i & (1 << j)) > 0){
                    int prev = i - (1 << j); 
                    if(prev == 0){
                        dp[i][j] = A[j].length();
                    }
                    else{
                        for(int k=0; k<n; ++k){
                            if(dp[prev][k] < INT_MAX && dp[prev][k] + graph[k][j] < dp[i][j]){
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                if(i == (1 << n)-1 && dp[i][j] < tmp){
                    tmp = dp[i][j];
                    last = j;
                }
            } 
        }
        string ans;
        int cur = (1 << n) - 1;
        stack<int> s;
        while(cur > 0){
            s.push(last);
            int temp = cur;
            cur -= (1 << last);
            last = path[temp][last];
        }

        int i = s.top();
        s.pop();
        for(auto x : A[i]){
            ans.push_back(x);
        }
        while(!s.empty()){
            int j = s.top();
            s.pop();
            auto t = A[j].substr(A[j].length()-graph[i][j]);
            for(auto x : t){
                ans.push_back(x);
            }
            i = j;
        }
        return ans;
    }
private:
    int dist(string& a, string& b){
        /*return the length of added part of appended string*/
        for(int i=b.length(); i>0; --i){
            if(a.length() < i) continue;
            if(a.substr(a.length()-i, i) == b.substr(0, i)){
                return b.length() - i;
            }
        }
        return b.length();
    }
};

int main(){
    Solution s;
    vector<string> A{"catg","ctaagt","gcta","ttca","atgcatc"};
    cout << s.shortestSuperstring(A) << endl;
    A = {"alex","loves","leetcode"};
    cout << s.shortestSuperstring(A) << endl;
    return 0;
}
