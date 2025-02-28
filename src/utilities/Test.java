package utilities;

import appDomain.Algorithms;
import shapes.Shape3D;

public class Test {
	
	public static long testSort(Shape3D[] shapes, String sortType, String shapePropType) {
		long start, stop;
		int count = 1;
		
		
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
		
		if (shapes.length > 1000) {
			int thousand = 1000;
			System.out.println("First Element is: " + sortedShapeProp(shapes[0], shapePropType));
			for (int i = 0; i < 20; i++) {
				System.out.println(thousand + "-th Element is: " + sortedShapeProp(shapes[thousand], shapePropType));
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
	
	private static String sortedShapeProp(Shape3D shape, String shapeProp) {
		switch (shapeProp.toLowerCase()) {
			case "a":
				return shape.baseToString();
			case "v":
				return shape.volumeToString();
			default:
				return shape.heightToString();
				
		}
	}
	
}
