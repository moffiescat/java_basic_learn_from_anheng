package org.example.Heap;


//小顶堆写法
public class KthLargestMinHeap {

    // 主方法：找第k大元素
    public static int findKthLargest(int[] nums, int k) {
        // 只创建大小为 k 的小顶堆（空间最优）
        int[] minHeap = new int[k];

        // 第一步：先用前k个元素建堆
        System.arraycopy(nums, 0, minHeap, 0, k);
        buildMinHeap(minHeap, k);

        // 第二步：遍历剩下的元素，维护堆
        for (int i = k; i < nums.length; i++) {
            // 当前元素比堆顶大，才需要替换
            if (nums[i] > minHeap[0]) {
                minHeap[0] = nums[i];       // 替换堆顶
                heapify(minHeap, k, 0);     // 重新调整小顶堆
            }
        }

        // 堆顶就是第k大元素
        return minHeap[0];
    }

    // 构建小顶堆
    private static void buildMinHeap(int[] heap, int size) {
        // 从最后一个非叶子节点向上调整
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(heap, size, i);
        }
    }

    // 小顶堆调整核心（最关键）
    private static void heapify(int[] heap, int size, int root) {
        int smallest = root;       // 标记最小元素
        int left = 2 * root + 1;   // 左孩子
        int right = 2 * root + 2;  // 右孩子

        // 左孩子更小
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        // 右孩子更小
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // 最小不是根，交换并递归调整
        if (smallest != root) {
            swap(heap, root, smallest);
            heapify(heap, size, smallest);
        }
    }

    // 交换工具方法
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("第 " + k + " 大元素：" + findKthLargest(arr, k)); // 输出 5
    }
}