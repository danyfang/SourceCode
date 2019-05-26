//Leetcode Problem No 1054. Distant Barcodes
//Solution written by Xuqiang Fang on 26 May, 2019

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
  vector<int> rearrangeBarcodes(vector<int>& ba) {
    unordered_map<int,int> m;
    for(auto& c : ba){
      m[c] += 1;
    }
    vector<vector<int>> num;
    for(auto it=m.begin(); it!=m.end(); ++it){
      num.push_back({it->second, it->first});
    }
    sort(num.begin(), num.end(), [](vector<int>& x, vector<int>& y){
        return y[0] < x[0];
      });
    vector<int> b;
    for(int i=0; i<num.size(); ++i){
      while(num[i][0] > 0){
        b.push_back(num[i][1]);
        num[i][0]--;
      }
    }
    const int n = b.size();
    vector<int> ans(n, 0);
    int i = 0;
    for(int j=2*i; j<n; i++, j=2*i){     
         ans[j] = b[i];
    }
    int x = 0;
    for(int j=2*x+1; j<n; ++x, j=2*x+1){
        ans[j] = b[i+x];
    }
    return ans;
  }
};

void print(vector<int>& nums){
  for(auto n : nums){
    cout << n << " ";
  }
  cout << endl;
}

int main(){
  Solution s;
  vector<int> barcode{1,1,1,1,2,2,3,3};
  vector<int> ans = s.rearrangeBarcodes(barcode);
  print(ans);
  return 0;
}
