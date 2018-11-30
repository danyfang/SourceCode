//Leetcode Problem No 946 Validate Stack Sequences
//Solution written by Xuqiang Fang on 29 Nov, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> s;
        const int n = pushed.size();
        int index = 0;
        for(auto& p : pushed){
            if(p == popped[index]){
                index++;
            }
            else{
                s.push(p);
            }
            while(!s.empty() && s.top() == popped[index]){
                s.pop();
                index++;
            }
        }
        while(!s.empty() && s.top() == popped[index]){
            s.pop();
            index++;
        }
        /*
        while(!s.empty()){
            cout << "in stack: ";
            cout << s.top() << endl;
            s.pop();
        }
        */
        return s.empty();
    }
};
int main(){
    Solution s;
    vector<int> pushed{1,2,3,0};
    vector<int> popped{2,1,3,0};
    cout << s.validateStackSequences(pushed, popped) << endl;
    pushed = {1,2,3,4,5};
    popped = {4,3,5,1,2};
    cout << s.validateStackSequences(pushed, popped) << endl;
    return 0;
}
