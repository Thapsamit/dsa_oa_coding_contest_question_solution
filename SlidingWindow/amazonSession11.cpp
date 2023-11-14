#include <iostream>
#include <string>
using namespace std;
int main()
{
    string searchWord = "abcz";
    string resultWord = "azdb";
    int a = 0;
    int b = 0;
    int lenA = searchWord.length();
    int lenB = resultWord.length();
    while (a < lenA && b < lenB)
    {
        if (searchWord[b] == resultWord[a])
        {
            a++;
            b++;
        }
        else
        {
            b++;
        }
    }
    cout << lenA - a;
    return 0;
}