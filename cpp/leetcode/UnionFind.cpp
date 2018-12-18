/*
A untility union find class
*/
#include <iostream>
#include <vector>

using namespace std;
class UnionFind{
public:
    int find(int i){
        auto p = parent[i];
        if(i == p){
            return i;
        }
        return parent[i] = find(p);
    } 

    void union_op(int i, int j){
        int p1 = find(i);
        int p2 = find(j);
        if(p1 == p2){
            return;
        }
        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else if(rank[p2] > rank[p1]){
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        max_size = max(max_size, max(rank[p1], rank[p2]));
    }
    int get(){
        return max_size;
    }
    UnionFind(int n){
        max_size = 0;
        parent = vector<int>(n);
        rank = vector<int>(n, 1);
        for(int i=0; i<n; ++i){
            parent[i] = i;
        }
    }
private:
    vector<int> parent;
    vector<int> rank;
    int max_size;
};

int main(){
    UnionFind a(10);
    return 0;
}
