package code.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	// [[".","8","7","6","5","4","3","2","1"],
	// ["2",".",".",".",".",".",".",".","."],
	// ["3",".",".",".",".",".",".",".","."],
	// ["4",".",".",".",".",".",".",".","."],
	// ["5",".",".",".",".",".",".",".","."],
	// ["6",".",".",".",".",".",".",".","."],
	// ["7",".",".",".",".",".",".",".","."],
	// ["8",".",".",".",".",".",".",".","."],
	// ["9",".",".",".",".",".",".",".","."]]
	public static void main(String[] args) {
		char[][] board = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
				{ '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
				{ '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
				{ '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
		isValidSudoku(board);
	}

	public static boolean isValidSudoku(char[][] board) {
		Set<Character> rs = new HashSet<Character>(), cs = new HashSet<Character>(), bs = new HashSet<Character>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				char r = board[i][j], c = board[j][i];
				if ((r != '.' && rs.contains(r)) || (c != '.' && cs.contains(c)))
					return false;
				rs.add(r);
				cs.add(c);
				if (i % 3 == 0 && j % 3 == 0) {
					for (int k = i; k < i + 3; k++) {
						for (int m = j; m < j + 3; m++) {
							char b = board[k][m];
							if (b != '.' && bs.contains(b))
								return false;
							bs.add(b);
						}
					}
					bs.clear();
				}
			}
			rs.clear();
			cs.clear();
		}
		return true;
	}
}
