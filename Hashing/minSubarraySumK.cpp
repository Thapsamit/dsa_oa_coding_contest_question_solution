#include <iostream>
#include <vector>
#include <unordered_map>
#include <iterator>
#include <algorithm>
#include <limits.h>
using namespace std;
int minSubarraySumK(vector<int> &arr, int k)
{
    unordered_map<int, int> hashMap;
    int pref_sum = 0;
    int answer = INT_MAX;
    for (int i = 0; i < arr.size(); i++)
    {
        pref_sum += arr[i];
        int target = pref_sum - k;
        if (pref_sum == k)
        {
            // check if already we have there something in hashMap if yes then take only that otherwise
            unordered_map<int, int>::iterator it = hashMap.find(pref_sum);
            if (it != hashMap.end())
            {
                answer = min(answer, i - it->second);
            }
            else
            {
                answer = min(answer, i);
            }
        }
        else
        {
            unordered_map<int, int>::iterator it = hashMap.find(target);
            if (it != hashMap.end())
            {
                answer = min(answer, i - it->second);
            }
        }
        hashMap[pref_sum] = i;
    }
    return answer;
}
int main()
{
    vector<int> n = {1, 2, 4, 3, 2, 4, 1};
    int k = 7;

    int answer = minSubarraySumK(n, k);
    cout << answer;

    return 0;
}