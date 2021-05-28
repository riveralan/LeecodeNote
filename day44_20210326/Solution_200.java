package LeecodeNote.day44_20210326;

public class Solution_200 {
    private int maxRow = 0;
    private int maxCol = 0;

    /**
     * 1. 发现岛屿-岛屿命名
     * <p>
     * 2. 拓展岛屿
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        maxRow = grid.length;
        maxCol = grid[0].length;
        int islandCount = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == '0') {
                    continue;
                }
                if (grid[row][col] == '1') {
                    islandCount++;
                    dfs(grid, row, col);
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        if (checkArea(row - 1, col) && grid[row - 1][col] == '1') {

            dfs(grid, row - 1, col);
        }
        if (checkArea(row + 1, col) && grid[row + 1][col] == '1') {
            dfs(grid, row + 1, col);
        }
        if (checkArea(row, col - 1) && grid[row][col - 1] == '1') {
            dfs(grid, row, col - 1);
        }
        if (checkArea(row, col + 1) && grid[row][col + 1] == '1') {
            dfs(grid, row, col + 1);
        }
    }

    private boolean checkArea(int row, int col) {
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        Solution_200 solution_200 = new Solution_200();
        int result = solution_200.numIslands(grid);
        System.out.println(result);
    }
}
