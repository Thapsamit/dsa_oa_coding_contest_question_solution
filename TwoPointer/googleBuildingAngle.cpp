#include <iostream>
using namespace std;
int main()
{

    int arr[7] = {1, 2, 1, 0, 1, 1, 0};

    int i = 0;
    int j = 0;
    int n = sizeof(arr) / sizeof(arr[0]);
    int sum = arr[0]; // taking first in sum
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
            // either the element is greater k, so we need to move both point
            if (arr[j] > k)
            {
                i++;
                j++;
                if (i <= n)
                {
                    sum += arr[i]; // we are now considering the next element  let say we have 10,5 and we were at 10 and we have  k = 6 then we can't consider that 10 so we are moving pointer and consider the sum of next element
                }
            }
            else
            {
                // else we will just increment k pointer only
                answer = max(answer, 1); // as only one length is there
                j++;
                if (j <= n)
                {
                    sum += arr[j];
                }
            }
        }
        else
        {
            // if sum > k , we actually need to remove from left side till we have sum>k, and longest possible was [i,...j-1] till this time
            if (sum > k)
            {
                start = i;
                end = j - 1;
                int l = abs(start - end) + 1;
                answer = max(answer, l);
                sum = sum - arr[i];
                i++;
                sum = sum - arr[j]; // because the element which makes it greater is added into it
                j++;
                if (i > j)
                {
                    j = i; // corner case
                }
            }
            else
            {
                answer = max(answer, abs(i - j) + 1);
                j++;
                if (j <= n)
                {
                    sum = sum + arr[j]; // adding next element
                }
            }
        }
    }
    cout << "Longest length" << longestSubArrayCount;

    return 0;
}