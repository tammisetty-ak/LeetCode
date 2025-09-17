class Solution {

    private final Map<Integer, String> map;

    private ArrayList<String> res = new ArrayList<>();

    public Solution(){
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    private void backtrack(int index, StringBuilder currString, String digits){ // (0, "", 23) // (1, "a", 23) // (2, "ad", 23)
        if(index == digits.length()){ // ( 0 == 2 ) // (1 == 2) // (2 == 2)
            res.add(currString.toString()); // - ad - ae - af
            return;
        }

        // for(int i = index; i < digits.length(); i++){ // i - 0 // i - 1 // i - 1 // i - 1 // i - 1
            String intToDigits = map.get(Integer.parseInt(String.valueOf(digits.charAt(index)))); // iD - abc // iD - def
            // a b c
            for(int j = 0; j < intToDigits.length(); j++){ // j - 0 // j - 0 // j - 1
            // d e f
                // System.out.println(intToDigits.charAt(j));
                currString.append(intToDigits.charAt(j)); // c - a // c - ad // c - ae
                backtrack(index + 1, currString, digits); // (1, "a", 23) // (2, "ad", 23) // (2, "ae", 23) // (2, "af", 23)
                currString.deleteCharAt(currString.length() - 1); // c - a // c- a // c - a
            }
        // }

    }

    public List<String> letterCombinations(String digits) { // 23

        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        else{
            backtrack(0, new StringBuilder(), digits); // (0, "", 23)
            return res;    
        }
    }
}

/*


23

2 -> abc

                abc
        /        |      \
        a        b       c
      / | \    / | \     / | \
     d  e  f. d. e. f.   d e f
     ad ae af db de df cd ce cf
3 -> def 
*/