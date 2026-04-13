import java.util.*;

//1
class Kadane {
    public static int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}

//2
class ListNode {
    int val;
    ListNode next;

    ListNode(int v) { val = v; }
}

class MergeLists {
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}

//3
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

//4
class SlidingWindow {
    public static int[] maxWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}

//5
class Anagrams {
    public static List<List<String>> group(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

//6
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) { val = v; }
}

class BST {
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;

            if (k == 0) return root.val;

            root = root.right;
        }
    }
}

//7
class MinHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if (heap.isEmpty()) throw new RuntimeException("Empty heap");

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
            int parent = (i - 1) / 2;

            if (heap.get(parent) > heap.get(i)) {
                swap(parent, i);
                i = parent;
            } else break;
        }
    }

    private void heapifyDown(int i) {
        int size = heap.size();

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

//main
public class Main {
    public static void main(String[] args) {

        System.out.println(Kadane.maxSubArray(new int[]{-2,1,-3,4,-1,2,1}));

        MinHeap heap = new MinHeap();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);

        System.out.println(heap.extractMin()); // 1
        System.out.println(heap.extractMin()); // 2
    }
}