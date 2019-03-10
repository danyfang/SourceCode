//Leetcode Problem No 1008. Construct Binary Search Tree from Preorder Traversal
//Solution written by Xuqiang Fang on 10 March, 2019

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
  TreeNode* bstFromPreorder(vector<int>& preorder) {
    const int n = preorder.size();
    if(n == 0)
      return NULL;
    else if(n == 1)
      return new TreeNode(preorder[0]);
    TreeNode* root = new TreeNode(preorder[0]);
    vector<int> left, right;
    for(int i = 1; i<n; ++i){
      if(preorder[i] < preorder[0])
	left.push_back(preorder[i]);
      else
	right.push_back(preorder[i]);
    }
    root->left = bstFromPreorder(left);
    root->right = bstFromPreorder(right);
    return root;
  }
  void destroy(TreeNode* root){
    if(!root){
      return;
    }
    destroy(root->left);
    destroy(root->right);
    delete root;
  }
};

int main(){
  Solution s;
  return 0;
}
