package temp;

public class ShortestPath {
	public static int shortestPath(int[][] path) {
		int m = path.length;
		int n = path[0].length;
		//最小路径和
		int[][] dp = new int[m][n];
		dp[0][0] = path[0][0];
		//处理边界值
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + path[i][0];
		}
		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1] + path[0][j];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + path[i][j];
			}
		}
		return dp[m -1][n - 1];
	}

	public static void main(String[] args) {
		int[][] path = {{2, 1, 1, 1, 5}, {1, 3, 1, 4, 9}, {9, 1, 3, 2, 2}};
		int result = shortestPath(path);
		System.out.println(result);
	}
}

