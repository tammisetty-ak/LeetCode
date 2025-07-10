class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
       String start1 = event1[0];
       String start2 = event2[0];
       String end1 = event1[1];
       String end2 = event2[1];


       return !(end1.compareTo(start2) < 0 || end2.compareTo(start1) < 0);
    }
}