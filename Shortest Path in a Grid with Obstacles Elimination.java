class Solution {
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		// store the remaining chance and the minimal step at the current location
        int[][] remain = new int[m][n];
        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, k, 0});
        int level = 0;
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[3] >= visited[cur[0]][cur[1]] && cur[2] <= remain[cur[0]][cur[1]] || cur[3] >= res) continue;
                visited[cur[0]][cur[1]] = cur[3];
                remain[cur[0]][cur[1]] = cur[2];
                if (cur[0] == m - 1 && cur[1] == n - 1 && cur[2] >= grid[m - 1][n - 1]) {
                    res = Math.min(res, cur[3]);
                    continue;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (cur[2] - grid[x][y] >= 0) {
                            queue.offer(new int[]{x, y, cur[2] - grid[x][y], level});
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
