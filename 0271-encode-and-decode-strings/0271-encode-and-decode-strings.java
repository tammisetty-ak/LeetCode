public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for(String str: strs) { 
            res.append(str.length()).append(":").append(str);
        }

        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;

        List<String> res = new ArrayList();

        while(i < s.length()) {
            int colIndex = s.indexOf(":", i);
            
            int length = Integer.parseInt(s.substring(i, colIndex));

            i = colIndex + 1;

            res.add(s.substring(i, i + length));

            i += length;
        }

        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));