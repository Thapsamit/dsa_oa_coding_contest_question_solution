#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;
int main()
{
    string s = "abcca";
    int k = 3;
    unordered_map<char, int> hashMap;
    int n = s.length();
    int end = 0;
    int begin = 0;
    int ans = 0;
    while (end < n)
    {
        char ch = s[end];
        hashMap[ch]++;
        while (hashMap.size() >= k)
        {
            char c = s[begin];
            hashMap[c]--;
            if (hashMap[c] == 0)
            {
                hashMap.erase(c);
            }
            ans += (n - end);
            begin++;
        }
        end++;
    }
    cout << ans;
    return 0;
}