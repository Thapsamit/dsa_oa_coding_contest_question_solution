#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<vector<int>> lamps = {{1, 7}, {5, 11}, {7, 9}};
    vector<int> points = {7, 1, 5, 10, 9, 15};
    vector<int> ans(1000, 0);
    int pref_sum = 0;
    for (int i = 0; i < lamps.size(); i++)
    {
        // marking queries
        int l = lamps[i][0];
        int r = lamps[i][1];
        ans[l] = ans[l] + 1;
        ans[r + 1] = ans[r + 1] - 1;
    }
    for (int i = 0; i < ans.size(); i++)
    {
        pref_sum += ans[i];
        ans[i] = pref_sum;
    }
    for (int j = 0; j < points.size(); j++)
    {
        cout << ans[points[j]] << " ";
    }

    return 0;
}