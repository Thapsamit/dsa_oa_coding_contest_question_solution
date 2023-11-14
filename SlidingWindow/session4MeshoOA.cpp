#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;
int main()
{
    string str = "0050501";
    unordered_map<int, int> hashMap;
    int count = 0;
    hashMap[0] = 1;
    int k = 2;
    int sum = 0;
    for (int i = 0; i < str.length(); i++)
    {
        if (str[i] == '5')
        {
            count++;
        }
        sum += hashMap[count - k];
        hashMap[count]++;
    }
    cout << sum;
    return 0;
}