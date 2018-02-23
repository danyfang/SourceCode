#include <iostream>

using namespace std;

bool accept();
bool accept2();
bool accept3();

int main(){
    if (accept3())
        cout << "Yes\n";
    else 
        cout << "No\n";
    return 0;
}


bool accept(){
    cout << "Do you want to proceed (y or no)?\n";
    char answer = 0;
    cin >> answer;
    if(answer ==  'y')
        return true;
    return false;
}

bool accept2(){
    cout << "Do you want to proceed (y or n)?\n";
    char answer = 0;
    cin >> answer;
    switch (answer){
        case 'y':
            return true;
        case 'n':
            return false;
        default:
            cout << "I'll take it for no\n";
            return false;
    }
}

bool accept3() {
    int tries = 1; 
    while (tries<4) {
        cout << "Do you want to proceed (y or n)?\n"; 
        char answer = 0;
        cin >> answer;
        switch (answer) {  
            case 'y':
                return true; 
            case 'n':
                return false; 
            default:
                cout << "Sorry, I don't understand that.\n";
                ++tries;
        }
    }
    cout << "I'll take that for a no.\n"; 
    return false;
}
