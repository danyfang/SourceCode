//Leetcode Problem No 754 Reach a Number
//Solution written by Xuqiang Fang on 14 June, 2018

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
    int reachNumber(int target) {
        target = abs(target);
        int i = 1, s = 0;
        while(s < target){
            s += i++;
        }
        if(s == target || (s- target)%2 == 0){
            return i-1;
        }
        else if(i % 2 != 0){
            return i;
        }
        return i+1;
    }
};

int main(){
    Solution s;
    int x;
    while((cin>>x) && x){
        cout << s.reachNumber(x) << endl;
    }
    return 0;
}
