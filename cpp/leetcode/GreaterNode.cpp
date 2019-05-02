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
    int j = 1;
    const int n = nodes.size();
    for(int i=0; i<n; ++i){
      while(j < n && nodes[j] <= nodes[i]){
        j++;
      }
      if(j < n){

      }
    }
  }
};

int main(){
  Solution s;

  return 0;
}
