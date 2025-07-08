class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();

                if (Math.abs(top) < Math.abs(asteroid)) {
                    stack.pop(); // smaller one explodes
                    // continue loop
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    stack.pop(); // both explode
                    alive = false;
                    break;
                } else {
                    alive = false; // current asteroid explodes
                    break;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
