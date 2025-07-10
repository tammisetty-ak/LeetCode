class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));

        int min = points[0][1];
        int count = 1;
        for(int i = 1; i < points.length; i++) {
            if(min >= points[i][0]) {
                min = Math.min(points[i][1], min);
            }
            else{
                count++;
                min = points[i][1];
            }
        }
        return count;
    }
}

/*

12 34 56 78

m - 2
2>=3
m - 4 c - 2
4>=5
m - 5 c - 3
5>=7
m - 8 c - 4

12 23 34 45
m - 2
2>=2
m - 2 c - 1

2>= 3
m - 4 c - 2

4 >= 4
m - 4 c - 2

10 16 2 8 1 6 7 12

1 6, 2 8, 7 12, 10 16

min - 6

min >= 2
min = math.min(6, 8)

min = 6
6 >= 7

min= 12

12 >= 10
min = 10
*/