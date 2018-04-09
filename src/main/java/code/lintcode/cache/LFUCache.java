package code.lintcode.cache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

	private int capacity;

	private Map<Integer, Node> cache;
	private static NodeQueue head = null, tail = null;

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
				this.tail = this.head = node;
				return;
			}
			Node temp = this.head;
			node.next = temp;
			temp.pre = node;
			this.head = node;
		}

		public static void removeNode(Node node) {
			if (node == null)
				return;
			NodeQueue cq = node.currQueue;
			node.currQueue = null;
			// one node queue, remove queue
			if (cq.head == cq.tail) {
				if (cq.pre != null)
					cq.pre.next = cq.next;
				if (cq.next != null)
					cq.next.pre = cq.pre;
				if (LFUCache.head == cq)
					LFUCache.head = cq.next;
				if (LFUCache.tail == cq)
					LFUCache.tail = cq.pre;
				cq.next = cq.pre = null;
				return;
			}
			if (cq.head == node)
				cq.head = node.next;
			else if (cq.tail == node)
				cq.tail = node.pre;
			else {
				node.pre.next = node.next;
				node.next.pre = node.pre;
			}
			node.pre = null;
			node.next = null;
		}

		public static void pullUpNode(Node node) {
			if (node == null)
				return;
			node.record.pullUp();
			NodeQueue cq = node.currQueue;
			if (cq == LFUCache.head)
				return;
			NodeQueue.removeNode(node);
			NodeQueue pq = cq.pre;
			if (pq == null) {
				pq = new NodeQueue(cq, pq, null, null);
				cq.pre = pq;
				LFUCache.head = pq;
			} else if (pq.head.record.freq != node.record.freq) {
				NodeQueue temp = cq.pre;
				pq = new NodeQueue(cq, pq, null, null);
				cq.pre = pq;
				temp.next = pq;
			}
			pq.addNode(node);
		}
	}

	static class Node {
		Node next, pre;
		NodeQueue currQueue;
		int key, val;
		Record record;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.record = new Record();
		}
	}

	static class Record {
		int freq;
		long timestmp;

		public Record() {
			this.freq = 1;
			this.timestmp = System.currentTimeMillis();
		}

		public void pullUp() {
			this.freq++;
			this.timestmp = System.currentTimeMillis();
		}

	}

	/*
	 * @param capacity: An integer
	 */
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<Integer, LFUCache.Node>(capacity);
	}

	/*
	 * @param key: An integer
	 * 
	 * @param value: An integer
	 * 
	 * @return: nothing
	 */
	public void set(int key, int value) {
		if (this.capacity == 0)
			return;
		// if exists
		Node node = this.getNode(key);
		if (node != null) {
			node.val = value;
			return;
		}
		// remove least frequnce node
		if (this.cache.size() == this.capacity) {
			Node lfn = tail.tail;
			NodeQueue.removeNode(lfn);
			this.cache.remove(lfn.key);
		}
		node = new Node(key, value);
		if (tail == null) {
			head = tail = new NodeQueue(null, null, null, null);
		}
		if (tail.tail != null && tail.tail.record.freq != node.record.freq) {
			NodeQueue temp = new NodeQueue(null, tail, node, node);
			tail.next = temp;
			tail = temp;
		}
		tail.addNode(node);
		this.cache.put(key, node);
	}

	/*
	 * @param key: An integer
	 * 
	 * @return: An integer
	 */
	public int get(int key) {
		Node node;
		return (node = getNode(key)) == null ? -1 : node.val;
	}

	private Node getNode(int key) {
		Node node = this.cache.get(key);
		if (node != null)
			NodeQueue.pullUpNode(node);
		return node;
	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(3);
		/*
		 * cache.set(2, 2); cache.set(1, 1); cache.get(2); cache.get(1); cache.get(2);
		 * cache.set(3, 3); cache.set(4, 4); cache.get(3); cache.get(2); cache.get(1);
		 * cache.get(4);
		 */

		cache.set(1, 10);
		cache.set(2, 20);
		cache.set(3, 30);
		cache.get(1);
		cache.set(4, 40);
		cache.get(4);
		cache.get(3);
		cache.get(2);
		cache.get(1);
		cache.set(5, 50);
		cache.get(1);
		cache.get(2);
		cache.get(3);
		cache.get(4);
		cache.get(5);

		/*
		 * LFUCache cache = new LFUCache(1); cache.set(2, 1); cache.get(2); cache.set(3,
		 * 2); cache.get(2); cache.get(3);
		 */

	}

}