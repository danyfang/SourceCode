//Leetcode Problem No 925 Long Pressed Name
//Solution written by Xuqiang Fang on 21 Oct, 2018

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
    bool isLongPressedName(string name, string typed) {
        int i = 0, j = 0;
        const int n = name.length();
        const int m = typed.length();
        while(i < n && j < m){
            if(name[i] == typed[j]){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i == n;
    }
};
int main(){
    Solution s;
    cout << s.isLongPressedName("laiden", "laiden") << endl;
    cout << s.isLongPressedName("saeed", "ssaaedd") << endl;
    cout << s.isLongPressedName("alex", "aaleex") << endl;
    return 0;
}
