public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int y = -1, x = 0;
        while (num <= n * n) {
            for (y++; y < n; y++) {
                if (result[x][y] != 0) {
                    break;
                }
                result[x][y] = num++;
            }
            y--;
            for (x++; x < n; x++) {
                if (result[x][y] != 0) {
                    break;
                }
                result[x][y] = num++;
            }
            x--;
            for (y--; y >= 0; y--) {
                if (result[x][y] != 0) {
                    break;
                }
                result[x][y] = num++;
            }
            y++;
            for (x--; x >= 0; x--) {
                if (result[x][y] != 0) {
                    break;
                }
                result[x][y] = num++;
            }
            x++;
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateMatrix test = new GenerateMatrix();
        int[][] result = test.generateMatrix(3);
        System.out.println(result);
    }
}
