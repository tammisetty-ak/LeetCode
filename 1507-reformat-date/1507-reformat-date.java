class Solution {
    public String reformatDate(String date) {
        String[] tokens = date.split(" ");
        String day;

        if (Character.isDigit(tokens[0].charAt(1))) {
            day = tokens[0].substring(0, 2);
        } else {
            day = "0";
            day = day.concat(String.valueOf(tokens[0].charAt(0)));

        }

        Map<String, String> monthsMap = new HashMap<>();
        monthsMap.put("Jan", "01");
        monthsMap.put("Feb", "02");
        monthsMap.put("Mar", "03");
        monthsMap.put("Apr", "04");
        monthsMap.put("May", "05");
        monthsMap.put("Jun", "06");
        monthsMap.put("Jul", "07");
        monthsMap.put("Aug", "08");
        monthsMap.put("Sep", "09");
        monthsMap.put("Oct", "10");
        monthsMap.put("Nov", "11");
        monthsMap.put("Dec", "12");

        StringBuilder res = new StringBuilder();

        return res.append(tokens[2]).append("-").append(monthsMap.get(tokens[1])).append("-")
                .append(day).toString();
    }
}