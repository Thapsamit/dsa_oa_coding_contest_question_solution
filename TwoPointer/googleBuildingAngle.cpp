#include <iostream>
using namespace std;
int main()
{

    int arr[7] = {1, 2, 1, 0, 1, 1, 0};

    int i = 0;
    int j = 0;
    int n = sizeof(arr) / sizeof(arr[0]);
    int diff = 0; // taking first in sum
    int k = 4;
    int longestSubArrayCount = 0;
    int start = 0;
    int end = 0;
    int answer = 0;
    while (i < n && j < n)
    {
        // if both i and j are equal
        if (i == j)
        {
            diff = 0; // as both are same index so difference is 0
                      // either the element is greater k, so we need to move both point
            if (diff > k)
            {
                // this if condition not necessary to write but still we can write it
                i++;
                j++;
                if (i <= n)
                {
                    diff = arr[j] - arr[i]; // we are now considering the next element  let say we have 10,5 and we were at 10 and we have  k = 6 then we can't consider that 10 so we are moving pointer and consider the sum of next element
                }
            }
            else
            {
                // else we will just increment k pointer only
                answer = max(answer, 1); // as only one length is there
                j++;
                if (j <= n)
                {
                    diff = arr[j] - arr[i];
                }
            }
        }
        else
        {
            diff = arr[j] - arr[i];
            if (diff > k)
            {
                // if d[1..j]>k
                // we know that d[1...j-1]<=k
                // no need to visit this subbaray
                // we have longest one is d[1..j-1]
                start = i;
                end = j - 1;
                int l = abs(start - end) + 1;
                answer = max(answer, l);
                i++;
                j--;
                diff = arr[j] - arr[i]; // caclulate new diff
                if (i > j)
                {
                    j = i; // corner case
                }
            }
            else
            {
                start = i;
                end = j;
                int l = abs(start - end) + 1;
                answer = max(answer, l);
                if (j <= n)
                {
                    diff = arr[j] - arr[i]; // adding next element
                }
            }
        }
    }
    cout << "Longest length" << longestSubArrayCount;

    return 0;
}