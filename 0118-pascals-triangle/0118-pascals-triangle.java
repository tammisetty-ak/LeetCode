class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();

        triangle.add(new ArrayList());
        triangle.get(0).add(1);

        for(int row = 1; row < numRows; row++) {
            List<Integer> prevRow = triangle.get(row - 1);
            List<Integer> res = new ArrayList();
            res.add(1);

            for(int j = 1; j < row; j++) {
                res.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            res.add(1);
            triangle.add(res);
        }

        return triangle;
    }
}