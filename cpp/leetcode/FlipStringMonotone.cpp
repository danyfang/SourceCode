//Leetcode Problem No 926 Flip String to Monotone Increasing
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
class Solution{
public:
    int minFlipsMonoIncr(string s) {
        const int n = s.length();
        vector<int> zeros(n, 0);
        vector<int> ones(n, 0);
        int x = 0, y = 0;
        for(int i=0; i<n; ++i){
            if(s[i] == '0'){
                x++;
            }
            else{
                y++;
            }
            zeros[i] = x;
            ones[i] = y;
        }
        int ans = min(n-x, n-y);
        for(int i=0; i<n; ++i){
            ans = min(ans, ones[i]+(x-zeros[i]));
        }
        return ans;
    }
};

int main(){
    Solution s;
    cout << s.minFlipsMonoIncr("00110") << endl;
    cout << s.minFlipsMonoIncr("010110") << endl;
    cout << s.minFlipsMonoIncr("00011000") << endl;
    return 0;
}
