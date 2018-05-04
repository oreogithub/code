package code.utilrw;

import java.util.AbstractCollection;
import java.util.Iterator;

class CollectionRw<E> extends AbstractCollection<E> {
	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	public static void main(String[] args) {
		int i = 100;
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		i = i & 0x3f;
	}

}
