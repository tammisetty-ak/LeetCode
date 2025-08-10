class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        if(numerator < 0 ^ denominator < 0) {
            res.append("-");
        }

        Long dividend = Math.abs(Long.valueOf(numerator));
        Long divisor = Math.abs(Long.valueOf(denominator));

        res.append(String.valueOf(dividend / divisor));

        Long remainder = dividend % divisor;

        if(remainder == 0) {
            return res.toString();
        }

        res.append(".");

        Map<Long, Integer> map = new HashMap();

        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                res.insert(map.get(remainder), "(");
                res.append(")");
                break;
            }
            map.put(remainder, res.length());
            remainder = remainder * 10;
            res.append(remainder / divisor);
            remainder = remainder % divisor;
        }
        return res.toString();
    }
}