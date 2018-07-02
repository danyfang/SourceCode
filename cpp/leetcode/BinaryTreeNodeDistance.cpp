//Leetcode Problem No 863 All Nodes Distance K in Binary Tree 
//Solution written by Xuqiang Fang on 2 July, 2018

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
    vector<int> distanceK(TreeNode* root, TreeNode* target, int K) {
        if(!root){
            return {};
        } 
        findParent(root);
        dfs(target, K);
        return ans;
    }
private:
    void dfs(TreeNode* node, int K){
        if(v_.find(node) != v_.end()){
            return;
        } 
        v_.insert(node);
        if(K == 0){
            ans.push_back(node->val);
            return;
        }
        if(node->left){
            dfs(node->left, K-1);
        }
        if(node->right){
            dfs(node->right, K-1);
        }
        TreeNode* p = m_[node];
        if(p){
            dfs(p, K-1);
        }
    }
    void findParent(TreeNode* node){
        if(!node){
            return;
        }
        if(node->left){
            m_[node->left] = node;
            findParent(node->left);
        }
        if(node->right){
            m_[node->right] = node;
            findParent(node->right);
        }
    }
    vector<int> ans;
    unordered_set<TreeNode*> v_;
    unordered_map<TreeNode*, TreeNode*> m_;
};

class Solution2{
public:
    vector<int> distanceK(TreeNode* root, TreeNode* target, int K) {
        if(!root){
            return {};
        }
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            TreeNode* p = q.front();
            q.pop();
            if(p->left){
                q.push(p->left);
                m[p].push_back(p->left);
                m[p->left].push_back(p);
            }
            if(p->right){
                q.push(p->right);
                m[p].push_back(p->right);
                m[p->right].push_back(p);
            }
        }
        vector<int> ans;
        dfs(ans, target, K);
        return ans;
    }
    void dfs(vector<int>& ans, TreeNode* t, int K){
        if(v.count(t) != 0){
            return;
        }
        if(K == 0){
            ans.push_back(t->val);
            return;
        }
        if(m.count(t) == 0){
            return;
        }
        v.insert(t);
        for(auto& p : m[t]){
            dfs(ans, p, K-1);
        }
    }
    unordered_set<TreeNode*> v;
    unordered_map<TreeNode*, vector<TreeNode*>> m;
};

int main(){
    Solution2 s;
    TreeNode r(3);
    TreeNode a(5);
    TreeNode b(1);
    TreeNode c(6);
    TreeNode d(2);
    TreeNode e(0);
    TreeNode f(8);
    TreeNode g(7);
    TreeNode h(4);
    r.left = &a;
    r.right = &b;
    a.left = &c;
    a.right = &d;
    b.left = &e;
    b.right = &f;
    d.left = &g;
    d.right = &h;
    vector<int> ans = s.distanceK(&r, &a, 3);
    for(auto i : ans){
        cout << i <<  " ";
    }
    cout << endl;
    return 0;
}
