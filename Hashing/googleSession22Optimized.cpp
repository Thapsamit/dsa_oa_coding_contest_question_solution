#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int arr[] = {5, -8, 1, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    vector<int> p(n, 0);
    vector<int> s(n, 0);
    vector<int> max_s(n, 0);
    for (int i = 0; i < n; i++)
    {
        if (i == 0)
        {
            p[i] = arr[i];
        }
        else
        {
            p[i] = max(arr[i], arr[i] + p[i - 1]);
        }
    }
    for (int i = n - 1; i >= 0; i--)
    {
        if (i == n - 1)
        {
            s[i] = arr[i];
            max_s[i] = arr[i];
        }
        else
        {
            s[i] = max(arr[i], arr[i] + s[i + 1]);
            max_s[i] = max(s[i], max_s[i + 1]);
        }
    }
    int answer = 0;

    for (int i = 0; i < n - 1; i++)
    {

        answer = max(answer, p[i] + max_s[i]);
    }
    cout << answer;

    return 0;
}