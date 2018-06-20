//Leetcode Problem No 854 K-Similar Strings
//Solution written by Xuqiang Fang on 20 June, 2018

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
    int kSimilarity(string A, string B) {
        const int n = A.length();
        if(A == B){
            return 0;
        }
        unordered_set<string> v;
        queue<string> q;
        v.insert(A);
        q.push(A);
        int step = 0;
        while(!q.empty()){
            ++step;
            for(int t=q.size(); t>0; --t){
                string a = q.front();
                q.pop();
                int i = 0;
                while(a[i] == B[i]){
                    ++i;
                }
                for(int j=i+1; j<n; ++j){
                    if(a[j] == B[i] && a[j] != B[j]){
                        swap(a[i], a[j]);
                        if (a == B){
                            return step;
                        }
                        else if(v.count(a) == 0){
                            v.insert(a);
                            q.push(a);
                        }
                        //Important, we need to swap back
                        swap(a[i], a[j]);
                    }
                }
            }
        }
        return step;
    }
};

int main(){
    Solution s;
    cout << (s.kSimilarity("abcdefgjhijklmnrp", "rnmlkjihpgjfedcba")) << endl;
    cout << (s.kSimilarity("abcdkefgjhlmnjrpqio", "rnmlkjpihqgjfoedcba")) << endl;
    cout << (s.kSimilarity("abc", "bca")) << endl;
    cout << (s.kSimilarity("aabbccddee","cbeddebaac")) << endl;
    cout << s.kSimilarity("abccaacceecdeea", "bcaacceeccdeaae") << endl;//should be 9
    return 0;
}
