//Leetcode Problem No 976. Largest Perimeter Triangle
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
class Solution{
public:
  int largestPerimeter(vector<int>& A) {
    const int n = A.size();
    sort(A.begin(), A.end(), greater<int>());
    int ans = 0;
    for(int i=0; i<n-2; ++i){
      for(int j=i+1; j<n-1; ++j){
        if(A[i]-A[j] < A[j+1]){
          ans = max(A[i]+A[j]+A[j+1], ans);
        }
        break;
      }
    }
    return ans;
  }
};

int main(){
    Solution s;
    vector<int> A{2,1,2};
    cout << s.largestPerimeter(A) << endl;
    A = {1,2,1};
    cout << s.largestPerimeter(A) << endl;
    A = {3,2,3,4};
    cout << s.largestPerimeter(A) << endl;    
    A = {3,6,2,3};
    cout << s.largestPerimeter(A) << endl;    
    return 0;
}
