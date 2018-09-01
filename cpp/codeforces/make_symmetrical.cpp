//Codeforces Problem No. 1028 F
//Written by Xuqiang Fang on 27 Aug, 2018
/*
Description: Consider a set of points A , initially it is empty. There are three types of queries: Insert 
a point ( x i , y i) to A . It is guaranteed that this point does not belong to A at this moment.  Remove 
a point ( x i , y i) from A . It is guaranteed that this point belongs to A at this moment.  Given a point 
( x i , y i) , calculate the minimum number of points required to add to A to make A symmetrical with respect
to the line containing points ( 0 , 0) and ( x i , y i) . Note that these points are not actually added to A ,
i.e. these queries are independent from each other.
*/
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <queue>
using namespace std;
const int N = 200001;
int m[N][3];
set<pair<int,int>> s;

//this solution is TLE
int main(){
    int n;
    cin >> n;
    int a, b, c;
    for(int i=0; i<n; ++i){
        cin >> m[i][0] >> m[i][1] >> m[i][2];
    }
    for(int i=0; i<n; ++i){
        a = m[i][0];
        b = m[i][1];
        c = m[i][2];

        if(a == 1){
            s.insert({b, c});
        }
        else if(a == 2){
            auto it = s.find({b, c});
            s.erase(it);
        }
        else{
            int ans = 0;
            for(auto it = s.begin(); it != s.end(); ++it){
                int x1 = (*it).first;
                int y1 = (*it).second;
                if(x1*c - y1*b == 0){
                    continue;
                }
                else{
                    int deno = c*c+b*b;
                    int neno1 = 2 * c * (c*x1-b*y1);
                    int neno2 = 2 * b * (c*x1-b*y1);
                    if(neno1 % deno == 0 && neno2 % deno == 0){
                        int x = x1 - neno1 / deno;
                        int y = y1 + neno2 / deno;
                        //cout << "x = " << x << ", y = " << y << endl; 
                        pair<int, int> p {x, y};
                        if(s.find(p) != s.end()){
                            continue;
                        }
                        else{
                            ans++;
                        }
                    }
                    else{
                        ans++;
                    }
                }
            }
            cout << ans << endl;
        }
    }
    return 0;
}
