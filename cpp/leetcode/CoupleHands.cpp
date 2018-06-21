//Leetcode Problem No 765 Couples Hoding Hands
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
    /*
    * The idea of couple holding hands come from a similar problem, to find
    * the minimum number of swaps to make an array sorted. (The array has to be an
    * permutation of 0 to N-1, where N is the size of the array)
    */
    //And here is the solution to the minimum swaps problem
    //N integers problem, the swapping stop signal is i == row[i]
    int miniSwapArray(vector<int>& row){
        const int n = row.size();
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=row[i]; j!=i; j=row[i]){
                swap(row[i], row[j]);
                ans++;
            }
        }
        return ans;
    }

    //N couples problem, the swaping stop signal is i == ptn[pos[ptn[row[i]]]]
    int minSwapsCouples(vector<int>& row) {
        const int n = row.size();    
        vector<int> ptn(n, 0);
        vector<int> pos(n, 0);
        for(int i=0; i<n; ++i){
            ptn[i] = (i % 2 == 0) ? i + 1 : i - 1;
            pos[row[i]] = i; 
        }
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=ptn[pos[ptn[row[i]]]]; i!=j; j=ptn[pos[ptn[row[i]]]]){
                swap(row[i], row[j]);
                swap(pos[row[i]], pos[row[j]]);
                ans++;
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> num{2,3,1,0,5,4};
    cout << s.miniSwapArray(num) << endl;
    vector<int> row{0,2,1,3};
    vector<int> ro{3,2,0,1};
    cout << s.minSwapsCouples(row) << endl;
    cout << s.minSwapsCouples(ro) << endl;
    return 0;
}
