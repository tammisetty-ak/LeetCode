public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str);
            sb.append('ß');
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList();

        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'ß') {
                int end = i;
                res.add(s.substring(start, end));
                start = end + 1;
            }
        }

        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));