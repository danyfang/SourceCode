//Leetcode Problem No 388 Longest Absolute File Path
//Solution written by Xuqiang Fang on 21 June, 2018

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
    int lengthLongestPath(string input){
        int ans = 0;
        stack<int> st;
        st.push(0);
        for(auto& s : split(input, '\n')){
            int lev = s.find_last_of('\t') + 1;
            while(lev+1 < st.size()){
                st.pop();
            }
            int len = st.top() + s.length() - lev + 1;
            st.push(len);
            if (s.find('.') != -1){
                ans = max(len-1, ans);
            }
        }
        return ans;
    }
private:
    vector<string> split(string s, char c){
        vector<string> ans;
        int p = s.find(c);
        while(p != -1){
            ans.push_back(s.substr(0,p));
            s = s.substr(p+1);
            p = s.find(c);
        }
        ans.push_back(s);
        return ans;
    }
};

int main(){
    Solution s;
    string input{"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"};
    cout << s.lengthLongestPath(input) << endl;
    cout << input << endl;
    return 0;
}
