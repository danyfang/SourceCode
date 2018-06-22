//Leetcode Problem No 768 Max Chunks To Make Sorted II
//Leetcode Problem No 769 Max Chunks To Make Sorted 
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
    //for No 769
    int maxChunksToSorted_(vector<int>& arr) {
        const int n = arr.size();
        if(n == 0){
            return 0;
        }
        int ans = 0;
        int m = arr[0];
        for(int i=0; i<n; ++i){
            m = max(m, arr[i]); 
            if(i == m){
                ans++;
            }
        }
        return ans;
    }
    

    int maxChunksToSorted__(vector<int>& arr){
        const int n = arr.size();
        vector<int> copy = arr;
        sort(arr.begin(), arr.end());
        int m = copy[0];
        int ans = 0;
        int prev = 0;
        for(int i=0; i<n; ++i){
            m = max(m, copy[i]);
            int count = 0;
            if(m == arr[i]){
                for(int j=prev; j<=i; ++j){
                    if(arr[j] == m){
                        --count;
                    }
                    if(copy[j] == m){
                        ++count;
                    }
                }
                if(count == 0){
                    ans++;
                    prev = i+1;
                }
            }
        }
        return ans;
    }

    //a O(n) solution
    int maxChunksToSorted(vector<int>& arr){
        const int n = arr.size();
        if(n == 0){
            return 0;
        }
        vector<int> left(n, arr[0]);
        vector<int> right(n, arr[n-1]);
        for(int i=1; i<n; ++i){
            left[i] = max(left[i-1], arr[i]);
        }
        for(int i=n-2; i>=0; --i){
            right[i] = min(right[i+1], arr[i]);
        }
        int ans = 0;
        for(int i=0; i<n-1; ++i){
            //note that the right is  i+1
            if(left[i] <= right[i+1]){
                ans++;
            }
        }
        return ans+1;
    }
};

int main(){
    Solution s;
    vector<int> arr{1,0,2,3,4};
    cout << s.maxChunksToSorted(arr) << endl;
    vector<int> arr2{2,1,3,4,4};
    cout << s.maxChunksToSorted(arr2) << endl;
    return 0;
}
