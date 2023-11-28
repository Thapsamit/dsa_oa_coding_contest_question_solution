#include <iostream>
#include <vector>
using namespace std;
int main()
{
    string str = "abcaab";
    int n = str.length();

    vector<vector<int>> freq(26, vector<int>(n, 0));

    for (int i = 0; i < 26; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int e = str[j] - 'a';
            if (j > 0)
            {
                freq[i][j] = (i == e) ? freq[i][j - 1] + 1 : freq[i][j - 1];
            }
            else
            {
                freq[i][j] = (i == e) ? 1 : 0;
            }
        }
    }

    for (int i = 0; i < 26; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << freq[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}