//Leetcode Problem No 150 Evaluate Reverse Polish Notation
//Solution written by Xuqiang Fang on 23 Oct, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution{
public:
    int evalRPN(vector<string>& t) {
        if(t.size() == 0) return 0;
        stack<int> s;
        int a = 0;
        int b = 0;
        for(int i=0; i<t.size(); ++i){
            if(!isdigit(t[i][t[i].length()-1])){
                a = s.top();
                s.pop();
                b = s.top();
                s.pop();
                if(t[i] == "+"){
                    s.push(a+b);
                }
                else if(t[i] == "-"){
                    s.push(b-a);
                }
                else if(t[i] == "*"){
                    s.push(a*b);
                }
                else if(t[i] == "/"){
                    s.push(b/a);
                }
            }
            else{
                s.push(stoi(t[i]));
            }
        }
        return s.top();
    }
};

int main(){
    Solution s;
    vector<string> t{"2","1","+","3","*"};
    cout << s.evalRPN(t) << endl;
    t = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    cout << s.evalRPN(t) << endl;
    return 0;
}
