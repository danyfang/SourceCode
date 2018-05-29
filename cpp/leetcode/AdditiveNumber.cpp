//Leetcode Problem No 306 Additive Number
//Solution written by Xuqiang Fang on 28 May, 2018

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
    //i and j are the length of the first two numbers
    //check if the rest can follow
    bool isAdditiveNumber(string num) {
        int n = num.length();
        if(n < 3){
            return false;
        }
        for(int i=1; i<=n/2; ++i){
            for(int j=1; j<=(n-i)/2; ++j){
                if(check(num.substr(0,i), num.substr(i,j), num.substr(i+j))){
                    return true;
                }
            }
        }
        return false;
    }
private:
    bool check(string a, string b, string c){
        if(a.length() > 1 && a[0] == '0'){
            return false;
        }
        if(b.length() > 1 && b[0] == '0'){
            return false;
        }
        string t = add(a,b);
        if(t == c){
            return true;
        }
        if(c.length() < t.length() || c.substr(0,t.length()).compare(t) != 0){
            return false;
        }
        return check(b, t, c.substr(t.length()));
    }
    //this is a string addition function
    string add(string n, string m){
        int i = n.length()-1;
        int j = m.length()-1;
        int c = 0;
        string ans;
        while(i >= 0 || j >= 0){
            int a = i >= 0 ? (n[i--]-'0') : 0;
            int b = j >= 0 ? (m[j--]-'0') : 0;
            int s = a + b + c;
            ans.push_back(s%10+'0');
            c = s/10;
        }
        if(c){
            ans.push_back(c+'0');
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};

int main(){
    Solution s;
    string s1("1991001991");
    string s2("199100199");
    cout << s.isAdditiveNumber(s1) << endl;
    cout << s.isAdditiveNumber(s2) << endl;
    return 0;
}
