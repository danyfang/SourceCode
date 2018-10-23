//Leetcode Problem No 129 Sum Root to Leaf Numbers
//Solution written by Xuqiang Fang on  23 Oct, 2018

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
class Solution{
public:
    int sumNumbers(TreeNode* root) {
        int ans = 0;
        ret = 0;
        if(!root) return ans;
        dfs(root, &ans, 0);
        dfs(root, 0);
        cout << ret << endl;
        return ans;
    }
private:
    int ret;
    void dfs(TreeNode* root, int* ans, int level){
        if(!root->left && !root->right){
            *ans += level * 10 + root->val;
        }
        if(root->left){
            dfs(root->left, ans, level * 10 + root->val);
        }
        if(root->right){
            dfs(root->right, ans, level * 10 + root->val);
        }
    }
    void dfs(TreeNode* root, int level){
        if(!root->left && !root->right){
            ret += level * 10 + root->val;
        }
        if(root->left){
            dfs(root->left, level * 10 + root->val);
        }
        if(root->right){
            dfs(root->right, level * 10 + root->val);
        }
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
    cout << s.sumNumbers(&a) << endl;
    return 0;
}
