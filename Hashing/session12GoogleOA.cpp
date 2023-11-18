#include <iostream>
#include <unordered_map>
using namespace std;
int main()
{
    int n;
    cin >> n;

    int *a = new int[n + 1];
    int i = 1;
    while (i <= n)
    {
        cin >> a[i];
        i++;
    }

    int count = 0;
    i = 1;
    unordered_map<int, int> freq;
    while (i <= n)
    {
        int rhs = a[a[a[i]]];
        int g = freq[rhs];
        count += g;
        int lhs = a[a[a[i]]];
        freq[lhs]++;
        i++;
    }
    cout << count;
    return 0;
}