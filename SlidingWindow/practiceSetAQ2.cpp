#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 4;
    int end = 0;
    int start = 0;
    int sum = 0;
    bool ans = false;
    int i = -1;
    int j = -1;
    int targetSum = 18;
    while (end < n)
    {
        sum += arr[end];
        if (end - start + 1 == k)
        {
            if (sum == targetSum)
            {
                i = start;
                j = end;
                ans = true;
                break;
            }
        }
        else if (end - start + 1 > k)
        {
            sum -= arr[start];
            start++;
            if (sum == targetSum)
            {
                i = start;
                j = end;
                ans = true;
                break;
            }
        }
        end++;
    }
    cout << "Result = " << ans << endl;
    if (i != -1 && j != -1 && ans)
    {

        for (int s = i; s <= j; s++)
        {
            cout << arr[s] << " ";
        }
    }

    return 0;
}