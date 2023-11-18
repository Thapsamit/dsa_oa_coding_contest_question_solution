#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

bool checkEqual(unordered_map<char, int> a, unordered_map<char, int> b)
{
    for (auto it = a.begin(); it != a.end(); it++)
    {
        if (a[it->first] != b[it->first])
        {
            return false;
        }
    }
    return true;
}
int main()
{
    string a = "abb";
    string b = "bbx";
    unordered_map<char, int> freqEvenA, freqEvenB, freqOddA, freqOddB;
    for (int i = 0; i < a.length(); i++)
    {
        char ch = a[i];
        if (i % 2 == 0)
        {
            freqEvenA[ch]++;
        }
        else
        {
            freqOddA[ch]++;
        }
    }
    for (int i = 0; i < b.length(); i++)
    {
        char ch = b[i];

        if (i % 2 == 0)
        {
            freqEvenB[ch]++;
        }
        else
        {
            freqOddB[ch]++;
        }
    }

    if (checkEqual(freqEvenA, freqEvenB) && checkEqual(freqOddA, freqOddB))
    {
        cout << "Yes";
    }
    else
    {
        cout << "No";
    }

    return 0;
}