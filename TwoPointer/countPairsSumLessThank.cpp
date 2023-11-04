// C++ program to count pairs in an array
// whose sum is less than given number x
#include <iostream>
using namespace std;

// Function to count pairs in array
// with sum less than x.
int findPairs(int arr[], int n, int x)
{
    int l = 0, r = n - 1;
    int result = 0;

    while (l < r)
    {
        // If current left and current
        // right have sum smaller than x,
        // the all elements from l+1 to r
        // form a pair with current l.
        if (arr[l] + arr[r] < x)
        {
            result += (r - l);
            l++;
        }

        // Move to smaller value
        else
            r--;
    }

    return result;
}

// Driven code
int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int n = sizeof(arr) / sizeof(int);
    int x = 7;
    cout << findPairs(arr, n, x);
    return 0;
}
