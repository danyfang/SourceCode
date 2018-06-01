//Leetcode Problem No 722 Remove Comments
//Solution written by Xuqiang Fang on 30 May, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <regex>

using namespace std;
class Solution{
public:
    vector<string> removeComments(vector<string>& source) {
        /*
        * only a few cases, double slash, block
        */
        vector<string> ans;        
        bool in = false;
        string b;
        for(auto&s : source){
            for(int j=0; j<s.length(); ++j){
                if(in){
                    if(s[j] == '*' && j < s.length() - 1 && s[j+1] == '/'){
                        in = false;
                        j++;
                    }
                } 
                else{
                    if(s[j] == '/' && j < s.length() - 1 && s[j+1] == '*'){
                        in = true;
                        j++;
                    }
                    else if(s[j] == '/' && j < s.length() - 1 && s[j+1] == '/'){
                        break;
                    }
                    else{
                        b.push_back(s[j]);
                    }
                }
            }
            if(!in && b.length() > 0){
                ans.push_back(b);
                b = "";
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<string> s1{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "aaa//a"};
    vector<string> s2{"a/*comment", "line", "more_comment*/b"};
    vector<string> s3{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
    vector<string> ans = s.removeComments(s1);
    for(auto& a : ans){
        cout << a << endl;
    }
    ans = s.removeComments(s2);
    for(auto& a : ans){
        cout << a << endl;
    }
    ans = s.removeComments(s3);
    for(auto& a : ans){
        cout << a << endl;
    }
    return 0;
}
