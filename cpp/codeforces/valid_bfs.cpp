//Codeforces Problem No. Valid BFS
//Written by Xuqiang Fang on 2 Sep, 2018
/*
Description:
The BFS algorithm is defined as follows.  Consider an undirected graph with vertices numbered from 1 to n . 
Initialize q as a new queue containing only vertex 1 , mark the vertex 1 as used.  Extract a vertex v from
the head of the queue q .  Print the index of vertex v .  Iterate in arbitrary order through all such vertices
u that u is a neighbor of v and is not marked yet as used. Mark the vertex u as used and insert it into the
tail of the queue q .  If the queue is not empty, continue from step 2.  Otherwise finish.  Since the order
of choosing neighbors of each vertex can vary, it turns out that there may be multiple sequences which BFS 
can print.  In this problem you need to check whether a given sequence corresponds to some valid BFS traversal
of the given tree starting from vertex 1
. The tree is an undirected graph, such that there is exactly one simple path between any two vertices.
*/
#include <cmath>
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n; 
    unordered_map<int, vector<int>> m;
    int u, v;
    for(int i=0; i<n-1; ++i){
        cin >> u >> v; 
        m[u].push_back(v);
        m[v].push_back(u);
    }
    vector<int> a;
    int t;
    for(int i=0; i<n; ++i){
        cin >> t;
        a.push_back(t);
    }
    if(a[0] != 1){
        cout << "No" << endl;
        return 0;
    }
    queue<int> q;
    q.push(1);
    vector<int> used(n+1, 0);
    used[1] = 1;
    int curr = 1;
    while(q.size() > 0){
        int level_size = q.size();
        int t = level_size;
        while(t-- > 0){
            int first = q.front();
            q.pop();
            if(m.count(first) != 0 && m[first].size() > 0){
                //cout << "first = " << first << endl;
                //cout << "size = " << m[first].size() << endl;
                int end = curr;
                for(auto &node : m[first]){
                    if(!used[node]){
                        used[node] = 1;
                        end++;
                    }
                }
                //cout << "end = " << end << endl;
                for(int i=curr; i<end; ++i){
                    if(used[a[i]] == 0){
                        cout << "No" << endl;
                        return 0;
                    }
                    q.push(a[i]);
                }
                curr = end;
            }
        }
    }
    cout << "Yes" << endl;
    return 0;
}
