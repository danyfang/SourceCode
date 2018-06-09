/*
* this is a c++ source code to provide the functionality of 
* reading a file, sort the words read, eliminate duplicates 
* and write the result to another file
*/
#include <string>
#include <iostream>
#include <algorithm>
#include <iterator>
#include <vector>
#include <fstream>

using namespace std;

int main(){
    string from, to;
    cin >> from >> to;//get source and target file names

    ifstream is{from};//input stream for file "from"
    istream_iterator<string> ii{is};//input iterator for stream
    istream_iterator<string> eos{};//input sentinel

    ofstream os{to};//output stream for file "to"
    ostream_iterator<string> oo{os, "\n"};//outpput iterator for stream

    vector<string> b{ii, eos};
    sort(b.begin(), b.end());

    unique_copy(b.begin(), b.end(), oo);
    return !is.eof()||!os;
}
