class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> bag = new Stack<>();

        for (int i = 0; i < n; i++) {
            int curr = temperatures[i];
            while (!bag.isEmpty() && temperatures[bag.peek()] < curr) {
                int prevIdx = bag.pop();
                result[prevIdx] = i - prevIdx;
            }
            bag.push(i);
        }

        return result;
    }
    }

