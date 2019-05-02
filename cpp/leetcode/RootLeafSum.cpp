//Leetcode Problem No 1022. Sum of Root To Leaf Binary Numbers
//Solution written by Xuqiang Fang on 2 May, 2019

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

class Solution{
public:
  int sumRootToLeaf(TreeNode* root) {
    total = 0;
    dfs(0, root);
    return total;
  }
private:
  void dfs(int curr, TreeNode* root){
    if(!root->left && !root->right){
      curr += root->val;
      total += curr;
      return;
    }
    curr += root->val;
    curr *= 2;
    if(root->right){
      dfs(curr, root->right);
    }
    if(root->left){
      dfs(curr, root->left);
    }
  }
  int total;
};

int main(){
  Solution s;
  TreeNode a(1), b(0), c(1), d(0), e(1), f(0), g(1);
  a.left = &b;
  a.right = &c;
  b.left = &d;
  b.right = &e;
  c.left = &f;
  c.right = &g;
  cout << s.sumRootToLeaf(&a) << endl;
  return 0;
}
