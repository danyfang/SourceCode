//Leetcode Problem No 1394. Find Lucky Integer in an Array
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
class Solution{
public:
    int findLucky(vector<int>& arr) {
      int a[501] = {0};
      for(auto x : arr){
	if(x>=1 && x<=500){
	  a[x]++;
	}
      }
      for(int i=500; i>=1; --i){
	if(a[i] == i){
	  return i;
	}
      }
      return -1;
    }
};

int main(){
  Solution s;
  vector<int> arr = {2,2,3,4};
  cout << s.findLucky(arr) << endl;
  arr = {1,2,2,3,3,3};
  cout << s.findLucky(arr) << endl;
  return 0;
}
