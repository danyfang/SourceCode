//Leetcode Problem No 1012 Complement of Base 10 Integer
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
  int bitwiseComplement(int N) {
    vector<int> bin;
    do{
      bin.push_back(N&1);
    }while(N >>= 1);
    int ans = 0;
    int base = 1;
    for(auto& a : bin){
      ans += (1-a)*base;
      base *= 2;
    }
    return ans;
  }
};

int main(){
  Solution s;
  cout << s.bitwiseComplement(5) << endl;
  cout << s.bitwiseComplement(7) << endl;
  cout << s.bitwiseComplement(10) << endl;  
  return 0;
}
