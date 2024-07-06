import java.util.List;
import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
    private List<T> heap;

    public PriorityQueue() {
        this.heap = new ArrayList<>();
    }

    public void add(T item) {
        heap.add(item);
        int i = heap.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parent)) >= 0) {
                break;
            }
            // swap
            T aux = heap.get(i);
            heap.set(i, heap.get(parent));
            heap.set(parent, aux);
            i = parent;
        }
    }

    public T remove() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty\n");
        }

        T minItem = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            heapify(0);
        }

        return minItem;
    }

    private void heapify(int index) {
        int leftChild = 2 * index + 1, rightChild = 2 * index + 2, smallest = index;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            T aux = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, aux);
            heapify(smallest);
        }
    }

    // helper for Dijkstra
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}