#include <iostream>
#include <vector>
#include <limits.h>
using namespace std;
int main()
{
    int arr[] = {4, 2, 5, 4, 3, 5, 1, 4, 2, 7};
    int x = 3;
    int y = 2;
    int n = sizeof(arr) / sizeof(arr[0]);
    vector<int> prefix(n, 0);
    for (int i = 0; i < n; i++)
    {
        if (i - y >= 0)
        {
            prefix[i] = arr[i] + prefix[i - y];
        }
        else
        {
            prefix[i] = arr[i];
        }
    }

    for (int i = 0; i < n; i++)
    {
        cout << "prefix" << prefix[i] << endl;
    }
    int minVal = INT_MAX;
    for (int i = 0; i < n; i++)
    {
        int index = i - (x * y);
        int val = prefix[i];
        if (index >= 0)
        {
            val = val - prefix[index];
            minVal = min(minVal, val);
        }
    }
    cout << minVal;
    return 0;
}