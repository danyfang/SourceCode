//Leetcode Problem No 1019. Next Greater Node In Linked List
//Solution written by Xuqiang Fang on 4 April, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <set>
#include <stack>
#include <queue>

using namespace std;
struct ListNode{
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL){}
};

class Solution{
public:
  vector<int> nextLargerNodes(ListNode* head) {
    vector<int> list;
    while(head){
      list.push_back(head->val);
      head = head->next;
    }
    const int n = list.size();
    vector<int> ans(n, 0);
    set<int> s;//all visited elements sorted O(nlogn)

    return ans;
  }
};

int main(){
  Solution s;
  vector<int> h{2,7,4,3,5};
  ListNode a(2);
  ListNode b(7);
  ListNode c(4);
  ListNode d(3);
  ListNode e(5);
  a.next = &b;
  b.next = &c;
  c.next = &d;
  d.next = &e;
  auto ans = s.nextLargerNodes(&a);
  for(auto a : ans)
    cout << a << "  ";
  cout << endl;
  return 0;
}
