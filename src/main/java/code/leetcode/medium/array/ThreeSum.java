package code.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		// threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		threeSum2(new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 });
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return list;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			Integer v = map.get(i);
			map.put(i, v == null ? 1 : ++v);
		}
		Set<String> unique = new HashSet<String>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int key = -(nums[i] + nums[j]);
				if (map.containsKey(key)) {
					if ((key == nums[j] || key == nums[i]) && map.get(key) != 2)
						continue;
					int[] arrays = new int[] { nums[i], nums[j], key };
					Arrays.sort(arrays);
					String key2 = Arrays.toString(arrays);
					if (unique.contains(key2))
						continue;
					List<Integer> list2 = new ArrayList<Integer>();
					list2.add(nums[i]);
					list2.add(nums[j]);
					list2.add(key);
					list.add(list2);
					unique.add(key2);
				}
			}
		}

		return list;
	}

	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return list;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					List<Integer> list2 = new ArrayList<Integer>();
					list2.add(nums[i]);
					list2.add(nums[left]);
					list2.add(nums[right]);
					list.add(list2);
					right--;
					left++;
				} else if (sum > 0)
					right--;
				else if (sum < 0)
					left++;
				while (left < right && left - 1 != i && nums[left] == nums[left - 1])
					left++;
				while (left < right && right != nums.length - 1 && nums[right] == nums[right + 1])
					right--;
			}
		}
		return list;
	}
}
