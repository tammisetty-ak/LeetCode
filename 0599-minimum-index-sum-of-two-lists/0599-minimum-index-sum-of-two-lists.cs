public class Solution {
    public string[] FindRestaurant(string[] list1, string[] list2) {
        Dictionary<string, int> map = new Dictionary<string, int>();
        SortedDictionary<int, List<string>> sortedMap = new SortedDictionary<int, List<string>>();

        int index = 0;

        foreach(string str in list1) {
            map[str] = index++;
        }

        for(int i = 0; i < list2.Length; i++) {
            if(map.ContainsKey(list2[i])) {
                int sum = i + map[list2[i]];
                if(!sortedMap.ContainsKey(sum)) {
                    sortedMap[sum] = new List<string>();
                }
                List<string> strs = sortedMap[sum];
                strs.Add(list2[i]);
                sortedMap[sum] = strs;
            }
        }
        List<string> sols = sortedMap[sortedMap.Keys.First()];

        string[] res = new string[sols.Count];


        for(int i = 0; i < res.Length; i++) {
            res[i] = sols[i];
        }

        return res;
    }
}