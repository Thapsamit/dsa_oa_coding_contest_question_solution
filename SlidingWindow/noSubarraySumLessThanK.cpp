#include <iostream>
using namespace std;
int main()
{
    int array[] = {1, 11, 2, 3, 15};
    int n = sizeof(array) / sizeof(array[0]);
    int start = 0;
    int end = 0;
    int sum = 0;
    int k = 10;
    int ans = 0;
    while (end < n && start >= 0)
    {
        sum += array[end];
        while (sum >= k && start < n)
        {
            sum -= array[start];
            start++;
        }
        ans += (end - start + 1);
        end++;
    }
    cout << ans;
    return 0;
}