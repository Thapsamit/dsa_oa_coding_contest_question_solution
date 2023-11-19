#include <iostream>
#include <vector>
using namespace std;
int main()
{

    int arr[] = {5, 4, 8, 23, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    vector<int> pref(n, 0);
    vector<int> suff(n, 0);
    for (int i = 1; i < n; i++)
    {
        int count = 0;
        for (int j = 0; j < i; j++)
        {
            if (arr[j] > arr[i])
            {
                count++;
            }
        }
        pref[i] = count;
    }
    for (int i = n - 2; i >= 0; i--)
    {
        int count = 0;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[i] < arr[j])
            {
                count++;
            }
        }
        suff[i] = count;
    }
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        ans += (pref[i] * suff[i]);
    }
    cout << ans;
    return 0;
}