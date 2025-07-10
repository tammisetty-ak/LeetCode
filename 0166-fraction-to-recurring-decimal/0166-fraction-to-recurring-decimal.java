class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }

        long divisor = Long.valueOf(numerator);
        long dividend = Long.valueOf(denominator);

        StringBuilder res = new StringBuilder();

        res.append(divisor / dividend);

        long remainder = divisor % dividend;

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
            remainder *= 10;
            res.append(remainder / dividend);
            remainder %= dividend;
        }

        return res.toString();
    }
}