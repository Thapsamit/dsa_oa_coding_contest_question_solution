#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;
int main()
{
    int arr[] = {8, 4, 4, 8, 5, 2, 1, 2, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    unordered_map<pair<int, int>, int> hashMap;
    int pref = 0;
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        pref += arr[i];
        int focus_sum = pref - arr[i];
        int g = focus_sum - arr[i];
        count = count + hashMap[{arr[i], g}];
        hashMap[{arr[i], pref}]++;
    }
    cout << count;

    return 0;
}