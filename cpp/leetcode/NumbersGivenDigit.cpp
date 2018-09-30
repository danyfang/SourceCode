//Leetcode Problem No 902 Numbers At Most N Given Digit Set
//Solution written by Xuqiang Fang on 26 Sep, 2018

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
    int atMostNGivenDigitSet(vector<string>& D, int N) {
        string num = to_string(N);
        const int n = num.length();
        int ans = 0;
        int size = D.size();
        for(int i=1; i<n; ++i){
            ans += pow(size, i);
        }

        for(int i=0; i<n; ++i){
            bool prefix = false;
            for(const string&d : D){
                if(d[0] < num[i]){
                    ans += (int)pow(size, n-i-1);
                }
                else if(d[0] == num[i]){
                    prefix = true;
                    break;
                }
            }
            if(!prefix){
                return ans;
            }
        }
        return ans + 1;
    }
};

int main(){
    Solution s;
    vector<string> D{"1","4","9"};
    int N = 1000000000;
    cout << s.atMostNGivenDigitSet(D, N) << endl;
    return 0;
}
