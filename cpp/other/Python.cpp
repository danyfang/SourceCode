/**
 compile: g++ -std=c++11 Python.cpp -o python -L /Library/Frameworks/Python.framework/Versions/3.5/lib/ -l python3.5
 run: ./python  /Library/Frameworks/Python.framework/Versions/3.5/lib/
*/

#include <Python/Python.h>
#include <iostream>

using namespace std;
void python_call(){
    PyRun_SimpleString("import sys");
    PyRun_SimpleString("sys.path.insert(0, '~/Desktop/')");
    PyRun_SimpleString("if not hasattr(sys, 'argv'): sys.argv  = ['']");
    PyRun_SimpleString("import tensorflow as tf");
    PyRun_SimpleString("sess = tf.Session()");
    PyRun_SimpleString("print(sess.run(tf.constant(3)))");
    PyRun_SimpleString("sess.close()");
    PyRun_SimpleString("print('hello world')");
}

int main(int argc, char *argv[])
{
    Py_Initialize();
    python_call();
    cout << "second" << endl;
    python_call();
    Py_Finalize();
    return 0;
}
