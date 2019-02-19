//Leetcode Problem No 989 Add to Array Form of Integer
//Solution written by Xuqiang Fang on 11 Feb, 2019

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
  vector<int> addToArrayForm(vector<int>& A, int K) {
    vector<int> ans;
    int t = K;
    while(t > 0){
      int a = t % 10;
      t /= 10;
      ans.push_back(a);
    }
    const int n = A.size();
    vector<int> B;
    int added = 0;
    int i = 0;
    t = 0;
    while(i < n || i < ans.size()){
      t = added;
      if(i < n)
	t += A[n-1-i];
      if(i < ans.size())
	t += ans[i];
      added = t / 10;
      t %= 10;
      B.push_back(t);
      ++i;
    }
    if(added > 0){
      B.push_back(added);
    }
    reverse(B.begin(), B.end());
    return B;
  }
};
int main(){
  Solution s;
  vector<int> A{9,9,9,9,9,9,9,9,9,9};
  auto ans = s.addToArrayForm(A, 1);
  for(auto &a  : ans)
    cout << a << " ";
  cout << endl;
  return 0;
}
