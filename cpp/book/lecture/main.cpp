//
//  main.cpp
//  cpp_data_structures
//
//  Created by Xuqiang Fang on 20/01/2017.
//  Copyright © 2017 Xuqiang Fang. All rights reserved.
//

#include <iostream>
#include "binary-tree.h"


using namespace std;

int main () {
    int a = 0;
    cout << "Please input a number" << endl;
    cin >> a;
    int arr[a];
    while (a>=0) {
        cin >> arr[a];
        a--;
    }
    btree b_tree;
    int b = (int)sizeof(arr);
    for (int i=0; i<b;i++) {
        b_tree.insert(arr[i]);
    }
    //b_tree.insert(a);
    //cout << b_tree <<endl;
    return 0;
}
