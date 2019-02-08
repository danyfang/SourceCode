//Leetcode Problem No 987 Vertical Order Traversal of a Binary Tree
//Solution written by Xuqiang Fang on 5 Feb, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <map>
#include <stack>
#include <queue>

using namespace std;
struct TreeNode{
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL){}
};

class Solution{
public:
  vector<vector<int>> verticalTraversal(TreeNode* root){
    vector<vector<int>> ans;
    map<int, vector<vector<int>>> m;
    index = 0;
    helper(m, root);
    for(auto it=m.begin(); it!=m.end(); ++it){
      sort(it->second.begin(), it->second.end(), [](vector<int>& a, vector<int>& b){
          if(a[0] != b[0])
            return a[0] > b[0];
          else
            return a[2] < b[2];
        });
      vector<int> temp;
      for(auto& v : it->second){
        //cout << it->first << "  ";
        //cout << v[0] << "  " << v[1] << "  " << v[2] << endl;
        temp.push_back(v[1]);
      }
      ans.push_back(temp);
    }
    return ans;
  }
private:
  int index;
  void helper(map<int, vector<vector<int>>>& m, TreeNode* root){
    queue<pair<TreeNode*, vector<int>>> q;
    q.push({root, {root->val, 0, 0}});
    while(q.size() > 0){
      int s = q.size();
      for(int i=0; i<s; ++i){
        auto& e = q.front();
        q.pop();
        if(m.count(e.second[1]) == 0){
          m[e.second[1]] = {{e.second[2], e.second[0], index++}};
        }
        else{
          m[e.second[1]].push_back({e.second[2], e.second[0], index++});
        }
        if(e.first->left){
          q.push({e.first->left, {e.first->left->val, e.second[1]-1, e.second[2]-1}});
        }
        if(e.first->right){
          q.push({e.first->right, {e.first->right->val, e.second[1]+1, e.second[2]-1}});
        }
      }
    }
  }
};

int main(){
  Solution s;
  TreeNode a(3), b(9), c(20), d(15), e(7);
  a.left = &b;
  a.right = &c;
  c.left = &d;
  c.right = &e;
  auto ans = s.verticalTraversal(&a);
  for(auto a : ans){
    for(auto t : a)
      cout << t << " ";
      cout << endl;
  }
  return 0;
}
