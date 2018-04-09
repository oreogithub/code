package code.lintcode.cache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache2 {

	private int capacity;
	private Map<Integer, Node> cache;
	private static NodeQueue tail = null;

	/*
	 * @param capacity: An integer
	 */
	public LFUCache2(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<Integer, LFUCache2.Node>(capacity);
	}

	/*
	 * @param key: An integer
	 * 
	 * @param value: An integer
	 * 
	 * @return: nothing
	 */
	public void set(int key, int value) {
		Node node = this.getNode(key);
		if (node == null) {
			if (this.cache.size() == this.capacity)
				this.cache.remove(removeTailNode().key);
			node = new Node(key, value);
		} else {
			node.val = value;
			pullUpNode(node);
			return;
		}
		NodeQueue nq = LFUCache2.tail;
		if (nq == null)
			LFUCache2.tail = nq = new NodeQueue(null, null, null, null);
		else if (nq.head.freq != node.freq)
			LFUCache2.tail = LFUCache2.tail.next = nq = new NodeQueue(null, nq, null, null);
		nq.addNode(node);
		this.cache.put(key, node);
	}

	/*
	 * @param key: An integer
	 * 
	 * @return: An integer
	 */
	public int get(int key) {
		Node n;
		return (n = getNode(key)) == null ? -1 : n.val;
	}

	private Node getNode(int key) {
		Node node = this.cache.get(key);
		if (node != null)
			pullUpNode(node);
		return node;
	}

	private Node removeTailNode() {
		NodeQueue q;
		return (q = LFUCache2.tail) == null ? null : q.removeNode(q.tail);
	}

	private void pullUpNode(Node node) {
		if (node == null)
			return;
		node.freq++;
		NodeQueue cq = node.currQueue;
		if (cq != null) {
			boolean isSingle = cq.tail == cq.head;
			NodeQueue pq = cq.pre;
			// top
			if (pq == null) {
				if (!isSingle) {
					pq = new NodeQueue(cq, null, null, null);
					pq.addNode(cq.removeNode(node));
					cq.pre = pq;
				}
			} else {
				if (pq.head.freq == node.freq)
					pq.addNode(cq.removeNode(node));
				else {
					if (!isSingle) {
						NodeQueue temp = new NodeQueue(cq, pq, null, null);
						temp.addNode(cq.removeNode(node));
						cq.pre = temp;
						pq.next = temp;
					}
				}
			}
		}
	}

	static class Node {
		Node next, pre;
		NodeQueue currQueue;
		int key, val, freq = 1;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	static class NodeQueue {
		Node head, tail;
		NodeQueue next, pre;

		public NodeQueue(NodeQueue next, NodeQueue pre, Node head, Node tail) {
			this.next = next;
			this.pre = pre;
			this.head = head;
			this.tail = tail;
		}

		public void addNode(Node node) {
			node.currQueue = this;
			if (this.head == null) {
				this.head = this.tail = node;
				return;
			}
			node.next = this.head;
			this.head.pre = node;
			this.head = node;
		}

		public Node removeNode(Node node) {
			if (node == null)
				return node;
			if (this.tail == this.head) {
				releaseQueue();
				return node;
			}
			if (this.head == node)
				this.head = node.next;
			if (this.tail == node)
				this.tail = node.pre;
			if (node.pre != null)
				node.pre.next = node.next;
			if (node.next != null)
				node.next.pre = node.pre;
			node.next = node.pre = null;
			node.currQueue = null;
			return node;
		}

		private void releaseQueue() {
			if (this.pre != null)
				this.pre.next = this.next;
			if (this.next != null)
				this.next.pre = this.pre;
			if (LFUCache2.tail == this)
				LFUCache2.tail = this.pre;
			this.next = this.pre = null;
		}

	}

}
