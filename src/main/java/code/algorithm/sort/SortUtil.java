package code.algorithm.sort;

public class SortUtil {

	public static <T extends Comparable<? super T>> void insertSort(T[] input) {

	}

	public static void insertSort(int[] nums) {
		int j;
		for (int i = 1; i < nums.length; i++) {
			int cur = nums[i];
			for (j = i; j > 0 && cur < nums[j - 1]; j--) {
				nums[j] = nums[j - 1];
			}
			nums[j] = cur;
		}
	}

	public static void shellSort(int[] nums) {
		int j;
		for (int gap = nums.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < nums.length; i++) {
				int cur = nums[i];
				for (j = i; j >= gap && cur < nums[j - gap]; j -= gap) {
					nums[j] = nums[j - gap];
				}
				nums[j] = cur;
			}
		}
	}

	public static void main(String[] args) {
		// int[] input = { 9, 3, 2, 4, 8 };
		int[] input = { 1, 2, 3, 4, 5, 6, 8, 9, 10, 7 };
		// insertSort(input);
		shellSort(input);
	}
}
