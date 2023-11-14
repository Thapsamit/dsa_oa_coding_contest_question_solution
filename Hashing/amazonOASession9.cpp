#include <iostream>
#include <unordered_map>
#include <iterator>
#include <string>
#include <limits.h>
using namespace std;
int main()
{
    string str = "mononom";
    string target = "mon";
    unordered_map<char, int> mp1, mp2;
    int maxPossiblity = INT_MAX;

    for (char ch : str)
    {
        mp1[ch]++;
    }
    for (char ch : target)
    {
        mp2[ch]++;
    }
    for (int i = 0; i < target.length(); i++)
    {
        char ch = target[i];
        unordered_map<char, int>::iterator it = mp1.find(ch);
        if (it == mp1.end())
        {
            // means we are unable to find an alphabet tehrefore we return 0 or break the loop;
            break;
        }
        else
        {
            // if exist then take min out of all occurence in target
            int val = mp1[ch] / mp2[ch];
            maxPossiblity = min(maxPossiblity, val);
        }
    }
    cout << maxPossiblity;
    return 0;
}