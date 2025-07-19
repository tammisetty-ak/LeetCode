class Solution {
    public int kthGrammar(int n, int k) {
        int count = Integer.bitCount(k - 1);
        return count % 2 == 0 ? 0 : 1;
    }
}

/*


n - 2

0
01 k - 1-> 0

n - 4

0
01
0110
01101001
0110100110010110
01101001100101101001011001101001

0-0
1-1
2-1
3-0
4-1
5-0
6-0

*/