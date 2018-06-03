//Leetcode Problem No 844 Backspace String Compare
//Solution written by Xuqiang Fang on 3 June, 2018

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
    bool backspaceCompare(string S, string T) {
        stack<char> s;
        stack<char> t;
        for(int i=0; i<S.length(); ++i){
            if(S[i] == '#'){
                if(s.size() > 0){
                    s.pop();
                }
            }
            else{
                s.push(S[i]);
            }
        }
        for(int i=0; i<T.length(); ++i){
            if(T[i] == '#'){
                if(t.size() > 0){
                    t.pop();
                }
            }
            else{
                t.push(T[i]);
            }
        }
        if(s.size() != t.size()){
            return false;
        }
        while(t.size() > 0){
            if(t.top() != s.top()){
                return false;
            }
            t.pop();
            s.pop();
        }
        return true;
    }
};

int main(){
    Solution s;
    string S{"ab#c"};
    string T{"ad#c"};
    cout << s.backspaceCompare(S, T) << endl;
    return 0;
}
