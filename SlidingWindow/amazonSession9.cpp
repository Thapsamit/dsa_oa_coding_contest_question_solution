#include <iostream>
#include <unordered_map>
using namespace std;
int main()
{
    int arr[] = {1, 2, 7, 7, 4, 3, 6};
    int n = sizeof(arr) / sizeof(arr[0]);
    int start = 0;
    int end = 0;
    unordered_map<int, int> hashMap;
    int sum = 0;
    int k = 3;
    int maxSum = -1;
    while (end < n)
    {
        sum += arr[end];
        hashMap[arr[end]]++;
        if (end - start + 1 == k)
        {
            // window hit check if hashMap == k
            if (hashMap.size() == k)
            {
                // means a distinct is found
                maxSum = max(maxSum, sum);
            }
        }
        else if (end - start + 1 > k)
        {
            sum -= arr[start];
            hashMap[arr[start]]--;
            if (hashMap[arr[start]] == 0)
            {
                hashMap.erase(arr[start]);
            }
            if (hashMap.size() == k)
            {
                // means a distinct is found
                maxSum = max(maxSum, sum);
            }
            start++;
        }

        end++;
    }
    cout << maxSum;
    return 0;
}