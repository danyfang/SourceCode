//Leetcode Problem No 993 Cousins in Binary Tree
//Solution written by Xuqiang Fang on 19 Feb, 2019

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
  bool isCousins(TreeNode* root, int x, int y){
    queue<TreeNode*> q;
    q.push(root);
    while(q.size() > 0){
      int size = q.size();
      unordered_set<int> s;
      for(int i=0; i<size; ++i){
	auto node = q.front();
	q.pop();
	if(node->left && node->right){
	  if(node->left->val == x && node->right->val == y ||
	     node->left->val == y && node->right->val == x){
	    return false;
	  }
	}
	if(node->left){
	  q.push(node->left);
	  s.insert(node->left->val);
	}
	if(node->right){
	  q.push(node->right);
	  s.insert(node->right->val);
	}
      }
      if(s.count(x) != 0 && s.count(y) != 0)
	return true;
    }
    return false;
  }

};

int main(){
  Solution s;
  TreeNode a(1), b(2), c(3), d(4), e(5);
  a.left = &b;
  a.right = &c;
  b.left = &d;
  c.right = &e;
  cout << s.isCousins(&a, 4, 5) << endl;
  cout << s.isCousins(&a, 2, 3) << endl;
  return 0;
}
