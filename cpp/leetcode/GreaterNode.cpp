//Leetcode Problem No 1019. Next Greater Node In Linked List
//Solution written by Xuqiang Fang on 2 May, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
struct ListNode{
  int val;
  ListNode* next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution{
public:
  vector<int> nextLargerNodes(ListNode* head) {
    vector<int> nodes;
    while(head){
      nodes.push_back(head->val);
      head = head->next;
    }
  
    const int n = nodes.size();
    vector<int> ans;
    for(int i=0; i<n; ++i){
      int j = i+1;
      while(j < n && nodes[j] <= nodes[i]){
        j++;
      }
      if(j < n){
        ans.push_back(nodes[j]);
      }
      else{
        ans.push_back(0);
      }
    }
    return ans;
  }
};

int main(){
  Solution s;
  
  return 0;
}
