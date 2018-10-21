//Leetcode Problem No 923 3Sum With Multiplicity
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
class Solution{
public:
    int threeSumMulti(vector<int>& A, int target) {
        int count[101] = {0}; 
        const int n = A.size();
        const int mod = 1e9+7;
        int mx = A[0];
        for(int i=0; i<n; ++i){
            count[A[i]]++;
            mx = max(mx, A[i]);
        }
        long ans = 0;
        for(int i=0; i<101; ++i){
            for(int j=i; j<101; ++j){
                int k = target - i - j;
                if(k >= j && k <= mx){
                    if(i == j && j == k){
                        ans += combo(count[i], 3);
                    }  
                    else if(i == j && j != k){
                        ans += combo(count[j], 2) * count[k];
                    }
                    else if(i != j && j == k){
                        ans += combo(count[j], 2) * count[i];
                    }
                    else{
                        ans += count[i] * count[j] * count[k];
                    }
                    ans %= mod;
                }
            }
        }
        return ans;
    }
private:
    long combo(int a, int b){
        long ans = 1;
        for(int i=0; i<b; ++i){
            ans *= (long)(a-i);
        }
        for(int i=0; i<b; ++i){
            ans /= (long)(i+1);
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> A{1,1,2,2,3,3,4,4,5,5};
    cout << s.threeSumMulti(A, 8) << endl;
    A = {1,1,2,2,2,2};
    cout << s.threeSumMulti(A, 5) << endl;
    return 0;
}
