package code.lintcode.stack;

public class MinStack {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(1);
		stack.pop();
		stack.push(2);
		stack.push(3);
		stack.min();
		stack.push(1);
		stack.min();
	}

	private int[] queue = new int[10];
	private int[] minQueue = new int[10];
	private int counter = 0;

	public MinStack() {
	}

	/*
	 * @param number: An integer
	 * 
	 * @return: nothing
	 */
	public void push(int number) {
		queue[counter] = number;
		int min = number;
		if (counter != 0) {
			min = Math.min(this.min(), min);
		}
		minQueue[counter++] = min;
	}

	/*
	 * @return: An integer
	 */
	public int pop() {
		return queue[--counter];
	}

	/*
	 * @return: An integer
	 */
	public int min() {
		return minQueue[counter];
	}
}
