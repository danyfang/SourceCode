//Leetcode Problem No 315 Count of Smaller Numbers After Self
//Solution written by Xuqiang Fang on 5 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
//naive version is trivial, here is the version using mergesort
//we don't sort elements but the index
class Solution{
public:
    vector<int> countSmaller(vector<int> &nums){
        int n = nums.size();
        vector<int> index(n, 0);
        for(int i=0; i<n; ++i){
            index[i] = i;
        }
        vector<int> count(n, 0);
        mergesort(nums, index, count, 0, n);
        return count;
    }
private:
    void mergesort(vector<int> &nums, vector<int> &index, vector<int> &count, int start, int end){
        if(end-start <= 1){
            return;
        } 
        int m = start + (end - start) / 2;
        mergesort(nums, index, count, start, m);
        mergesort(nums, index, count, m, end);
        merge(nums, index, count, start, end, m);
    } 
    void merge(vector<int> &nums, vector<int> &index, vector<int> &count, int start, int end, int m){
        //now the left half and the right half are both sorted, we need three indexes to denote the 
        //position of left, right and the merged one
        vector<int> output(end-start, 0);
        int l = start, r = m, o = 0;
        int smaller = 0;//count the number of smaller elements seen so far
        while(l < m && r < end){
            if(nums[index[r]] < nums[index[l]]){
                output[o++] = index[r++];
                smaller++;
            }
            else{
                output[o++] = index[l];
                count[index[l++]] += smaller;
            }
        }

        while(l < m){
            output[o++] = index[l];
            count[index[l++]] += smaller;
        }
        while(r < end){
            output[o++] = index[r++];
        }
        for(int i=0; i<end-start; ++i){
            index[i+start] = output[i];
        }
    }
};

int main(){
    Solution s;
    vector<int> nums{5,2,6,1};
    vector<int> ans = s.countSmaller(nums);
    for(auto i : ans){
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
