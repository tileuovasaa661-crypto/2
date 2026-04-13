public class Main {
    public static void main(String[] args) {

        // 1
        int[] arr = {-2, 1, -3, 4, -1, 2, 1};
        System.out.println("Kadane: " + Kadane.maxSubArray(arr));

        // 2
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(2);
        b.next = new ListNode(4);
        b.next.next = new ListNode(6);

        ListNode merged = MergeLists.merge(a, b);

        System.out.print("Merged List: ");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        System.out.println();

        // 3
        MinStack st = new MinStack();
        st.push(5);
        st.push(2);
        st.push(8);
        System.out.println("MinStack min: " + st.getMin());
        st.pop();
        System.out.println("Top: " + st.top());

        // 4
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = SlidingWindow.maxSlidingWindow(nums, 3);

        System.out.print("Sliding Window: ");
        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();

        // 5
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Anagrams: " + Anagrams.groupAnagrams(words));

        // 6
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        System.out.println("Kth Smallest (k=3): " + BST.kthSmallest(root, 3));

        // 7
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(1);

        System.out.println("Heap extractMin: " + heap.extractMin());
        System.out.println("Heap extractMin: " + heap.extractMin());
    }
}