class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int total = n + m;
        int r1 = n - 1;
        int l2 = 0;

        while (r1 >= 0 && l2 < m) {
            if (arr1[r1] > arr2[l2]) {
                int temp = arr1[r1];
                arr1[r1] = arr2[l2];
                arr2[l2] = temp;
                r1--;
            } else {
                l2++;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] resArr = new int[total];

        for (int i = 0; i < n; i++) {
            resArr[i] = arr1[i];
        }

        for (int i = 0; i < m; i++) {
            resArr[i + n] = arr2[i];
        }

        if (total % 2 == 1) {
            return (double) resArr[total / 2];
        } else {
            int sol1 = total / 2;
            int sol2 = sol1 - 1;
            double res = (double) (resArr[sol1] + resArr[sol2]) / 2;
            return res;
        }
    }
}
