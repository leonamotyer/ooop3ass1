
public class Driver {

    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 1000;

    public static void main(String[] args) {
        // Generate random numbers
        shapes[] coneArray = new shapes[SIZE];
        shapes[] cylinderArray = new shapes[SIZE];
        shapes[] pyramidArray = new shapes[SIZE];
        shapes[] octagonArray = new shapes[SIZE];
        shapes[] pentArray = new shapes[SIZE];
        shapes[] squareArray = new shapes[SIZE];
        shapes[] triangleArray = new shapes[SIZE];
        Random rand = new Random();

    // Bubble Sort (Descending)
        public static void bubbleSort(shapes[] shapesArray) {
            int n = shapesArray.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (shapesArray[j].getHeight() < shapesArray[j + 1].getHeight()) {
                        swap(shapesArray, j, j + 1);
                    }
                }
            }
        }
    }

    // Insertion Sort (Descending)
    public static void insertionSort(shapes[] shapesArray) {
        int n = shapesArray.length;
        for (int i = 1; i < n; i++) {
            shapes key = shapesArray[i];
            double keyHeight = key.getHeight();
            int j = i - 1;
            while (j >= 0 && shapesArray[j].getHeight() < keyHeight) {
                shapesArray[j + 1] = shapesArray[j];
                j--;
            }
            shapesArray[j + 1] = key;
        }
    }

    // Selection Sort (Descending)
    public static void selectionSort(shapes[] shapesArray) {
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

    // QuickSort (Descending)
    public static void quickSort(shapes[] shapesArray, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(shapesArray, low, high);
            quickSort(shapesArray, low, pivotIndex - 1);
            quickSort(shapesArray, pivotIndex + 1, high);
        }
    }

    private static int partition(shapes[] shapesArray, int low, int high) {
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

    private static int partition(Integer[] shapesArray, int low, int high) {
        int pivot = shapesArray[high]; // Choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (shapesArray[j] >= pivot) { // Place larger elements on the left
                i++;
                swap(shapesArray, i, j);
            }
        }
        swap(shapesArray, i + 1, high);
        return i + 1;
    }

    // Swap utility function
    private static void swap(shapes[] shapesArray, int i, int j) {
        shapes temp = shapesArray[i];
        shapesArray[i] = shapesArray[j];
        shapesArray[j] = temp;
    }
}
