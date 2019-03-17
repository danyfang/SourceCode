//Leetcode Problem No 839. Similar String Groups
//Solution written by Xuqiang Fang on 17 March 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class UnionFind{
public:
  int find(int i){
    auto p = parent[i];
    if(i == p){
      return i;
    }
    return parent[i] = find(p);
  } 

  void union_op(int i, int j){
    int p1 = find(i);
    int p2 = find(j);
    if(p1 != p2){
      parent[p1] = p2;
      count--;
    }
  }
  int get(){
    return count;
  }
  UnionFind(int n){
    parent = vector<int>(n, -1);
    for(int i=0; i<n; ++i){
      parent[i] = i;
    }
    count = n;
  }
private:
  vector<int> parent;
  int count;
};

class Solution{
public:
  int numSimilarGroups(vector<string>& A) {
    const int n = A.size();
    UnionFind uf(n);
    for(int i=0; i<n; ++i){
      for(int j=i+1; j<n; ++j){
	if(similar(A[i], A[j])){
	  uf.union_op(i, j);
	}
      }
    }
    return uf.get();
  }
private:
  bool similar(string& a , string& b){
    const int n = a.size();
    int count = 0;
    for(int i=0; i<n; ++i){
      if(a[i] != b[i]){
	count++;
      }
    }
    return count <= 2;
  }
};

int main(){
  Solution s;
  vector<string> A{"tars","rats","arts","star"};
  cout << s.numSimilarGroups(A) << endl;
  return 0;
}
