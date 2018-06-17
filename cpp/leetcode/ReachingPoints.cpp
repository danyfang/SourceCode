//Leetcode Problem No 780 Reaching Points
//Solution written by Xuqiang Fang on 17 June, 2018

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
    bool reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx >= sx && ty >= sy){
            if(tx > ty){
                if(ty == sy){
                    return (tx-sx)%ty == 0;
                }
                tx %= ty;
            }
            else{
                if(tx == sx){
                    return (ty-sy)%tx == 0;
                }
                ty %= tx;
            }
        }    
        return false;
    }
};

int main(){
    Solution s;
    cout << s.reachingPoints(1,1,1,1) << endl;
    cout << s.reachingPoints(1,1,3,5) << endl;
    cout << s.reachingPoints(1,1,2,2) << endl;
    cout << s.reachingPoints(1,1,10000,1) << endl;
    cout << s.reachingPoints(1,2,999999,2) << endl;
    return 0;
}
