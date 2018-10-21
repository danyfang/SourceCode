//Leetcode Problem No 927 Three Equal Parts
//Solution written by Xuqiang Fang on 21 Oct, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution {
public:
    vector<int> threeEqualParts(vector<int>& A) {
        const int n = A.size();
        int count = 0;
        for(auto a : A){
            if(a == 1){
                count++;
            }
        }
        int index[6] = {-1,-1,-1,-1,-1,-1};
        if(count == 0){
            const int c = n / 3;
            return {0, n-c};
        }
        if(count % 3 == 0){
            const int c = count / 3;
            int p = 0;
            int j = 0;
            for(int i=0; i<n; ++i){
                if(A[i] == 1){
                    p++;
                    if(p == 1){
                        index[j++] = i;
                    }
                    if(p == c){
                        index[j++] = i;
                        p = 0;
                    }
                }
            }
            if(n-index[5] <= index[4]-index[3] && n-index[5] <= index[2]-index[1]){
                const int k = n-index[5];
                int flag = 1;
                for(int i=0; i<n-index[4]; ++i){
                    if(A[index[0]+i] != A[index[2]+i] || A[index[0]+i] != A[index[4]+i]){
                        flag = 0;
                        break;
                    } 
                }
                if(flag){
                    return {index[1]+k-1, index[3]+k};
                }
            }
        }
        return {-1,-1};
    }
};
int main(){
    Solution s;
    vector<int> A{1,0,1,0,1};
    vector<int> ans = s.threeEqualParts(A);
    cout << ans[0] << "\t" << ans[1] << endl;
    A = {1,1,0,1,1};
    ans = s.threeEqualParts(A);
    cout << ans[0] << "\t" << ans[1] << endl;
    A = {0,0,0,0,0};
    ans = s.threeEqualParts(A);
    cout << ans[0] << "\t" << ans[1] << endl;
    return 0;
}
