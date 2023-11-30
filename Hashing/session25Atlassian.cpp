#include <iostream>
#include <vector>
#include <unordered_map>
#include <limits.h>
using namespace std;
int main()
{
    vector<int> arr = {1, 5, 3, 7, 8};
    int n = arr.size();
    vector<int> s(n, 0);
    unordered_map<int, int> hashMap;
    for (int i = 0; i < n; i++)
    {
        s[i] = arr[i] - i;
        hashMap[s[i]] += arr[i];
    }
    int maxSum = 0;
    for (auto it = hashMap.begin(); it != hashMap.end(); ++it)
    {
        maxSum = max(maxSum, it->second);
    }
    cout << maxSum;
    return 0;
}