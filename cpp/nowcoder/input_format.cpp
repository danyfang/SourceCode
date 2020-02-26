#include <iostream>
using namespace std;
int main() {
    int a,b;
    while(cin >> a >> b)
        cout << a+b << endl;
}


#include <iostream>
using namespace std;
int main() {
    int a,b;
}


#include <iostream>
using namespace std;
int main() {
    int n, a , s;
    while(cin >> n){
        if(!n) break;
        s = 0;
        while(n-- > 0){
            cin >> a;
            s += a;
        }
        cout << s << endl;
    }
    return 0;
}



#include <iostream>
using namespace std;
int main()
{
    int tmp, sum=0;
    while(cin >> tmp){
        sum += tmp;
        if(cin.get() == '\n'){
            cout << sum << endl;
            sum = 0;
        }
    }
}


#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int main()
{
    int n;
    cin >> n;
    string tmp;
    vector<string> v;
    while(n-- > 0){
        cin >> tmp;
        v.push_back(tmp);
    }

        sort(v.begin(), v.end());
        for(int i=0; i<v.size(); ++i){
            cout << v[i];
            if(i < v.size()-1){
                cout << " ";
            }
        }
        cout << endl;
}




#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<sstream>
using namespace std;
int main()
{
    string s1;
    vector<string> line;
    while(getline(cin,s1))
    {
        line.clear();
        string s2;
        stringstream ss(s1);
        while(getline(ss,s2,','))
            line.push_back(s2);
        sort(line.begin(),line.end());
        cout<<line[0];
        for(int i=1;i<line.size();i++)
        {
            cout<<","<<line[i];
        }
        cout<<endl;
    }
}
