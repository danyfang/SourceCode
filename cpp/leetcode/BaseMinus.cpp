//Leetcode Problem No 1017. Convert to Base -2
//Solution written by Xuqiang Fang on 3 April, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <cmath>

using namespace std;
class Solution{
public:
  string baseNeg2(int N) {
    const int n = (int)(log(3*N+1)/log(4));
    cout << n << endl;
    return "1";
  }
};

int main(){
  Solution s;
  for(int i=1; i<10; ++i){
    cout << i << "  ";
    s.baseNeg2(i);
  }
  
  return 0;
}
