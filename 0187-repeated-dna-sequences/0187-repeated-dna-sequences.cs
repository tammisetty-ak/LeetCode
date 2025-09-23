public class Solution {
    public IList<string> FindRepeatedDnaSequences(string s) {
        HashSet<string> set = new HashSet<string>();

        List<string> res = new List<string>();

        int index = 0;

        while(index + 10 <= s.Length) {
            string sub = s.Substring(index, 10);

            if(set.Contains(sub) && !res.Contains(sub)) {
                res.Add(sub);
            }
            else {
                set.Add(sub);
            }
            index++;
        }

        return res;
    }
}