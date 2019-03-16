//Leetcode Problem No 990. Satisfiability of Equality Equations
//Solution written by Xuqiang Fang on 12 March, 2019

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
  bool equationsPossible(vector<string>& equations) {
    //first, each node is the father of itself
    for(int i=0; i<26; ++i)
      uf[i] = i;
    for(auto& e : equations){
      if(e[1] == '=')
	uf[find(e[0]-'a')] = find(e[3]-'a');//right is the father of left
    }
    for(auto& e : equations){
      if(e[1] == '!' && find(e[0]-'a') == find(e[3]-'a'))
	return false;
    }
    return true;
  }
private:
  int uf[26];
  int find(int x){//find the father of x
    if(uf[x] != x){
      uf[x] = find(uf[x]);
    }
    return uf[x];
  }
};

int main(){
  Solution s;
  vector<string> e{"a==b","b!=a"};
  cout << s.equationsPossible(e) << endl;
  e = {"b==a","a==b"};
  cout << s.equationsPossible(e) << endl;
  e = {"a==b","b==c","a==c"};
  cout << s.equationsPossible(e) << endl;
  e = {"a==b","b!=c","c==a"};
  cout << s.equationsPossible(e) << endl;  
  return 0;
}
