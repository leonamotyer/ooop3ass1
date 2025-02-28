/**
 * This class contains various sorting algorithms
 * to sort an array of Shape3D objects in descending
 * order based on their height. It includes different
 * types of sorting through implementations of:
 * 
 *  - Bubble Sort
 *  - Insertion Sort
 *  - Selection Sort
 *  - Quick Sort 
 *  - Merge Sort
 *  - Heap Sort (as the custom algorithm)
 *  
 * Heap Sort:
 * An efficient, comparison-based sorting algorithm that
 * utilizes a binary heap. It works by building a max heap
 * from the input data and then repeatedly extracting the
 * element to sort the array descending order.
 * 
 * 
 * Time Complexity:
 *   - Best Case: O(n log n)
 *   - Average Case: O(n log n)
 *   - Worst Case: O(n log n)
 * 
 * 
 * The class also provides utility functions to swap 
 * elements during sorting.
 *
 * These algorithms will be used in the appliation to
 * analyze sorting performance.
 */

package appDomain;


import shapes.Shape3D;

public class Algorithms {

    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 1000;
    
    private static void swap(Shape3D[] shapesArray, int i, int j) {
        Shape3D temp = shapesArray[i];
        shapesArray[i] = shapesArray[j];
        shapesArray[j] = temp;
    }
    
    
    // Bubble Sort (Descending)
    public static void bubbleSort(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapesArray[j].getHeight() < shapesArray[j + 1].getHeight()) {
                    swap(shapesArray, j, j + 1);
                }
            }
        }
    }
    public static void bubbleSortByVol(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapesArray[j].getVolume() < shapesArray[j + 1].getVolume()) {
                    swap(shapesArray, j, j + 1);
                }
            }
        }
    }
    public static void bubbleSortByArea(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapesArray[j].getBaseArea() < shapesArray[j + 1].getBaseArea()) {
                    swap(shapesArray, j, j + 1);
                }
            }
        }
    }

    
    // Insertion Sort (Descending)
    public static void insertionSort(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 1; i < n; i++) {
            Shape3D key = shapesArray[i];
            double keyHeight = key.getHeight();
            int j = i - 1;
            while (j >= 0 && shapesArray[j].getHeight() < keyHeight) {
                shapesArray[j + 1] = shapesArray[j];
                j--;
            }
            shapesArray[j + 1] = key;
        }
    }
    public static void insertionSortByVol(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 1; i < n; i++) {
            Shape3D key = shapesArray[i];
            double keyHeight = key.getVolume();
            int j = i - 1;
            while (j >= 0 && shapesArray[j].getVolume() < keyHeight) {
                shapesArray[j + 1] = shapesArray[j];
                j--;
            }
            shapesArray[j + 1] = key;
        }
    }
    public static void insertionSortByArea(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 1; i < n; i++) {
            Shape3D key = shapesArray[i];
            double keyHeight = key.getBaseArea();
            int j = i - 1;
            while (j >= 0 && shapesArray[j].getBaseArea() < keyHeight) {
                shapesArray[j + 1] = shapesArray[j];
                j--;
            }
            shapesArray[j + 1] = key;
        }
    }

    
    // Selection Sort (Descending)
    public static void selectionSort(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (shapesArray[j].getHeight() > shapesArray[maxIdx].getHeight()) {
                    maxIdx = j;
                }
            }
            swap(shapesArray, i, maxIdx);
        }
    }
    public static void selectionSortByVol(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (shapesArray[j].getVolume() > shapesArray[maxIdx].getVolume()) {
                    maxIdx = j;
                }
            }
            swap(shapesArray, i, maxIdx);
        }
    }
    public static void selectionSortByArea(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (shapesArray[j].getBaseArea() > shapesArray[maxIdx].getBaseArea()) {
                    maxIdx = j;
                }
            }
            swap(shapesArray, i, maxIdx);
        }
    }

    
    // QuickSort (Descending)
    public static void quickSort(Shape3D[] shapesArray, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(shapesArray, low, high);
            quickSort(shapesArray, low, pivotIndex - 1);
            quickSort(shapesArray, pivotIndex + 1, high);
        }
    }
    private static int partition(Shape3D[] shapesArray, int low, int high) {
        double pivot = shapesArray[high].getHeight();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (shapesArray[j].getHeight() >= pivot) {
                i++;
                swap(shapesArray, i, j);
            }
        }
        swap(shapesArray, i + 1, high);
        return i + 1;
    }
    
    public static void quickSortByVol(Shape3D[] shapesArray, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByVol(shapesArray, low, high);
            quickSortByVol(shapesArray, low, pivotIndex - 1);
            quickSortByVol(shapesArray, pivotIndex + 1, high);
        }
    }
    private static int partitionByVol(Shape3D[] shapesArray, int low, int high) {
        double pivot = shapesArray[high].getVolume();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (shapesArray[j].getVolume() >= pivot) {
                i++;
                swap(shapesArray, i, j);
            }
        }
        swap(shapesArray, i + 1, high);
        return i + 1;
    }
    
    public static void quickSortByArea(Shape3D[] shapesArray, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionByArea(shapesArray, low, high);
            quickSortByArea(shapesArray, low, pivotIndex - 1);
            quickSortByArea(shapesArray, pivotIndex + 1, high);
        }
    }
    private static int partitionByArea(Shape3D[] shapesArray, int low, int high) {
        double pivot = shapesArray[high].getBaseArea();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (shapesArray[j].getBaseArea() >= pivot) {
                i++;
                swap(shapesArray, i, j);
            }
        }
        swap(shapesArray, i + 1, high);
        return i + 1;
    }
    
    
    
    // Merge Sort (Descending)
    public static void mergeSort(Shape3D[] shapesArray, int left, int right) {
    	if (left < right) {
    		int mid = left + (right - left) / 2;
    		mergeSort(shapesArray, left ,mid);
    		mergeSort(shapesArray, mid + 1, right);
    		merge(shapesArray, left ,mid, right);
    	}
    
    }
    private static void merge(Shape3D[] shapesArray, int left, int mid, int right) {
    	int n1 = mid - left + 1;
    	int n2 = right - mid;
    	Shape3D[] leftArray = new Shape3D[n1];
    	Shape3D[] rightArray = new Shape3D[n2];
    	System.arraycopy(shapesArray, left, leftArray, 0, n1);
    	System.arraycopy(shapesArray, mid + 1, rightArray, 0, n2);
    	 int i = 0, j = 0, k = left;
         while (i < n1 && j < n2) {
             if (leftArray[i].getHeight() >= rightArray[j].getHeight()) {
                 shapesArray[k++] = leftArray[i++];
             } else {
                 shapesArray[k++] = rightArray[j++];
             }
         }
         while (i < n1) shapesArray[k++] = leftArray[i++];
         while (j < n2) shapesArray[k++] = rightArray[j++];
    }
    
    public static void mergeSortByVol(Shape3D[] shapesArray, int left, int right) {
    	if (left < right) {
    		int mid = left + (right - left) / 2;
    		mergeSortByVol(shapesArray, left ,mid);
    		mergeSortByVol(shapesArray, mid + 1, right);
    		mergeByVol(shapesArray, left ,mid, right);
    	}
    
    }
    private static void mergeByVol(Shape3D[] shapesArray, int left, int mid, int right) {
    	int n1 = mid - left + 1;
    	int n2 = right - mid;
    	Shape3D[] leftArray = new Shape3D[n1];
    	Shape3D[] rightArray = new Shape3D[n2];
    	System.arraycopy(shapesArray, left, leftArray, 0, n1);
    	System.arraycopy(shapesArray, mid + 1, rightArray, 0, n2);
    	 int i = 0, j = 0, k = left;
         while (i < n1 && j < n2) {
             if (leftArray[i].getVolume() >= rightArray[j].getVolume()) {
                 shapesArray[k++] = leftArray[i++];
             } else {
                 shapesArray[k++] = rightArray[j++];
             }
         }
         while (i < n1) shapesArray[k++] = leftArray[i++];
         while (j < n2) shapesArray[k++] = rightArray[j++];
    }
    
    public static void mergeSortByArea(Shape3D[] shapesArray, int left, int right) {
    	if (left < right) {
    		int mid = left + (right - left) / 2;
    		mergeSortByArea(shapesArray, left ,mid);
    		mergeSortByArea(shapesArray, mid + 1, right);
    		mergeByArea(shapesArray, left ,mid, right);
    	}
    
    }
    private static void mergeByArea(Shape3D[] shapesArray, int left, int mid, int right) {
    	int n1 = mid - left + 1;
    	int n2 = right - mid;
    	Shape3D[] leftArray = new Shape3D[n1];
    	Shape3D[] rightArray = new Shape3D[n2];
    	System.arraycopy(shapesArray, left, leftArray, 0, n1);
    	System.arraycopy(shapesArray, mid + 1, rightArray, 0, n2);
    	 int i = 0, j = 0, k = left;
         while (i < n1 && j < n2) {
             if (leftArray[i].getBaseArea() >= rightArray[j].getBaseArea()) {
                 shapesArray[k++] = leftArray[i++];
             } else {
                 shapesArray[k++] = rightArray[j++];
             }
         }
         while (i < n1) shapesArray[k++] = leftArray[i++];
         while (j < n2) shapesArray[k++] = rightArray[j++];
    }
    
    
    
    // Heap Sort Currently ascending!  - Custom Algorithm
    public static void heapSort(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(shapesArray, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(shapesArray, 0, i);
            heapify(shapesArray, i, 0);
        }
    }
    private static void heapify(Shape3D[] shapesArray, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && shapesArray[left].getHeight() > shapesArray[largest].getHeight()) {
            largest = left;
        }
        if (right < n && shapesArray[right].getHeight() > shapesArray[largest].getHeight()) {
            largest = right;
        }
        if (largest != i) {
            swap(shapesArray, i, largest);
            heapify(shapesArray, n, largest);
        }
    }
    
    public static void heapSortByVol(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyByVol(shapesArray, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(shapesArray, 0, i);
            heapifyByVol(shapesArray, i, 0);
        }
    }
    private static void heapifyByVol(Shape3D[] shapesArray, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && shapesArray[left].getVolume() > shapesArray[largest].getVolume()) {
            largest = left;
        }
        if (right < n && shapesArray[right].getVolume() > shapesArray[largest].getVolume()) {
            largest = right;
        }
        if (largest != i) {
            swap(shapesArray, i, largest);
            heapifyByVol(shapesArray, n, largest);
        }
    }
    
    public static void heapSortByArea(Shape3D[] shapesArray) {
        int n = shapesArray.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
        	heapifyByArea(shapesArray, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(shapesArray, 0, i);
            heapifyByArea(shapesArray, i, 0);
        }
    }
    private static void heapifyByArea(Shape3D[] shapesArray, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && shapesArray[left].getBaseArea() > shapesArray[largest].getBaseArea()) {
            largest = left;
        }
        if (right < n && shapesArray[right].getBaseArea() > shapesArray[largest].getBaseArea()) {
            largest = right;
        }
        if (largest != i) {
            swap(shapesArray, i, largest);
            heapifyByArea(shapesArray, n, largest);
        }
    }


    
   
}
