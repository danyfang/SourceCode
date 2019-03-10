//Leetcode Problem No 998 Maximum Binary Tree II (previous is 654 )
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
    TreeNode* insertIntoMaxTree(TreeNode* root, int val) {
        if(root == NULL){
            TreeNode* ans = new TreeNode(val);
            return ans;
        }
        else if(val > root->val){
            TreeNode* ans = new TreeNode(val);
            ans->left = root;
            return ans;
        }
        else{
            root->right = insertIntoMaxTree(root->right, val);
            return root;
        }
    }
  void destroy(TreeNode* root){
    if(!root)
      return;
    destroy(root->left);
    destroy(root->right);
    delete root;
  }
};
class Construct{
public:
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        const int n = nums.size();
	return helper(nums, 0, n);
    }
private:
    TreeNode* helper(vector<int>& nums, int i, int j){
      if(i == j){
	return NULL;
      }
      else if(j-i == 1){
	TreeNode* ans = new TreeNode(nums[i]);
	return ans;
      }
      int m = i;
      for(int x=i+1; x<j; ++x){
	if(nums[x] > nums[m])
	  m = x;
      }
      TreeNode* root = new TreeNode(nums[m]);
      root->left = helper(nums, i, m);
      root->right = helper(nums, m+1, j);
      return root;
    }
};

int main(){
  Solution s;
  Construct c;
  vector<int> nums{4,3,2,5,1};
  TreeNode* root = c.constructMaximumBinaryTree(nums);
  root = s.insertIntoMaxTree(root, 8);
  s.destroy(root);
  return 0;
}
