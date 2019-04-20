//Leetcode Problem No 1018. Binary Prefix Divisible By 5
//Solution written by Xuqiang Fang on 3 April, 2019

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
  vector<bool> prefixesDivBy5(vector<int>& A) {
    const int n = A.size();
    vector<bool> ans(n, false);
    int s = A[0];
    int i = 0;
    while(i < n){
      if(s % 5 == 0){
	ans[i] = true;
      }
      s *= 2;
      ++i;
      if(i < n){
	s += A[i];
      }
      s %= 5;
    }
    return ans;
  }
};

int main(){
  Solution s;
  vector<int> A{0,1,1};
  for(auto a : s.prefixesDivBy5(A)){
    cout << a << " ";
  }
  cout << endl;
  A = {0,1,1,1,1,1};
  for(auto a : s.prefixesDivBy5(A)){
    cout << a << " ";
  }
  cout << endl;  
  A = {1,1,1,0,1};
  for(auto a : s.prefixesDivBy5(A)){
    cout << a << " ";
  }
  cout << endl;  
  return 0;
}
