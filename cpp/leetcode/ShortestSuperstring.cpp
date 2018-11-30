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
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                if(i != j){
                    graph[i][j] = dist(A[i], A[j]);
                    graph[j][i] = dist(A[j], A[i]);
                }
            }
            graph[i][i] = A[i].length(); 
        }
        for(int i=0; i<n;  ++i){
            for(int j=0; j<n; ++j){
                cout << graph[i][j] << "\t";
            }
            cout << endl;
        }
        string ans;
        return ans;
    }
private:
    int dist(string& a, string& b){
        int m = min(a.length(), b.length());
        for(int i=m; i>=1; --i){
            if(a.substr(a.length()-i, i) == b.substr(0, i)){
                return b.length()-i;
            }
        }
        return b.length();
    }
};

int main(){
    Solution s;
    vector<string> A{"catg","ctaagt","gcta","ttca","atgcatc"};
    cout << s.shortestSuperstring(A) << endl;
    return 0;
}
