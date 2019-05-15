
#define null -1
struct TreeNode{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};



class Leetcode{
public:
  TreeNode* construct(vector<int>& v){
    const int n = v.size();
    vector<TreeNode*> node;
    for(int i=0; i<n; ++i){
      node.push_back(helper(v, i));
    }
    for(int i=0; 2*i+2<n; ++i){
      if(node[i] != NULL){
	node[i]->left = node[2*i+1];
	node[i]->right = node[2*i+2];
      }
    }
    return node[0];
  }
  void destruct(TreeNode* root){
    if(root){
      destruct(root->left);
      destruct(root->right);
      delete root;
    }
  }
  void print(TreeNode* root){
    if(root){
      print(root->left);
      cout << root->val << endl;
      print(root->right);
    }
  }
private:
  TreeNode* helper(vector<int>& v, int i){
    if(v[i] == null){
      return NULL;
    }
    else{
      return new TreeNode(v[i]);
    }
  }
};


