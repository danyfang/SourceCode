//Leetcode Problem No 955 Delete Columns to Make Sorted II
//Solution written by Xuqiang Fang on 10 Dec, 2018

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
    int minDeletionSize(vector<string>& A) {
        const int m = A.size();
        const int n = A[0].size();
        vector<int> flag(n, 0);
        for(int i=0; i<m-1; ++i){
            for(int j=0; j<n; ++j){
                if(flag[j] || A[i][j] == A[i+1][j]){
                    continue;
                } 
                if(A[i][j] > A[i+1][j]){
                    flag[j] = 1;
                    i = -1;
                }
                break;
            }
        }
        int ans = 0;
        for(auto& f : flag){
            ans += f;
        }
        return ans;
    }
};
int main(){
    Solution s;
    vector<string> A = {"ca","bb","ac"};
    cout << s.minDeletionSize(A) << endl;
    A = {"xc","yb","za"};
    cout << s.minDeletionSize(A) << endl;
    A = {"zyx","wvu","tsr"};
    cout << s.minDeletionSize(A) << endl;
    A = {"xga","xfb","yfa"};
    cout << s.minDeletionSize(A) << endl;
    A = {"doeeqiy","yabhbqe","twckqte"};
    cout << s.minDeletionSize(A) << endl;
    return 0;
}
