//Leetcode Problem No 
//Solution written by Xuqiang Fang on 

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
struct TreeNode{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};




TreeNode* construct(vector<int> v){//-1 means null
  TreeNode root{v[0]};
  int i = 0;
  const int n = v.size();
  deque<TreeNode*> ans;
  ans.push_back(&root);
  while(i < n){
    int size = ans.size();
    for(int j=0; j<size; ++j){
      auto t = ans.front();
      ans.pop_front();
      if(t == NULL){
        i += 2;
        if(i >= n){
          return &root;
        }
      }
      else{
        i++;
        if(i >= n){
          return &root;
        }
        if(v[i] == -1){
          t->left = NULL;
          ans.push_back(NULL);
        }
        else{
          TreeNode temp{v[i]};
          t->left = &temp;
        }
        i++;
        if(i >= n){
          return &root;
        }
        if(v[i] == -1){
          t->right = NULL;
          ans.push_back(NULL);
        }
        else{
          TreeNode temp{v[i]};
          t->right = &temp;
        }
      }
    }
  }
  return &root;
}

int main(){
  vector<int> v{4,1,6,0,2,5,7,-1};
  auto ans = construct(v);
  return 0;
}
