//Leetcode Problem No  678 Valid Parenthesis String 
//Solution written by Xuqiang Fang on 30 May, 2018

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
    bool checkValidString(string s) {
        int n = s.length();
        if(n == 0){
            return true;
        }
        //the idea is that '*' and '(' can exchange the order if there appears a corresponding ')'
        if(s[0] == ')'){
            return false;
        }
        bool flag = false;
        for(int i=1; i<n; ++i){
            if(s[i] == ')'){
                flag = false;
                for(int j=i-1; j>=0; --j){
                    if(s[j] == '('){
                        s[j] = '.';
                        flag = true;
                        break;
                    }
                }
                if(!flag){//no corresponding '(' was found
                    for(int j=i-1; j>=0; --j){
                        if(s[j] != '.'){
                            s[j] = '.';//find a '*' that cancels ')'
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag){
                    return false;
                }
                s[i] = '.';
            } 
        }
        //when reaching this, all ')' should be removed
        int count = 0;
        for(int i=n-1; i>=0; --i){
            if(s[i] == '('){
                count--; 
            }
            else if(s[i] == '*'){
                count++;
            }
            if(count < 0){
                return false;
            }
        }
        return true;
    }


    //another genuis idea provided by user@sansi
    // the idea is to count the lower and upper bound of the number of valid '('
    /*
    * More specifically, if encounter '(', increase both bounds
    * if encounter ')', decrease both bounds, if lower is below 0, set it to 0
    * if encounter '*', decrease lower bounds, increase upper bounds, if lower is below 0, set it to 0
    * Whenever the upper is below 0, return false immediately
    */

    bool check(string s){
        int l = 0;
        int h = 0;
        for(int i=0; i<s.length(); ++i){
            if(s[i] == '('){
                l++;
                h++;
            }
            else if(s[i] == ')'){
                if(l > 0){
                    l--;
                }
                h--;
            }
            else{
                if(l > 0){
                    l--;
                }
                h++;
            }
            if(h < 0){
                return false;
            }
        }
        return l == 0;
    }

};

int main(){
    Solution s;
    string s1("(*))");
    cout << s.checkValidString(s1) << endl;
    cout << s.check(s1) << endl;
    string s2("(**((***((**))");
    cout << s.checkValidString(s2) << endl;
    cout << s.check(s2) << endl;
    return 0;
}
