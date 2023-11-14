#include <iostream>
#include <limits.h>
using namespace std;
int main()
{

    int arr[5] = {1, 3, 4, 7, 10};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 15;
    int start = 0;
    int end = n - 1;
    int lastClosest = INT_MAX;
    int i = -1;
    int j = -1;
    while (start < n && end >= 0)
    {
        int sum = arr[start] + arr[end];
        int diff = abs(sum - target);
        if (diff < lastClosest)
        {
            lastClosest = diff;
            i = arr[start];
            j = arr[end];
        }
        if (sum > target)
        {
            end--;
        }
        else
        {
            start++;
        }
    }
    cout << i << " " << j;
    return 0;
}