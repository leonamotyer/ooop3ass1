package utilities;

import appDomain.Algorithms;
import shapes.Shape3D;


/**
 * Utility class for testing sorting algorithms.
 * 
 * This class provides methods to measure the execution time of different sorting algorithms
 * applied to an array of `Shape3D` objects. The results are displayed based on the property
 * used for sorting (height, volume, or base area).
 *  
 *  - Bubble Sort
 *  - Insertion Sort
 *  - Selection Sort
 *  - Quick Sort 
 *  - Merge Sort
 *  - Heap Sort (as the custom algorithm)
 * 
 * 
 * The class also provides utility functions to swap 
 * elements during sorting.
 *
 * This Test class will be used in the application to
 * analyze sorting performance and present the results.
 */
public abstract class Test {
	
	/**
	 * Method to test the run time of 6 different sorting algorithms.
	 * Uses the two String parameters to select the corresponding 
	 * sorting algorithm and the version of sorting algorithm. 
	 * 
	 * The method will print the contents of the sorted array, only 
	 * showing the shape property that was used to sort.
	 * 
	 * @param shapes the array of Shape3D objects to be sorted
	 * @param sortType the type of sort algorithm to be used
	 * @param shapePropType the shape property used to compare each object
	 * 
	 * @return long stop-start run time for the sorting algorithm used
	 */
	public static long testSort(Shape3D[] shapes, String sortType, String shapePropType) {
		long start, stop;
		int count = 1;
		
		// Determine sorting algorithm and property
		switch(sortType.toLowerCase()) {
    		case "s":
    			{ switch(shapePropType.toLowerCase()) {
    			case "a":
    				start = System.currentTimeMillis();
        			Algorithms.selectionSortByArea(shapes);
        			stop = System.currentTimeMillis();
        			break;
    			case "v":
    				start = System.currentTimeMillis();
        			Algorithms.selectionSortByVol(shapes);
        			stop = System.currentTimeMillis();
        			break;

       			// Additional cases for other sorting types omitted for brevity
    			default:
    				start = System.currentTimeMillis();
        			Algorithms.selectionSort(shapes);
        			stop = System.currentTimeMillis();
        			break;
    			}}
    			break;
    			
    		case "i":
        		{ switch(shapePropType.toLowerCase()) {
    			case "a":
    				start = System.currentTimeMillis();
        			Algorithms.insertionSortByArea(shapes);
        			stop = System.currentTimeMillis();
        			break;
    			case "v":
    				start = System.currentTimeMillis();
        			Algorithms.insertionSortByVol(shapes);
        			stop = System.currentTimeMillis();
        			break;
    			default:
    				start = System.currentTimeMillis();
        			Algorithms.insertionSort(shapes);
        			stop = System.currentTimeMillis();
        			break; 
        		}}	
    			break;
    			
    		case "m":
        		{ switch(shapePropType.toLowerCase()) {
    			case "a":
    				start = System.currentTimeMillis();
        			Algorithms.mergeSortByArea(shapes, 0, shapes.length - 1);
        			stop = System.currentTimeMillis();
        			break;
    			case "v":
    				start = System.currentTimeMillis();
        			Algorithms.mergeSortByVol(shapes, 0, shapes.length - 1);
        			stop = System.currentTimeMillis();
        			break;
    			default:
    				start = System.currentTimeMillis();
        			Algorithms.mergeSort(shapes, 0, shapes.length - 1);
        			stop = System.currentTimeMillis();
        			break; 
            	}}
    			break;
    			
    		case "q":
        		{ switch(shapePropType.toLowerCase()) {
    			case "a":
    				start = System.currentTimeMillis();
        			Algorithms.quickSortByArea(shapes, 0, shapes.length - 1);
        			stop = System.currentTimeMillis();
        			break;
    			case "v":
    				start = System.currentTimeMillis();
        			Algorithms.quickSortByVol(shapes, 0, shapes.length - 1);
        			stop = System.currentTimeMillis();
        			break;
    			default:
    				start = System.currentTimeMillis();
        			Algorithms.quickSort(shapes, 0, shapes.length - 1);
        			stop = System.currentTimeMillis();
        			break; 
            	}}
    			break;
    					
    		case "z":
    			{ switch(shapePropType.toLowerCase()) {
        			case "a":
        				start = System.currentTimeMillis();
            			Algorithms.heapSortByArea(shapes);
            			stop = System.currentTimeMillis();
            			break;
        			case "v":
        				start = System.currentTimeMillis();
            			Algorithms.heapSortByVol(shapes);
            			stop = System.currentTimeMillis();
            			break;
        			default:
        				start = System.currentTimeMillis();
            			Algorithms.heapSort(shapes);
            			stop = System.currentTimeMillis();
            			break; 
            	}}
    			break;
    			
    		default:
    			{switch(shapePropType.toLowerCase()) {
        			case "a":
        				start = System.currentTimeMillis();
            			Algorithms.bubbleSortByArea(shapes);
            			stop = System.currentTimeMillis();
            			break;
        			case "v":
        				start = System.currentTimeMillis();
            			Algorithms.bubbleSortByVol(shapes);
            			stop = System.currentTimeMillis();
            			break;
        			default:
        				start = System.currentTimeMillis();
            			Algorithms.bubbleSort(shapes);
            			stop = System.currentTimeMillis();
            			break;
    			}}
    			break;
		}
		
		// Display sorted results at intervals
		if (shapes.length > 100 && shapes.length < 1001) {
			int hundred = 100;
			System.out.println("First Element is: " + sortedShapeProp(shapes[0], shapePropType));
			for (int i = 0; i < 10; i++) {
				System.out.println(hundred + "-th Element is: " + sortedShapeProp(shapes[hundred-1], shapePropType));
				hundred += 100;
			}
			System.out.println("Last Element is: " + sortedShapeProp(shapes[shapes.length-1], shapePropType));
			
		}
		else if (shapes.length > 1000) {
			int thousand = 1000;
			System.out.println("First Element is: " + sortedShapeProp(shapes[0], shapePropType));
			for (int i = 0; i < 20; i++) {
				System.out.println(thousand + "-th Element is: " + sortedShapeProp(shapes[thousand-1], shapePropType));
				thousand += 1000;
			}
			System.out.println("Last Element is: " + sortedShapeProp(shapes[shapes.length-1], shapePropType));
			
		}
		else {
			for (Shape3D shape : shapes) {
				System.out.println(count + ". " + sortedShapeProp(shape, shapePropType));
				count += 1;
			}
		}
		
		
		return stop - start;
	}
	
	/**
	 * Method to only return the value of the shape property used to
	 * sort the Shape3D array.
	 * 
	 * @param shape the Shape3D object to get the shape property String from
	 * @param shapePropType the shape property used to compare each object
	 * 
	 * @return String the Shape3D object's shape property value as a String
	 */
	private static String sortedShapeProp(Shape3D shape, String shapePropType) {
		switch (shapePropType.toLowerCase()) {
			case "a":
				return shape.baseToString();
			case "v":
				return shape.volumeToString();
			default:
				return shape.heightToString();
		}
	}
	
}
