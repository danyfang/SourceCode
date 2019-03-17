//Leetcode Problem No 1013. Pairs of Songs With Total Durations Divisible by 60
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
  int numPairsDivisibleBy60(vector<int>& time) {
    vector<int> s;
    int base = 60;
    while(base < 1000){
      s.push_back(base);
      base += 60;
    }
    const int n = time.size();
    unordered_map<int, vector<int>> m;
    for(int i=0; i<n; ++i){
      if(m.count(time[i]) == 0){
	m[time[i]] = {};
      }
      m[time[i]].push_back(i);
    }
    int count = 0;
    for(int i=0; i<n; ++i){
      for(auto& b : s){
	if(m.count(b-time[i]) != 0){
	  for(auto& j : m[b-time[i]]){
	    if(j > i)
	      count++;
	  }
	}
      }
    }
    return count;
  }
};

int main(){
  Solution s;
  vector<int> time{30,20,150,100,40};
  cout << s.numPairsDivisibleBy60(time) << endl;
  time = {60, 60, 60};
  cout << s.numPairsDivisibleBy60(time) << endl;
  time = {};
  cout << s.numPairsDivisibleBy60(time) << endl;  
  return 0;
}
