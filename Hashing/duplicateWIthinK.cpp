#include <iostream>
#include <vector>
#include <unordered_map>
#include <iterator>
using namespace std;
bool duplicatesWithinK(vector<int> &arr, int k)
{
    unordered_map<int, int> hashMap;

    for (int i = 0; i < arr.size(); i++)
    {

        unordered_map<int, int>::iterator it = hashMap.find(arr[i]);

        if (it != hashMap.end() && i - it->second <= k)
        {

            return true;
        }
        hashMap[arr[i]] = i;
    }
    return false;
}
int main()
{
    vector<int> n = {10, 5, 3, 4, 3, 5, 6};
    int k = 3;

    bool answer = duplicatesWithinK(n, k);
    cout << answer;

    return 0;
}