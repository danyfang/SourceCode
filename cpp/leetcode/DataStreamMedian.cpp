//Leetcode Problem No 295 Find Median from Data Stream
//Solution written by Xuqiang Fang on 5 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
/*
* The idea is to maintain two heaps, one max heap to maintain elements from lower half and 
* one min heap to maintain elements from higher half
* Think it this way: we need the min from the higher half (min queue) and max from the lower half(max queue)
*/
class MedianFinder{
public:
    /** initialize your data structure here. */
    MedianFinder() {
        median = 0; 
    }
    
    void addNum(int num) {
        if(max_q.size() > min_q.size()){
            if(num < median){
                min_q.push(max_q.top());
                max_q.pop();
                max_q.push(num);
            }
            else{
                min_q.push(num);
            }
            median = (double)(max_q.top() + min_q.top()) / 2.0;
        }
        else if(min_q.size() > max_q.size()){
            if(num > median){
                max_q.push(min_q.top());
                min_q.pop();
                min_q.push(num);
            }
            else{
                max_q.push(num);
            }
            median = (double)(max_q.top() + min_q.top()) / 2.0;
        }
        else if(min_q.size() == max_q.size()){
            if(num < median){
                max_q.push(num);
                median = (double)max_q.top();
            }
            else if(num > median){
                min_q.push(num);
                median = (double)min_q.top();
            }
        }
    }
    
    double findMedian() {
        return median;
    }
private:
    priority_queue<int, vector<int>, greater<int>> min_q;
    priority_queue<int, vector<int>> max_q;
    double median;
};

int main(){
    MedianFinder s;
    int x;
    while((cin >> x) && x){
        s.addNum(x);
        cout << s.findMedian() << endl;
    }
    return 0;
}
