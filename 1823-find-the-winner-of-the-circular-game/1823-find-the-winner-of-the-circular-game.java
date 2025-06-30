class Solution {
    public int findTheWinner(int n, int k) {
        int players = n;

        int[] arr = new int[n];
        for(int j = 0; j < n; j++) {
            arr[j] = j + 1;
        }

        Stack<Integer> stack = new Stack();
        
        int i = 0, result = 0;
        while(players >= 1) {
            if(arr[i] != -1) {
                stack.push(arr[i]);
                result = arr[i];
            }
            if(stack.size() == k) {
                stack = new Stack();
                arr[i] = -1;
                players--;
            }
            if(i == n - 1) {
                i = 0;
            }
            else {
                i++;
            }
        }
        // int result = 0;
        // for(int j = 0; j < n; j++) {
        //     if(arr[j] != -1) {
        //         result = arr[j];
        //     }
        // }

        return result;
    }
}

/*
n = 6 k = 5


a[0] = 1
a[1] = 2
.
.
.
a[5] = 6
players = 6;

int i = 0;
while(players > 1) { // 6 // 5 // 4 
    if(a[i] != -1) // // 
        stack.push(a[i]); // 1 2 3 4 5 // 6 1 2 3 4 // 6 1 2 3 6 // 1 2 3 1 2 // 3 1 3 1 3 // 1
    if(stack.size() == k) { 
        stack = new Stack(); // [] // [] // []
        a[i] == -1; // a[4] = -1; // a[3] = -1 // a[5] = -1
        players--; // 5 // 4
    }
    if(i == n - 1) { 4 == 5 // 5 == 5 // 3 == 5 // 5 == 5
        i = 0;
    }
    else { 
        i++; // 5 // 4
    }
}
*/