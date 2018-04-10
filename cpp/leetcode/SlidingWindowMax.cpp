//Leetcode problem No 239 Sliding Window Maximum
//Solution provided by Huahualeetcode

#include<iostream>
#include<vector>
#include<set>
#include<deque>

using namespace std;
class MonotonicQueue{
public:
    void push(int e){
        while(!data_.empty() && e > data_.back())
            data_.pop_back();
        data_.push_back(e);
    }

    void pop(){
        data_.pop_front();
    }

    int max() const{
        return data_.front();
    }
private:
    deque<int> data_;
};
class Solution{
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k){
        vector<int> ans;
        for(int i = k - 1; i< nums.size(); ++i){
            ans.push_back(*max_element(nums.begin() + i - k +1, nums.begin() + i + 1));
        }
        return ans;
    }
    vector<int> maxSlidingWindow_multiset(vector<int>& nums, int k){
        vector<int> ans;
        multiset<int> window;
        for(int i=0; i<nums.size(); ++i){
            window.insert(nums[i]);
            if(i - k + 1 >= 0){
                ans.push_back(*window.rbegin());
                window.erase(window.equal_range(nums[i - k + 1]).first);
            }
        }
        return ans;
    }
    vector<int> maxSlidingWindow_deque(vector<int>& nums, int k){
        MonotonicQueue q;
        vector<int> ans;

        for(int i=0; i<nums.size(); ++i){
            q.push(nums[i]);
            if(i - k + 1 >= 0){
                ans.push_back(q.max());
                if(nums[i - k + 1] ==  q.max())
                    q.pop();
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums{1,3,-1,-3,5,3,6,7};
    for(auto i : s.maxSlidingWindow_multiset(nums, 3)){
        cout << i << "\t" ;
    }
    cout << endl;
    for(auto i : s.maxSlidingWindow_deque(nums, 3)){
        cout << i << "\t" ;   
    }
    cout << endl;

    return 0;
}
