#include <iostream>
#include <vector>
#include <unordered_map>
#include <limits.h>
using namespace std;

int maxOperations(vector<int> &nums, int k)
{
    int maxOperation = 0;
    unordered_map<int, int> hashMap;
    for (int i = 0; i < nums.size(); i++)
    {
        int target = k - nums[i];
        unordered_map<int, int>::iterator it = hashMap.find(target);
        if (it != hashMap.end())
        {
            // means target found
            hashMap[target]--;
            maxOperation += 1;
            if (hashMap[target] == 0)
            {
                // if becomes 0 then remove it, as we don;t have any number left
                hashMap.erase(it);
            }
        }
        else
        {
            hashMap[nums[i]]++;
        }
    }
    return maxOperation;
}
int main()
{

    vector<int> arr{5, 4, 5, 4, 5, 4, 5, 4};
    int n = arr.size();
    int i = 0;
    int maxPairs = INT_MIN;
    while (i < n)
    {
        int j = 0;
        while (j < n)
        {
            int kk = arr[i] + arr[j];
            int bb = maxOperations(arr, kk);
            maxPairs = max(maxPairs, bb);
            j++;
        }
        i++;
    }
    cout << maxPairs;
    return 0;
}