package org.example.Heap;

public class HeapSort {

    // 堆排序主方法（升序）
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. 构建大顶堆：从最后一个非叶子节点向上调整
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. 一个个从堆顶取出元素
        for (int i = n - 1; i > 0; i--) {
            // 堆顶和最后一个元素交换
            swap(arr, 0, i);

            // 调整剩余元素为大顶堆
            heapify(arr, i, 0);
        }
    }

    // 核心：调整以 i 为根的子树为大顶堆
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;    // 最大值初始化为根
        int left = 2 * i + 1;  // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 左子节点比根大
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 右子节点比最大值大
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 最大值不是根，交换并递归调整
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // 交换数组两个元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ===================== 找第 K 大元素 =====================
    public static int findKthLargest(int[] arr, int k) {
        int n = arr.length;

        // 1. 建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. 取出 k-1 次堆顶，剩下的堆顶就是第 K 大
        for (int i = n - 1; i >= n - k + 1; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }

        return arr[0];
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println("第 " + k + " 大元素：" + findKthLargest(arr, k));

        // 排序验证
        heapSort(arr);
        System.out.print("排序后数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
