//Leetcode Problem No  86 Partition List
//Solution written by Xuqiang Fang on 22 Oct, 2018

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
    ListNode(int x){val = x; next = NULL;}
};
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode dummy(0), stupid(0);
        ListNode* tmp = &dummy;
        ListNode* tmp2 = &stupid;
        while(head){
            if(head->val >= x){
                tmp2->next = head;
                tmp2 = tmp2->next;
            }
            else{
                tmp->next = head;
                tmp = tmp->next;
            }
            head = head->next;
        }
        tmp->next = stupid.next;
        tmp2->next = NULL;
        return dummy.next;
    }
};
int main(){
    Solution s;
    ListNode a(1);
    ListNode b(4);
    ListNode c(3);
    ListNode d(2);
    ListNode e(5);
    ListNode f(2);
    a.next = &b;
    b.next = &c;
    c.next = &d;
    d.next = &e;
    e.next = &f;
    ListNode* ans = s.partition(&a, 3);
    while(ans){
        cout << ans->val << endl;
        ans = ans->next;
    }
    return 0;
}
