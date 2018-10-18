//Leetcode Problem No 919 Complete Binary Tree Inserter
//Solution written by Xuqiang Fang on 18 Oct, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <deque>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class CBTInserter {
    public:
        CBTInserter(TreeNode* root) {
            bfs(root);
            size_ = v_.size();
        }

        int insert(int v) {
            int next = v_.size();
            TreeNode* parent = v_[(next-1)/2];
            TreeNode* child = new TreeNode(v);
            v_.push_back(child);
            if(!parent->left){
                parent->left = child;
            }
            else{
                parent->right = child;
            }
            return parent->val;
        }

        TreeNode* get_root() {
            return v_[0];
        }

        void print(){
            for(auto v : v_){
                cout << v->val << "\t";
            }
        }
        void inorder(){
            inorder(v_[0]);
        }
        ~CBTInserter(){
            for(int i=size_; i<v_.size(); ++i){
                delete v_[i];
            }
        }
    private:
        vector<TreeNode*> v_;
        int size_;
        void bfs(TreeNode* root){
            if(! root){
                return;
            }
            deque<TreeNode*> q;
            q.push_back(root);
            while(q.size() > 0){
                auto tmp = q.front();
                q.pop_front();
                v_.push_back(tmp);
                if(tmp->left){
                    q.push_back(tmp->left);
                }
                if(tmp->right){
                    q.push_back(tmp->right);
                }
            }
        }
        void inorder(TreeNode* root){
            if(root){
                inorder(root->left);
                cout << root->val << "\t";
                inorder(root->right);
            }
        }
};
int main(){
    TreeNode r(1);
    TreeNode l(2);
    TreeNode d(3);
    r.left = &l;
    r.right = &d;
    CBTInserter s(&r);
    cout << s.insert(8) << endl;
    cout << s.insert(9) << endl;
    cout << s.insert(7) << endl;
    cout << s.insert(6) << endl;
    cout << s.insert(5) << endl;
    s.print();
    cout << endl;
    s.inorder();
    cout << endl;
    return 0;
}

