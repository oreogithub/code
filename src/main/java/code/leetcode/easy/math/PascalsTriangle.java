package code.leetcode.easy.math;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return list;
		list.add(new ArrayList<Integer>() {
			{
				this.add(1);
			}
		});
		for (int i = 1; i < numRows; i++) {
			List<Integer> preRow = list.get(i - 1);
			List<Integer> curRow = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				curRow.add(get(preRow, j));
			}
			list.add(curRow);
		}
		return list;
	}

	private int get(List<Integer> preRow, int index) {
		if (index == 0)
			return preRow.get(0);
		else if (preRow.size() <= index)
			return preRow.get(preRow.size() - 1);
		else
			return preRow.get(index) + preRow.get(index - 1);
	}

}
