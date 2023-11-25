#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int arr[] = {5, -8, 1, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    vector<int> ans(n, 0);
    for (int i = 0; i < n; i++)
    {
        if (i == 0)
        {
            ans[i] = arr[i];
        }
        else
        {
            ans[i] = max(arr[i], arr[i] + ans[i - 1]);
        }
    }
    for (auto i : ans)
    {
        cout << i << " ";
    }

    return 0;
}