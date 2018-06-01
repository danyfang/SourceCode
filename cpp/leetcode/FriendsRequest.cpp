//Leetcode Problem No 825 Friends of Appropriate Ages
//Solution written by Xuqiang Fang on 31 May, 2018

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
    int numFriendRequests(vector<int>& ages) {
        int n = ages.size();
        vector<int> bin(121,0);
        for(int i=0; i<n; ++i){
            bin[ages[i]]++;
        }
        int c = 0;
        for(int i=1; i<=120; ++i){
            if(bin[i] > 0){
                //cout << "i = " << i << endl;
                for(int j=1; j<i; ++j){
                    if(j <= 0.5*i + 7 ){
                        continue;
                    }
                    c += bin[i] * bin[j];
                }
                if(i > 0.5*i + 7){
                    c += bin[i] * (bin[i]-1);
                }
            }
        }
        return c;
    }
};

int main(){
    Solution s;
    vector<int> ages{20,30,100,110,120};
    cout << s.numFriendRequests(ages) << endl;
    vector<int> age{16,16};
    cout << s.numFriendRequests(age) << endl;
    vector<int> ag{73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
    cout << s.numFriendRequests(ag) << endl;
    return 0;
}
