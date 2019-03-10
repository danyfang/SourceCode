//Leetcode Problem No 654 Maximum Biary Tree
//Solution written by Xuqiang Fang on 10 Mar, 2019

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
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        const int n = nums.size();
        if(n == 0){
            return NULL;
        }
        if(n == 1){
	    TreeNode* ans = new TreeNode(nums[0]);
            return ans;
        }
        int m = 0;
        for(int i=1; i<n; ++i){
            if(nums[i] > nums[m]){
                m = i;
            }
        }
	TreeNode* root = new TreeNode(nums[m]);
        vector<int> left, right;
        int i = 0;
        while(i < n){
            if(i < m){
                left.push_back(nums[i]);
            }
            else if(i > m){
                right.push_back(nums[i]);
            }
            i++;
        }
        root->left = constructMaximumBinaryTree(left);
        root->right = constructMaximumBinaryTree(right);
        return root;
    }
    //free the memory!!!
    void destroy(TreeNode* root){
      if(!root)
	return;
      destroy(root->left);
      destroy(root->right);
      delete root;
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
  vector<int> nums{3,2,1,6,0,5};
  TreeNode* ans = s.constructMaximumBinaryTree(nums);
  s.destroy(ans);
  return 0;
}
