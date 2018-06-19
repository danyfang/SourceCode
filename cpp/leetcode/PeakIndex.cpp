//Leetcode Problem No  852 Peak Index in a Mountain Array
//Solution written by Xuqiang Fang on 18 June, 2018

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
    int peakIndexInMountainArray(vector<int>& A) {
        const int n = A.size();
        int ans = 1;
        for(int i=1; i<n-1; ++i){
            if(A[i]>A[i-1]&&A[i]>A[i+1]){
                ans = i;
                break;
            }
        }
        return ans;
    }
    
    //binary search version
    int peakIndexInMountainArray_binary(vector<int>& A){
        const int n = A.size();
        int l = 1;
        int r = n-2;
        int ans = 1;
        while(l <= r){
            int m = l + (r-l) / 2;
            if(A[m] < A[m+1]){
                l = m + 1;
            }
            else if (A[m] < A[m-1]){
                r = m;
            }
            else{
                ans = m;
                break;
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> A{0,2,1,0};
    cout << s.peakIndexInMountainArray(A) << endl;
    cout << s.peakIndexInMountainArray_binary(A) << endl;
    return 0;
}
