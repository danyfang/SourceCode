//Leetcode Problem No 114 Flatten Binary Tree to Linked List
//Solution written by Xuqiang Fang on 23 Oct, 2018

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
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x), left(NULL), right(NULL){}
};
class Solution {
    public:
        void flatten(TreeNode* root) {
            if(!root) return;
            helper(root);
            return;
        }
    private:
        TreeNode* helper(TreeNode* root){
            if(!root || (!root->left && !root->right)){
                return root;
            }
            else{
                TreeNode* tmp = helper(root->right);
                root->right = helper(root->left);
                root->left = NULL;
                right(root)->right = tmp;
                return root;
            }
        }
        TreeNode* right(TreeNode* root){
            while(root->right){
                root = root->right;
            }
            return root;
        }
};
int main(){
    Solution s;
    TreeNode a(1);
    TreeNode b(2);
    TreeNode c(3);
    TreeNode d(4);
    TreeNode e(5);
    a.left = &b;
    b.left = &c;
    c.right = &d;
    a.right = &e;
    s.flatten(&a);
    TreeNode* t = &a;
    while(t){
        cout << t->val << endl;
        t = t->right;
    }
    return 0;
}
