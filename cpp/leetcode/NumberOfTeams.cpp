//Leetcode Problem No 1395 Number of Teams
//Solution written by Xuqiang Fang on 4 April, 2020

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
    int numTeams(vector<int>& r) {
      const int n = r.size();
      int ans = 0;
      for(int i=0; i<n-2; ++i){
	for(int j=i+1; j<n-1; ++j){
	  for(int k=j+1; k<n; ++k){
	    if((r[i] < r[j] && r[j] < r[k]) || (r[i] > r[j] && r[j] > r[k])){
	      ans++;
	    }
	  }
	}
      }
      return ans;
    }
};
int main(){
  Solution s;
  vector<int> r = {2,5,3,4,1};
  cout << s.numTeams(r) << endl;
  r = {2,1,3};
  cout << s.numTeams(r) << endl;
  r = {1,2,3,4};
  cout << s.numTeams(r) << endl;  
  return 0;
}
