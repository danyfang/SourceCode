//Leetcode Problem No  951 Flip Equivalent Binary Trees
//Solution written by Xuqiang Fang on 3 Dec, 2018

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
class Solution{
public:
    bool flipEquiv(TreeNode* root1, TreeNode* root2) {
        if(!root1 && !root2){
            return true;
        } 
        else if(!root1 || !root2){
            return false;
        }
        auto&& left = helper(root1);
        auto&& right = helper(root2);
        if(left == right && ((flipEquiv(root1->left, root2->left) && flipEquiv(root1->right, root2->right)) ||
            (flipEquiv(root1->right, root2->left) && flipEquiv(root1->left, root2->right)))){
            return true;    
        }
        return false;
    }
private:
    unordered_set<int> helper(TreeNode* root){
        unordered_set<int> s;
        if(!root){
            return s;
        }
        s.insert(root->val);
        auto&& left = helper(root->left);
        for(auto& l : left){
            s.insert(l);
        }
        auto&& right = helper(root->right);
        for(auto& l : right){
            s.insert(l);
        }
        return s;
    }
};

int main(){
    Solution s;
    TreeNode a(0);
    TreeNode b(1);
    a.left = NULL;
    a.right = &b;
    cout << s.flipEquiv(&a, NULL) << endl;
    return 0;
}
