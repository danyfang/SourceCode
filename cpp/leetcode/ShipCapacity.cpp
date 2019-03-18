//Leetcode Problem No 1014. Capacity To Ship Packages Within D Days
//Solution written by Xuqiang Fang on 17 March, 2019

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
  int shipWithinDays(vector<int>& weights, int d){
    vector<int> s;
    int left = 0, right = 0;
    s.push_back(0);
    const int n = weights.size();
    int batch = n / d;
    if(n % d != 0){
        batch++;
    }
    int accumulate = 0;
    int i = 0;
    for(int j=0; j<n; ++j){
      left = max(left, weights[j]);
      accumulate += weights[j];
      s.push_back(accumulate);
      if(j-i+1 <= batch){
	right = max(right, s[j+1]-s[i]);
      }
      else{
	i = j;
      }
    }
    right = max(right, accumulate-s[i]);
    while(left < right){
      int m = (left + right) / 2;
      if(valid(s, m, d)){
	right = m;
      }
      else{
	left = m+1;
      }
    }
    return left;
  }
private:
  bool valid(vector<int>& s, int c, const int d){
    const int n = s.size();
    int l = 0, r = 1, count = 0;
    while(r < n){
      if(s[r]-s[l] > c){
	count++;
	l = r-1;
      }
      r++;
    }
    count++;
    return count <= d;
  }
};

int main(){
  Solution s;
  vector<int> weights{1,2,3,4,5,6,7,8,9,10};
  cout << s.shipWithinDays(weights, 5) << endl;
  weights = {3,2,2,4,1,4};
  cout << s.shipWithinDays(weights, 3) << endl;
  return 0;
}
