//Leetcode Problem No 1046 Last Stone Weight
//Solution written by Xuqiang Fang on 20 May, 2019

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
  int lastStoneWeight(vector<int>& s){
    priority_queue<int> q{s.begin(), s.end()};
    while(q.size() > 2){
      auto a = q.top();
      q.pop();
      auto b = q.top();
      q.pop();
      if(a != b){
        q.push(a-b);
      }
    }
    if(q.size() > 0){
      return q.top();
    }
    return 0;
  }
};

int main(){
  Solution s;
  vector<int> stones{2,7,4,1,8,1};
  cout << s.lastStoneWeight(stones) << endl;
  return 0;
}
