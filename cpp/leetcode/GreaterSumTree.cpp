//Leetcode Problem No 1038. Binary Search Tree to Greater Sum Tree
//Solution written by Xuqiang Fang on 14 May, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;

#define null -1
struct TreeNode{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};



class Leetcode{
public:
  TreeNode* construct(vector<int>& v){
    const int n = v.size();
    vector<TreeNode*> node;
    for(int i=0; i<n; ++i){
      node.push_back(helper(v, i));
    }
    for(int i=0; 2*i+2<n; ++i){
      if(node[i] != NULL){
	node[i]->left = node[2*i+1];
	node[i]->right = node[2*i+2];
      }
    }
    return node[0];
  }
  void destruct(TreeNode* root){
    if(root){
      destruct(root->left);
      destruct(root->right);
      delete root;
    }
  }
  void print(TreeNode* root){
    if(root){
      print(root->left);
      cout << root->val << endl;
      print(root->right);
    }
  }
private:
  TreeNode* helper(vector<int>& v, int i){
    if(v[i] == null){
      return NULL;
    }
    else{
      return new TreeNode(v[i]);
    }
  }
};



class Solution {
public:
    TreeNode* bstToGst(TreeNode* root) {
        if(!root){
            return root;
        }
        int s = sum(root, 0); 
        S = s;
        preorder(root);
        return root;
    }
private:
    int S;
    void preorder(TreeNode* root){
        if(root->left){
            preorder(root->left);
        }
        int copy = root->val;
        root->val = S;
        S -= copy;
        if(root->right){
            preorder(root->right);
        }
        
    }
    int sum(TreeNode* root, int s){
        if(root){
            int left = sum(root->left, s);
            int right = sum(root->right, s);
            s += left;
            s += right;
            s += root->val;
        } 
        return s;
    }
};


int main(){
  Solution s;
  Leetcode l;
  vector<int> v{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
  auto root = l.construct(v);
  cout <<"The original Tree\n";
  l.print(root);
  root = s.bstToGst(root);
  cout << "Greater Sum Tree\n";
  l.print(root);
  l.destruct(root);
  return 0;
}
