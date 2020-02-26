/***
小A刚学了二进制，他十分激动。为了确定他的确掌握了二进制，你给他出了这样一道题目：给定N个非负整数，将这N个数字按照二进制下1的个数分类，二进制下1的个数相同的数字属于同一类。求最后一共有几类数字？


输入描述:
输入的第一行是一个正整数T（0<T<=10），表示样例个数。对于每一个样例，第一行是一个正整数N（0<N<=100），表示有多少个数字。接下来一行是N个由空格分隔的非负整数，大小不超过2^31 – 1。，

输出描述:
对于每一组样例，输出一个正整数，表示输入的数字一共有几类。

*/


#include <iostream>
#include <unordered_set>
using namespace std;

int ones(int x){
    int ans = 0;
    for(int i=0; i<32; ++i){
      ans += 1 & (x >> i);
    }
    cout << x << " " << ans << endl;
    return ans;
}
int main(){
    int m, n, t;
    unordered_set<int> s;
    cin >> m;
    while(m-- > 0){
        cin >> n;
        s.clear();
        while(n-- > 0){
            cin >> t;
            s.insert(ones(t));
        }
        cout << s.size() << endl;
    }
    return 0;
}
