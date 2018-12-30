//Leetcode Problem No 961. N-Repeated Element in Size 2N Array
//Solution written by Xuqiang Fang on 30 Dec, 2018

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
    int repeatedNTimes(vector<int>& A) {
      const int N = A.size();
      unordered_map<int, int> m;
      for(auto& a : A){
	if(m.count(a) == 0){
	  m[a] = 1;
	}
	else{
	  m[a] += 1;
	}
	if(m[a] == N/2){
	  return a;
	}
      }
      return -1;
    }
};

int main(){
    Solution s;
    vector<int> A{1,2,3,3};
    cout << s.repeatedNTimes(A) << endl;
    A = {2,1,2,5,3,2};
    cout << s.repeatedNTimes(A) << endl;
    A = {5,1,5,2,5,3,5,4};
    cout << s.repeatedNTimes(A) << endl;
    return 0;
}
