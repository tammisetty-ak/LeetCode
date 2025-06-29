class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> rem0 = new ArrayList();
        List<Integer> rem1 = new ArrayList();
        List<Integer> rem2 = new ArrayList();

        int sum = 0;

        for(int num: nums) {
            sum += num;
            if(num % 3 == 0) {
                rem0.add(num);
            }
            else if(num % 3 == 1) {
                rem1.add(num);
            }
            else {
                rem2.add(num);
            }
        }

        Collections.sort(rem1);
        Collections.sort(rem2);

        if(sum % 3 == 0) {
            return sum;
        }
        
        int result = 0; 
        if(sum % 3 == 1) {
            int op1 = rem1.size() > 0 ? sum - rem1.get(0): 0;
            int op2 = rem2.size() > 1 ? sum - rem2.get(0) - rem2.get(1) : 0;
            result = Math.max(op1, op2);
        }
        else {
            int op1 = rem2.size() > 0 ? sum - rem2.get(0) : 0;
            int op2 = rem1.size() > 1 ? sum - rem1.get(0) - rem1.get(1) : 0;
            result = Math.max(op1, op2);
        }

        return result;
    }
}