#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int arr[] = {5, -8, 1, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    int g = arr[0];

    for (int i = 0; i < n; i++)
    {
        if (i == 0)
        {
            cout << arr[i] << " ";
            g = arr[i];
        }
        else
        {
            int x = max(arr[i], arr[i] + g);
            g = x;
            cout << x << " ";
        }
    }

    return 0;
}