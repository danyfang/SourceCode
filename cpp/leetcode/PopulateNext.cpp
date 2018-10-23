//Leetcode Problem No 116 Populating Next Right Pointers in Each Node
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

struct TreeLinkNode{
    int val;
    TreeLinkNode *left, *right, *next;
    TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};
class Solution {
    public:
        void connect(TreeLinkNode *root) {
            if(!root) return;
            TreeLinkNode* tmp = root;
            while(tmp->left || tmp->right){
                head.push_back(tmp);
                tmp = tmp->left;
            }
            for(auto h : head){
                while(h){
                    if(h->left){
                        h->left->next = h->right;
                    }
                    if(h->right && h->next){
                        h->right->next = h->next->left;
                    }
                    h = h->next;
                }
            }
        }
    private:
        vector<TreeLinkNode*> head; 
};
int main(){
    Solution s;
    TreeLinkNode a(1);
    TreeLinkNode b(2);
    TreeLinkNode c(3);
    TreeLinkNode d(4);
    TreeLinkNode e(5);
    TreeLinkNode f(6);
    TreeLinkNode g(7);
    a.left = &b;
    a.right = &c;
    b.left = &d;
    b.right = &e;
    c.left = &f;
    c.right = &g;
    s.connect(&a);
    vector<TreeLinkNode*> v{&a, &b, &d};
    for(auto h : v){
        cout << h->val << "\t";
        while(h->next){
            h = h->next;
            cout << h->val << "\t";
        }
        cout << endl;
    }
    return 0;
}
