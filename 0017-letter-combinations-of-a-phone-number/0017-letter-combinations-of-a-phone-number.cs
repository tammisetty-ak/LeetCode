public class Solution {
    private Dictionary<int, string> button = new Dictionary<int, string>();

    private List<string> res = new List<string>();

    private string phoneDigits;

    public IList<string> LetterCombinations(string digits) {
        if(digits.Length == 0) {
            return res;
        }

        button[2] = "abc";
        button[3] = "def";
        button[4] = "ghi";
        button[5] = "jkl";
        button[6] = "mno";
        button[7] = "pqrs";
        button[8] = "tuv";
        button[9] = "wxyz";

        phoneDigits = digits;

        Backtrack(0, new StringBuilder());

        return res;
    }

    private void Backtrack(int index, StringBuilder currString) {
        if(index == phoneDigits.Length) {
            res.Add(currString.ToString());
            return;
        }

        string letters = button[phoneDigits[index] - '0'];

        foreach(char letter in letters) {
            currString.Append(letter);
            Backtrack(index + 1, currString);
            currString.Remove(currString.Length - 1, 1);
        }
    }
}