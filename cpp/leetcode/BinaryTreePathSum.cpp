//Leetcode Problem No 124 Binary Tree Maximum Path Sum
//Solution written by Xuqiang Fang on 3 July, 2018

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
    TreeNode(int x): val(x), left(NULL), right(NULL){};
};
class Solution{
public:
    int maxPathSum(TreeNode* root){
        if(!root){
            return 0;
        }
        int ans = INT_MIN;
        maxPathSum(root, ans);
        return ans;
    }
private:
    //root must be used, and at most one child can be used
    int maxPathSum(TreeNode* root, int& ans){
        if(!root){
            return 0;
        }
        int l = max(0, maxPathSum(root->left, ans));
        int r = max(0, maxPathSum(root->right, ans));
        int sum = l + r + root->val;
        ans = max(ans, sum);
        return max(l, r) + root->val;
    }
};

int main(){
    Solution s;
    TreeNode r(-6);
    TreeNode a(2);
    TreeNode b(3);
    TreeNode c(4);
    r.left = &a;
    r.right = &b;
    a.right = &c;
    cout << s.maxPathSum(&r) << endl;
    return 0;
}
