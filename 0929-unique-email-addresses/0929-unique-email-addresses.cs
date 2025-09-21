public class Solution {
    public int NumUniqueEmails(string[] emails) {
        var result = new HashSet<string>();

        foreach(string email in emails) {
            StringBuilder cleanmail = new StringBuilder();

            for(int i = 0; i < email.Length; i++) {
                char c = email[i];

                if(c == '@' || c == '+') {
                    break;
                }

                if(c != '.') {
                    cleanmail.Append(c);
                }
            }

            string domain = email.Substring(email.IndexOf('@'));


            result.Add(cleanmail.Append(domain).ToString());
        }

        return result.Count;
    }
}