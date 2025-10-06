import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0}); 
        
        int time = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0], x = curr[1], y = curr[2];
            time = Math.max(time, h); 
            
            if (x == n-1 && y == n-1) return time; 
            
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        return time;
    }
}
