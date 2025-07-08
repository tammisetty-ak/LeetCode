class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        Map<Integer, String> map = Map.ofEntries(
                Map.entry(0, "Zero"),
                Map.entry(1, "One"),
                Map.entry(2, "Two"),
                Map.entry(3, "Three"),
                Map.entry(4, "Four"),
                Map.entry(5, "Five"),
                Map.entry(6, "Six"),
                Map.entry(7, "Seven"),
                Map.entry(8, "Eight"),
                Map.entry(9, "Nine"),
                Map.entry(10, "Ten"),
                Map.entry(11, "Eleven"),
                Map.entry(12, "Twelve"),
                Map.entry(13, "Thirteen"),
                Map.entry(14, "Fourteen"),
                Map.entry(15, "Fifteen"),
                Map.entry(16, "Sixteen"),
                Map.entry(17, "Seventeen"),
                Map.entry(18, "Eighteen"),
                Map.entry(19, "Nineteen"),
                Map.entry(20, "Twenty"),
                Map.entry(30, "Thirty"),
                Map.entry(40, "Forty"),
                Map.entry(50, "Fifty"),
                Map.entry(60, "Sixty"),
                Map.entry(70, "Seventy"),
                Map.entry(80, "Eighty"),
                Map.entry(90, "Ninety"),
                Map.entry(100, "Hundred"),
                Map.entry(1000, "Thousand"),
                Map.entry(1000000, "Million"),
                Map.entry(1000000000, "Billion"));
        int groupIndex = 0;

        StringBuilder res = new StringBuilder();
        String[] scale = { "", "Thousand", "Million", "Billion" };

        while (num > 0) {
            if (num % 1000 != 0) {
                int part = num % 1000;
                StringBuilder groupVal = new StringBuilder();

                if (part >= 100) {
                    groupVal.append(map.get(part / 100)).append(" Hundred ");
                    part = part % 100;
                }

                if (part >= 20) {
                    groupVal.append(map.get((part / 10) * 10)).append(" ");
                    part = part % 10;
                }


                if (part > 0) {
                    groupVal.append(map.get(part)).append(" ");
                }
                groupVal.append(scale[groupIndex]).append(" ");

                res.insert(0, groupVal);
            }
            num = num / 1000;
            groupIndex++;
        }
        return res.toString().trim();
    }
}
/*

12345

5 1234 1
4 123 2
3 12 3
2 1 4
1 0 5



1 2 3 -> 10
4 5 6 -> 100
7 8 9 -> 1000

12345678
twelve million three hundered fourty five thousand six hundered seventy eight

*/