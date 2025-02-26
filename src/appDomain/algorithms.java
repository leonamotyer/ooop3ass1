// Bubble Sort (Descending)
public static void bubbleSort(Integer[] arr) {
    System.out.println("\nSelected Bubble Sort");
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] < arr[j + 1]) { // Swap if the current element is smaller
                swap(arr, j, j + 1);
            }
        }
    }
}

// Insertion Sort (Descending)
public static void insertionSort(Integer[] arr) {
    System.out.println("\nSelected Insertion Sort");
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] < key) { // Shift elements if smaller
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// Selection Sort (Descending)
public static void selectionSort(Integer[] arr) {
    System.out.println("/nSelected Selection Sort");
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int maxIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] > arr[maxIdx]) { // Find the max element
                maxIdx = j;
            }
        }
        swap(arr, i, maxIdx);
    }
}

// QuickSort (Descending)
public static void quickSort(Integer[] arr, int low, int high) {
    System.out.println("/nSelected Quick Sort");
    if (low < high) {
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}
