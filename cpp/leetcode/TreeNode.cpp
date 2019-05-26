
struct TreeNode{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void preorder(TreeNode* root){
  if(root){
    cout << root->val << endl;
    preorder(root->left);
    preorder(root->right);
  }
}

void inorder(TreeNode * root){
  if(root){
    inorder(root->left);
    cout << root->val << endl;
    inorder(root->right);
  }
}

void postorder(TreeNode* root){
  if(root){
    preorder(root->left);
    preorder(root->right);
    cout << root->val << endl;
  }
}
