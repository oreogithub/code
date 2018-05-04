package code.leetcode.easy.array;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int l = matrix.length;
		for (int i = 0; i < l; i++) {
			for (int j = i; j < l; j++) {
				matrix[i][j] ^= matrix[j][i];
				matrix[j][i] ^= matrix[i][j];
				matrix[i][j] ^= matrix[j][i];
			}
		}
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l / 2; j++) {
				matrix[i][l - j - 1] ^= matrix[i][j];
				matrix[i][j] ^= matrix[i][l - j - 1];
				matrix[i][l - j - 1] ^= matrix[i][j];
			}
		}
	}
}
