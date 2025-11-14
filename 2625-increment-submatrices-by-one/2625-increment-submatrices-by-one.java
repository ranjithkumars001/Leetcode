class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        // Step 1: Query boundary marking
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            diff[r1][c1] += 1;
            if (c2 + 1 < n) diff[r1][c2 + 1] -= 1;
            if (r2 + 1 < n) diff[r2 + 1][c1] -= 1;
            if (r2 + 1 < n && c2 + 1 < n) diff[r2 + 1][c2 + 1] += 1;
        }

        int[][] result = new int[n][n];

        // Step 2: Row-wise prefix sum
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += diff[i][j];
                result[i][j] = sum;
            }
        }

        // Step 3: Column-wise prefix sum
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += result[i][j];
                result[i][j] = sum;
            }
        }

        return result;
    }
}
