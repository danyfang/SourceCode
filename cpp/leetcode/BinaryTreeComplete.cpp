//Leetcode Problem No 958 Check Completeness of a Binary Tree
//Solution written by Xuqiang Fang on 17 Dec, 2018

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
    bool isCompleteTree(TreeNode* root){
        queue<TreeNode*> q;
        vector<string> ans;
        q.push(root);
        ans.push_back(to_string(root->val));
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; ++i){
                auto f = q.front();
                q.pop();
                if(f->left){
                    q.push(f->left);
                    ans.push_back(to_string(f->left->val));
                }
                else{
                    ans.push_back("#");
                }
                if(f->right){
                    q.push(f->right);
                    ans.push_back(to_string(f->right->val));
                }
                else{
                    ans.push_back("#");
                }
            }
        }
        int i = 0;
        const int n = ans.size();
        while(i < n){
            if(ans[i] == "#"){
                int j = i+1;
                while(j < n){
                    if(ans[j] != "#"){
                        return false;
                    }
                    j++;
                }
                break;
            }
            i++;
        }
        return true;
    }
    
    //an elegant solution
    bool isCompleteTree_(TreeNode* root){
        vector<TreeNode*> bfs;
        bfs.push_back(root);
        int i = 0;
        while(i < bfs.size() && bfs[i]){
            bfs.push_back(bfs[i]->left);
            bfs.push_back(bfs[i]->right);
            i++;
        }
        while(i < bfs.size() && !bfs[i])
            i++;
        return i == bfs.size();
    }
};

int main(){
    Solution s;
    TreeNode a(1);
    TreeNode b(2);
    TreeNode c(3);
    TreeNode d(4);
    TreeNode e(5);
    TreeNode f(6);
    TreeNode g(7);
    TreeNode h(8);
    a.left = &b;
    a.right = &c;
    b.left = &d;
    b.right = &e;
    c.right = &f;
    cout << s.isCompleteTree(&a) << endl;
    cout << s.isCompleteTree_(&a) << endl;
    return 0;
}
