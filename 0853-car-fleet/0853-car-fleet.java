class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];

        for(int i = 0; i < N; i++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        } 

        Arrays.sort(cars, (a,b) -> {
            return a.position - b.position;
        });

        int ans = 0, t = N;

        while(--t > 0) {
            if(cars[t-1].time > cars[t].time) {
                ans++;
            }

            else {
                cars[t-1] = cars[t];
            }
        }

        return ans + (t == 0 ? 1 : 0);
    }

    public class Car {
        int position;
        double time;

        public Car(int p, double t) {
            position = p;
            time = t;
        }
    }
}