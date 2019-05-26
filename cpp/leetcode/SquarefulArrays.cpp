//Leetcode Problem No 996 Number of Squareful Arrays
//Solution written by Xuqiang Fang on 21 May, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;

void print(vector<int>& nums){
  for(auto n : nums){
    cout << n << " ";
  }
  cout << endl;
}

class Solution{
public:
  int numSquarefulPerms(vector<int>& A){
    const int n = A.size();
    if(n == 1 && squareful(A[0]))
      return 1;
    ans = 0;
    sort(A.begin(), A.end());
    vector<int> tmp, used(n, 0);
    backtrack(A, tmp, used);
    return ans;
  }
private:
  int ans;
  bool squareful(int s){
    auto a = (int)sqrt(s);
    if(a*a == s)
      return true;
    return false;
  }
void backtrack(const vector<int>& nums, vector<int>& tmp, vector<int>& used){
    if(tmp.size() == nums.size()){
      print(tmp);      
      ans++;
    }
    else{
      for(int i=0; i<nums.size(); ++i){
        if(used[i] || (i>0 && nums[i] == nums[i-1] && used[i-1]))
           continue;
        if(tmp.size()>0 && !squareful(tmp[tmp.size()-1]+nums[i]))
           continue;
        used[i] = 1;
        tmp.push_back(nums[i]);
        backtrack(nums, tmp, used);
        used[i] = 0;
        tmp.pop_back();
      }
    }
  }
};


int main(){
  Solution s;
  vector<int> A{1,17,8};
  A = {1,1,8,1,8};
  cout << s.numSquarefulPerms(A) << endl;
  return 0;
}
