//Leetcode Problem No 984 Strings Without AAA or BBB
//Solution written by Xuqiang Fang on 28 Jan, 2019

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
    string strWithout3a3b(int A, int B){
        string com[] = {"aba", "bab", "ab", "a", "b"};
        string ans;
        if(A > 2*B){
            ans += com[3];
            for(int i=0; i<B; ++i){
                ans += com[0];
            }
            for(int i=0; i<A-2*B-1; ++i){
                ans += com[3];
            }
        }
        else if(A > B){
            for(int i=0; i<A-B; ++i){
                ans += com[0];
            }
            for(int i=0; i<2*B-A; ++i){
                ans += com[2]; 
            }
        }
        else if(A == B){
            for(int i=0; i<A; ++i){
                ans += com[2];
            }
        }
        else if(2*A >= B){
            for(int i=0; i<B-A; ++i){
                ans += com[1];
            } 
            for(int i=0; i<2*A-B; ++i){
                ans += com[2];
            }
        }
        else{
            ans += com[4]; 
            for(int i=0; i<A; ++i){
                ans += com[1];
            }
            for(int i=0; i<B-2*A-1; ++i){
                ans += com[4];
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    cout << s.strWithout3a3b(5, 8) << endl;
    cout << s.strWithout3a3b(5, 3) << endl;
    cout << s.strWithout3a3b(5, 9) << endl;
    cout << s.strWithout3a3b(8, 5) << endl;    
    return 0;
}
