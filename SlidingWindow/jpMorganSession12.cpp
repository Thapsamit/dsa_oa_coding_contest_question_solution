#include <iostream>
using namespace std;
int main()
{
    int arr[] = {2, 5, 1, 1, 5, 8, 10, 4, 3, 5, 6, 7, 8};
    int n = sizeof(arr) / sizeof(arr[0]);
    int c = 1; // size of each island consider 0 based indexing
    int i = 0;
    int k = 3;
    int ans = 0;
    while (i < n)
    {
        if (i > 0 && arr[i] > arr[i - 1])
        {
            c++;
        }
        else
        {
            if (c >= k)
            {
                ans += (c - k + 1);
            }
            c = 1;
        }
        i++;
    }

    // corner case we might forget the last island so we need to add that as well
    if (c >= k)
    {
        ans += (c - k + 1);
    }
    cout << ans;
    return 0;
}