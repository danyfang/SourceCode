//Leetcode Problem No 979 Distribute Coins in Binary Tree
//Solution written by Xuqiang Fang on 23 Jan, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };
class Solution {
public:
    int distributeCoins(TreeNode* root) {
        if(!root){
            return 0;
        }          
        return distribute(root) + distributeCoins(root->left) + distributeCoins(root->right);
    }
private:
    int distribute(TreeNode* root){
        if(!root)
            return 0;
        int left_coins = coins(root->left);
        int right_coins = coins(root->right);
        int left_child = child(root->left);
        int right_child = child(root->right);
        return abs(left_coins-left_child) + abs(right_coins-right_child);
    }
    int child(TreeNode* root){
        if(! root){
            return 0;
        } 
        return 1 + child(root->left) + child(root->right);
    }
    int coins(TreeNode* root){
        if(!root){
            return 0;
        } 
        return root->val + coins(root->left) + coins(root->right);
    }
};
int main(){
    Solution s;

    return 0;
}
