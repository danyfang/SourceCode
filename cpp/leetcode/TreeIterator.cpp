//Leetcode Problem No. 173 Binary Search Tree Iterator
//Solution written by Xuqiang Fang on 12 April, 2018 

#include <iostream>
#include <stack>

using namespace std;
struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};
typedef struct TreeNode TreeNode;
class BSTIterator{
public:
    BSTIterator(TreeNode* root){
        while(root != NULL){
            cout << "I'm here" << endl;
            stack_.push(root);
            root = root->left;
        }
    }
    bool hasNext(){
        return !stack_.empty();
    }

    int next(){
        TreeNode* node = stack_.top();
        stack_.pop();
        if(node->right != NULL){
            TreeNode* tmpnode = node->right;
            while(tmpnode != NULL){
                stack_.push(tmpnode);
                tmpnode = tmpnode->left;
            }
        }
        return node->val;
    }
private:
    stack<TreeNode *> stack_;
};


/*
* Important messages taken from the following code;
* creating a pointer to a struct is just like creating a pointer to class
* basically create a pointer we need to use keyword new;
* otherwise basic syntax style
*/
int main(){
    TreeNode* root = new TreeNode(1);
    TreeNode a(2);
    root->right = &a;
    BSTIterator it(root);
    BSTIterator it2(&a);
    cout << "Hi" << endl; 
    while(it.hasNext())
        cout << it.next() << endl;
    while(it2.hasNext())
        cout << it2.next() << endl;
    return 0;
}
