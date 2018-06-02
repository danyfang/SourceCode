//Leetcode Problem No 341 Flatten Nested List Iterator
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
class NestedInteger{
public:
    virtual bool isInteger() const;
    virtual int getInteger() const;
    virtual const vector<NestedInteger> &getList() const;
};

class NestedIterator {
public:
    NestedIterator(vector<NestedInteger> &n) {
        dfs(n);
    }

    int next() {
        return l[c++];
    }

    bool hasNext() {
        return c < l.size(); 
    }
private:
    vector<int> l;
    int c = 0;
    void dfs(const vector<NestedInteger> &n){
        for(int i=0; i<n.size(); ++i){
            if(n[i].isInteger()){
                l.push_back(n[i].getInteger());
            }
            else{
                dfs(n[i].getList());
            }
        }
    }
};

int main(){
    vector<NestedInteger> n;
    NestedIterator s(n);
    
    return 0;
}
