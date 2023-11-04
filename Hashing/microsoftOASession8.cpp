#include <iostream>
#include <unordered_map>
#include <iterator>
using namespace std;
int calculateDigitSum(int value)
{
    int res = 0;
    while (value != 0)
    {
        int rem = value % 10;
        res += rem;
        value = value / 10;
    }
    return res;
}
int main()
{
    int arr[3] = {51, 32, 43};
    int n = sizeof(arr) / sizeof(arr[0]);
    unordered_map<int, int> hashMap; // store digit sum,value
    int ans = -1;
    for (int i = 0; i < n; i++)
    {
        int digitSum = calculateDigitSum(arr[i]);
        unordered_map<int, int>::iterator it = hashMap.find(digitSum);
        if (it == hashMap.end())
        {
            hashMap[digitSum] = arr[i];
        }
        else
        {
            // exist then check if curr_value is greater than already existed value for this digit sum
            ans = max(ans, (arr[i] + (it->second)));
            if (arr[i] > (it->second))
            {
                hashMap[digitSum] = arr[i];
            }
        }
    }
    cout << ans;
    return 0;
}