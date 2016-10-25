package collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by lianhui on 16/10/25.
 */
public class BoundedPriorityQueue<T> {

    private int maxSize;
    private int size = 0;
    private final Comparator<? super T> comparator;
    Object[] queue;

    public BoundedPriorityQueue(int maxSize, Comparator<? super T> comparator) {
        this.maxSize = maxSize;
        this.comparator = comparator;
        queue = new Object[maxSize];
    }
    public void add(T e) {
        if (size < maxSize) {
            this.offer(e);
        } else {
            T head = this.peek();
            if (head != null && comparator.compare(e, head) > 0) {
                this.poll();
                this.offer(e);
            }
        }
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        int s = --size;
        T result = (T) queue[0];
        T x = (T) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

    private void siftDown(int k, T x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size && comparator.compare((T) c, (T) queue[right]) > 0) {
                c = queue[child = right];
            }
            if (comparator.compare(x, (T) c) <= 0) {
                break;
            }
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }

    private T peek() {
        return (size == 0) ? null : (T) queue[0];
    }

    private void offer(T e) {
        int i = size;
        if (i == 0) {
            queue[0] = e;
        } else {
            siftUp(i, e);
        }
        size ++;
    }

    private void siftUp(int k, T x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (T) e) >= 0) {
                break;
            }
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private final class Itr implements Iterator<T> {

        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            return (T) queue[cursor++];
        }
    }

    public static void main(String[] args) {

        BoundedPriorityQueue priorityQueue = new BoundedPriorityQueue<Integer>(5, new
                Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < 100; i++) {
            priorityQueue.add(new Integer(i));
        }

        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
