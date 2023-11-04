#include <iostream>
#include <vector>
#include <unordered_map>
#include <iterator>
using namespace std;
int sumGreaterEqualItself(vector<int> &arr)
{
    unordered_map<int, int> hashMap;
    unordered_map<int, int>::iterator it;
    int tot_sum = 0;

    for (int i = 0; i < arr.size(); i++)
    {
        hashMap[arr[i]]++;
    }
    for (it = hashMap.begin(); it != hashMap.end(); it++)
    {
        if (it->second >= it->first)
        {
            tot_sum += it->first;
        }
    }
    return tot_sum;
}
int main()
{
    vector<int> n = {2, 1, 1, 2, 1, 6};

    int answer = sumGreaterEqualItself(n);
    cout << answer;

    return 0;
}