class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            else if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            }
            else {
                System.out.println(s.charAt(left));
                System.out.println(s.charAt(right));
                return false;
            }
                
            }

            return true;
        }
    }