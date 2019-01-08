package leetcode;

public class No200_孤岛个数 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length; // 行
        int col = grid[0].length; // 列

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    combine(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void combine(char[][] grid, int x, int y) {
        grid[x][y] = '2';
        int row = grid.length; // 行
        int col = grid[0].length; // 列

        if (x > row - 1 && y > col - 1)
            return;
        // 向下
        if (x < row - 1 && grid[x + 1][y] == '1')
            combine(grid, x + 1, y);
        //向右
        if (y < col - 1 && grid[x][y + 1] == '1')
            combine(grid, x, y + 1);
        //向上
        if (x > 0 && grid[x - 1][y] == '1')
            combine(grid, x - 1, y);
        //向左
        if (y > 0 && grid[x][y - 1] == '1')
            combine(grid, x, y - 1);
    }


}
