//Leetcode Problem No 801 Minimum Swaps To Make Sequences Increasing
//Solution written by Xuqiang Fang on 1 June, 2018

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
    int minSwap(vector<int>& A, vector<int>& B) {
        //keep[i] and swap[i] denotes the min swaps to get increasing seq by keeping the last element 
        //or by swaping the last element
        int n = A.size();
        vector<int> keep(n, INT_MAX);
        vector<int> swap(n, INT_MAX);
        keep[0] = 0;
        swap[0] = 1;
        for(int i=1; i<n; ++i){
            if(A[i] > A[i-1] && B[i] > B[i-1]){
                keep[i] = keep[i-1];
                swap[i] = swap[i-1] + 1;
            }
            if(B[i] > A[i-1] && A[i] > B[i-1]){
                swap[i] = min(swap[i], keep[i-1]+1);
                keep[i] = min(keep[i], swap[i-1]);
            }
        }
        return min(swap.back(), keep.back());
    }
};

int main(){
    Solution s;
    vector<int> A{1,3,5,4};
    vector<int> B{1,2,3,7};
    cout << s.minSwap(A, B) << endl;
    return 0;
}
