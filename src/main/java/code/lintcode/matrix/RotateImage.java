package code.lintcode.matrix;

public class RotateImage {

	public static void main(String[] args) {
		// int[][] matrix = { { 1, 2 }, { 3, 4 } };
		// int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
		// 14, 15, 16 } };
		/*
		 * int[][] matrix = { { 2, 29, 20, 26, 16, 28 }, { 12, 27, 9, 25, 13, 21 }, {
		 * 32, 33, 32, 2, 28, 14 }, { 13, 14, 32, 27, 22, 26 }, { 33, 1, 20, 7, 21, 7 },
		 * { 4, 24, 1, 6, 32, 34 } };
		 */
		int[][] matrix = { { 24, 4, 38, 2, 21, 18, 33, 40 }, { 24, 37, 25, 62, 37, 15, 35, 36 },
				{ 42, 23, 13, 58, 17, 26, 19, 8 }, { 32, 48, 9, 58, 36, 18, 40, 61 }, { 23, 16, 0, 46, 35, 34, 23, 60 },
				{ 9, 49, 60, 47, 1, 32, 20, 45 }, { 56, 34, 40, 11, 61, 60, 20, 30 },
				{ 45, 30, 25, 18, 49, 3, 16, 10 } };
		rotate(matrix);
		System.out.println("last:");
		printMatrix(matrix);
	}

	public static void rotate(int[][] matrix) {
		int length = matrix.length;
		for (int x = 0; x < length; x++) {
			for (int y = x; y < length; y++) {
				int temp = matrix[x][y];
				matrix[x][y] = matrix[y][x];
				matrix[y][x] = temp;
			}
		}
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length / 2; y++) {
				int temp = matrix[x][y];
				matrix[x][y] = matrix[x][length - y - 1];
				matrix[x][length - y - 1] = temp;
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
