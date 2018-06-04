/*
* This program is to test if operator[] can be used when map is passed as const reference
*/
#include <iostream>
#include <string>
#include <vector>
#include <map>

/*
*If we define a find function that uses const reference to a map and then uses operator[]
*then it is going to cause an compile error 
*/
/*
bool find(const std::map<std::string, int> &m, std::string k){
    return m[k] == 1;
}
*/
/*
* But if we remove the const keyword, then it is OK
*/
bool find(std::map<std::string, int> &m, std::string k){
    return m[k] == 1;
}

int main(){
    std::map<char, int> letter_counts {{'a',27},{'b', 3},{'c', 1}};
    std::cout << "initially : \n";
    for(const auto &pair : letter_counts){
        std::cout << pair.first << ": " << pair.second << "\n";
    }

    letter_counts['b'] = 42;
    letter_counts['x'] = 9;
    std::cout << "after modification:\n";
    for(const auto &pair : letter_counts){
        std::cout << pair.first << ": " << pair.second << "\n";
    }
    std::map<std::string, size_t> word_map;
    for(const auto &w : {"this", "sentence", "is", "not", "a", "sentence",
                           "this", "sentence", "is", "a", "hoax"}){
            ++word_map[w];                   
    }
    for(const auto &pair : word_map){
        std::cout << pair.second << " occurrences of word " << pair.first << '\n';
    }
}

