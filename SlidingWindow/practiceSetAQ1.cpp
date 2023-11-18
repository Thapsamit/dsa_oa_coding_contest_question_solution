#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int arr[] = {1, -2, 3, -4, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 2;
    int end = 0;
    int start = 0;
    int sum = 0;
    vector<int> ans;
    while (end < n)
    {
        sum += arr[end];
        if (end - start + 1 == k)
        {
            ans.push_back(sum);
        }
        else if (end - start + 1 > k)
        {
            sum -= arr[start];
            ans.push_back(sum);
            start++;
        }
        end++;
    }
    for (auto it : ans)
    {
        cout << it << " ";
    }
    return 0;
}