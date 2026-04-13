import java.util.*;

class MinHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if (heap.isEmpty())
            throw new RuntimeException("Heap is empty");

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;

            if (heap.get(p) > heap.get(i)) {
                swap(p, i);
                i = p;
            } else break;
        }
    }

    private void heapifyDown(int i) {
        int n = heap.size();

        while (true) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int smallest = i;

            if (l < n && heap.get(l) < heap.get(smallest))
                smallest = l;

            if (r < n && heap.get(r) < heap.get(smallest))
                smallest = r;

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }
}
