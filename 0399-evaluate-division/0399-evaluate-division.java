class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);

            double quotient = values[i];

            if (!graph.containsKey(dividend)) {
                graph.put(dividend, new HashMap<String, Double>());
            }
            if (!graph.containsKey(divisor)) {
                graph.put(divisor, new HashMap<String, Double>());
            }

            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
            }

            else if (divisor == dividend) {
                results[i] = 1.0;
            }

            else {
                HashSet<String> visited = new HashSet<>();
                results[i] = backtracking(graph, dividend, divisor, 1.0, visited);
            }
        }

        return results;
    }

    private double backtracking(Map<String, Map<String, Double>> graph, String curr, String target,
            Double accProduct, HashSet<String> visited) {
        visited.add(curr);
        double ret = -1.0;

        Map<String, Double> neighbors = graph.get(curr);

        if (neighbors.containsKey(target)) {
            ret = accProduct * neighbors.get(target);
        } else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nxt = pair.getKey();
                if (visited.contains(nxt)) {
                    continue;
                }
                ret = backtracking(graph, nxt, target, accProduct * pair.getValue(), visited);
                if (ret != -1.0) {
                    break;
                }
            }
        }

            visited.remove(curr);
            return ret;
    }
}