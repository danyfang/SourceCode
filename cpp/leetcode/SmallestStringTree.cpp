//Leetcode Problem No 988 Smallest String Starting from Leaf
//Solution written by Xuqiang Fang on 5 Feb, 2019

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
  string smallestFromLeaf(TreeNode* root) {
    vector<string> list;
    string father = "";
    helper(root, father, list);
    string ans = list[0];
    for(auto& s : list){
      //cout << s << endl;
      if(compare(s, ans) < 0)
        ans = s;
    }
    return ans;
  }
private:
  void helper(TreeNode* root, string father, vector<string>& list){
    if(!root->left && !root->right){
      father.push_back((char)('a'+root->val));
      string ans;
      int n = father.size();
      for(int i=1; i<=n; ++i){
        ans.push_back(father[n-i]);
      }
      list.push_back(ans);
      return;
    }
    father.push_back((char)('a'+root->val));
    if(root->left)
      helper(root->left, father, list);
    if(root->right)
      helper(root->right, father, list);
  }
  int compare(string& a, string& b){
    for(int i=0; i<min(a.size(), b.size()); ++i){
      if(a[i] < b[i]){
        return -1;
      }
      else if(a[i] > b[i]){
        return 1;
      }
    }
    if(a.size() < b.size())
      return -1;
    else if(a.size() > b.size())
      return 1;
    return 0;
  }
};

int main(){
  Solution s;
  TreeNode a(0), b(1), c(2), d(3), e(4), f(3), g(4);
  a.left = &b;
  a.right = &c;
  b.left = &d;
  b.right = &e;
  c.left = &f;
  c.right = &g;
  cout << s.smallestFromLeaf(&a) << endl;
  return 0;
}
