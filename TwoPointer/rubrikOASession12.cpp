#include <iostream>
#include <unordered_map>
using namespace std;
int main()
{
    int arrA[6] = {4, 2, 3, 1, 5, 6};
    int arrB[6] = {3, 1, 4, 6, 5, 2};
    unordered_map<int, int> hashMap; // store element and index of arrB for order checking
    int n = sizeof(arrA) / sizeof(arrA[0]);
    for (int i = 0; i < n; i++)
    {
        hashMap[arrB[i]] = i;
    }
    int i = 0;
    int subsetLength = 0;
    while (i < n)
    {
        int j = i;
        int count = 0;
        while (j < n - 1)
        {
            if (hashMap[arrA[j]] < hashMap[arrA[j + 1]])
            {
                // the arrA[j] index in array b should be less than index of arrA[j+1] in array B// it maintains order
                count++;
            }
            else
            {
                break; // no need to find anything as sequence is broken down;
            }
            j++;
        }

        i = i + count + 1;
        subsetLength = max(subsetLength, count + 1); // as we are using hashmap[arrA[j]]<=hashMap[arrA[j+1]] so let say 3,2 occurs in order
        // 3, will check 2 in hashMap and length 1 and when 2 check order breaks so count will be 1 but effectively it is 2 as 3,2 both are there
    }
    cout << n - subsetLength;
    return 0;
}