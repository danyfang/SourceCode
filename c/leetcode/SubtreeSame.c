// Leetcode probelm No 572 Subtree of Another Tree
//Solution written by Xuqiang Fang on 5 April, 2018 
#include <stdio.h>
#include <stdbool.h>
struct TreeNode{
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

bool isSame(struct TreeNode* s, struct TreeNode* t){
    if(s == NULL)
        return t == NULL;
    if(t == NULL)
        return s == NULL;
    if(s->val == t->val)
        return isSame(s->left, t->left) && isSame(s->right, t->right);
    return false;
}
bool isSubtree(struct TreeNode* s, struct TreeNode* t){
    if(s == NULL)
        return t == NULL;
    if(t == NULL)
        return s == NULL;
    if(s->val == t->val)
        return isSame(s, t) || isSubtree(s->left, t) || isSubtree(s->right, t);
    else
        return isSubtree(s->left, t) || isSubtree(s->right, t);
}

int main(int argc, char* argv[])
{
    struct TreeNode a1 = {2, NULL, NULL};
    struct TreeNode b1 = {3, NULL, NULL};
    struct TreeNode root1 = {1, &a1, &b1};
    struct TreeNode a2 = {2, NULL, NULL};
    struct TreeNode b2 = {3, NULL, NULL};
    struct TreeNode root2 = {1, &a2, &b2};
    printf("%d\n", isSubtree(&root1, &root2));
    return 0;
}
