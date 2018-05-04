package code.leetcode.medium.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetZeroes {

	public static void main(String[] args) {
		setZeroes(new int[][] { { 0 }, { 1 } });
	}

	public static void setZeroes(int[][] matrix) {
		List<Coordinate> list = new ArrayList<SetZeroes.Coordinate>(matrix.length);
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				if (matrix[i][j] == 0)
					list.add(new Coordinate(i, j));
		for (Iterator<Coordinate> iterator = list.iterator(); iterator.hasNext();) {
			Coordinate c = iterator.next();
			for (int i = 0; i < matrix[c.x].length; i++) {
				matrix[c.x][i] = 0;
			}
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][c.y] = 0;
			}
		}
	}

	private static class Coordinate {
		int x, y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void setZeroes2(int[][] matrix) {
		Set<Integer> s = new HashSet<Integer>(matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			boolean isRowZero = false;
			for (int j = 0; j < matrix[i].length; j++)
				if (matrix[i][j] == 0) {
					s.add(j);
					isRowZero = true;
				}
			if (isRowZero)
				for (int j = 0; j < matrix[i].length; j++)
					matrix[i][j] = 0;
		}
		for (Integer col : s)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][col] = 0;
	}
}
