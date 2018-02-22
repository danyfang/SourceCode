#include "HashMap.h"
#include <iostream>

using namespace std;
int main(){
    HashMap t;
    t.put(7,8);
    t.put(4,23);
    t.put(8,2332);
    cout << t.search(8) << endl;
    cout << t.search(4) << endl;
}
