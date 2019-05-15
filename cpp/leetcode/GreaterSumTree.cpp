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
struct TreeNode{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
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

  return 0;
}
