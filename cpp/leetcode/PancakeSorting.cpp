//Leetcode Problem No 969 Pancake Sorting
//Solution written by Xuqiang Fang on 18 Jan, 2019

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
    vector<int> pancakeSort(vector<int>& A) {
        /*the strategy is that with 2 steps, we can move the next biggest element to the correct position*/
        const int n = A.size();
        vector<int> ans;
        for(int i=n; i>=1; --i){
            int ind = index(A, i); 
            if(ind == 0){
                flip(A, i);
                ans.push_back(i);
            }
            else{
                flip(A, ind+1);
                ans.push_back(ind+1);
                flip(A, i);
                ans.push_back(i);
            }
        }
        return ans;
    }
private:
    int index(vector<int>& A, int a){
        int i = 0; 
        while(A[i] != a){
            ++i;
        }
        return i;
    }
    
    void flip(vector<int>& A, int a){
        for(int i=0; i<a/2; ++i){
            int tmp = A[i];
            A[i] = A[a-1-i];
            A[a-1-i] = tmp;
        }
    }
};
int main(){
    Solution s;
    vector<int> A{3,2,4,1};
    auto ans = s.pancakeSort(A);
    for(auto a : ans){
      cout << a << " ";
    }
    cout << endl;
    return 0;
}
