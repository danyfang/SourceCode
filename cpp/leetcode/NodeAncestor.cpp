//Leetcode Problem No 1026. Maximum Difference Between Node and Ancestor
//Solution written by Xuqiang Fang on 12 May, 2019

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
    int maxAncestorDiff(TreeNode* root) {
        vector<int> ancestor;
        return helper(root, ancestor);
    }
private:
    int helper(TreeNode* root, vector<int>& ans){
        int r = 0;
        for(auto& a : ans){
            r = max(r, abs(root->val - a));
        }
        ans.push_back(root->val);
        if(root->left){
            r = max(r, helper(root->left, ans));
        }
        if(root->right){
            r = max(r, helper(root->right, ans));
        }
        ans.pop_back();
        return r;
    }
};

int main(){
  Solution s;

  return 0;
}
