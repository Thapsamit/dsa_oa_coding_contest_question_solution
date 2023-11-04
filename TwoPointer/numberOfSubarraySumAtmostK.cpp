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
    int count = 0;
    int gg = 0;
    // for each index i you need to find largest j such that i to j <=k
    // once find we know that total (j-i)+1 subarray start frm index i such that their sum<=k
    // sum[i..i]<=k also sum[i...i+1]<=k, also sum[i...i+2]<=k
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
                count += 1;
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
                count += l; // we got l as number of subarray
                sum = sum - arr[i];
                i++;
                sum = sum - arr[j]; // because the element which makes it greater is added into it
                j--;
                if (i > j)
                {
                    j = i; // corner case if i crosses j due to the fact that arr[j] may be so large, that it may allow i to go beoynd j so we needto reinitaialize to j so that we can consider after that
                }
            }
            else
            {
                j++;
                if (j <= n)
                {
                    sum = sum + arr[j]; // adding next element
                }
                // but we need to keep track of last s[i...j] such that  j = N and s[i...j]<=k, as the last one if <=k it won't get the chance to cacluate its subarray
                if (j == n)
                {
                    // j at last
                    int gg = i;
                }
            }
        }
    }
    if (gg >= 1)
    {
        int s = gg;
        int e = n - 1;
        int l = abs(s - e) + 1;
        count += l;
    }
    cout << "Longest length" << count;

    return 0;
}