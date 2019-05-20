
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
    for(int i=0, j=0; 2*j+1<n; ++i){
      if(node[i] != NULL){
        node[i]->left = node[2*j+1];
        if(2*j+2<n){
          node[i]->right = node[2*j+2];
        }
        j++;
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

  void testcase(){
    vector<int> v{1,2,5,3,null,6,null,4,null,7,null,8,null,null,9};
    auto root = this->construct(v);
    this->print(root);
    this->destruct(root);
    v = {1,401,null,349,88,90};
    root = this->construct(v);
    this->print(root);
    this->destruct(root);
    v = {1,2,5,3,4,6,7};
    root = this->construct(v);
    this->print(root);
    this->destruct(root);
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


