package code.leetcode.easy.other;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {

	private Map<Byte, Byte> map = new HashMap<Byte, Byte>();

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		byte[] bytes = new byte[4];
		for (int i = 0; i < 4; i++)
			bytes[i] = (byte) ((i >>> 8 * i) & 0xFF);
		return Integer.reverse(n);
	}
}
