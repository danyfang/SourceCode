//Leetcode Problem No 1028 Recover a Tree From Preorder Traversal
//Solution written by Xuqiang Fang on 20 May, 2019

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
  TreeNode* recoverFromPreorder(string s){
    int i = 0;
    return recover(s, i, 0);
  }
private:
  TreeNode* recover(const string& s, int& i, int d){
    int cur = depth(s, i);
    if(cur != d){
      i -= cur;
      return nullptr;
    }
    TreeNode* root = new TreeNode(value(s, i));
    root->left = recover(s, i, d+1);
    root->right = recover(s, i, d+1);
    return root;
  }
  int depth(const string& s, int& i){
    int d = 0;
    while(i < s.size() && s[i] == '-'){
      ++d;
      ++i;
    }
    return d;
  }

  int value(const string& s, int& i){
    int ans = 0;
    while(i < s.size() && isdigit(s[i])){
      ans = 10 * ans + (s[i]-'0');
      ++i;
    }
    return ans;
  }
};

void print(TreeNode* root){
  if(root){
    cout << root->val << endl;
    print(root->left);
    print(root->right);
  }
}
int main(){
  Solution s;
  string S{"1-2--3--4-5--6--7"};
  auto ans = s.recoverFromPreorder(S);
  print(ans);
  S = "1-2--3---4-5--6---7";
  ans = s.recoverFromPreorder(S);
  print(ans);
  S = "1-401--349---90--88";
  ans = s.recoverFromPreorder(S);
  print(ans);  
  return 0;
}
