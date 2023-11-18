#include <iostream>
#include <vector>
#include <limits.h>
using namespace std;
int main()
{
    int arr[] = {5, -2, 3, 1, 2};
    int n = sizeof(arr) / sizeof(arr[0]);
    int b = 3;
    vector<int> pref(n, 0);
    vector<int> suff(n, 0);
    int pref_sum = 0;
    int suff_sum = 0;
    int maxSum = INT_MIN;
    for (int i = 0; i < n; i++)
    {
        pref_sum += arr[i];
        suff_sum += arr[n - i - 1];
        pref[i] = pref_sum;
        suff[n - i - 1] = suff_sum;
    }
    for (int i = 0; i < b; i++)
    {
        int val = pref[i] + suff[n - (b - i - 1)];
        maxSum = max(maxSum, val);
    }
    cout << maxSum;

    return 0;
}