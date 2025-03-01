package appDomain;


/**
 * ===========================================
 * AppDriver.java - Main Application Execution
 * ===========================================
 * 
 * Main program to:
 * - Read user-provided command-line arguments.
 * - Load shape data from a file.
 * - Sort shapes based on selected properties.
 * - Apply chosen sorting algorithm.
 * - Display results before and after sorting.
 * 
 * Error Handling:
 * - Displays messages for invalid inputs and exits gracefully.
 * 
 * @author Team Rauru: Devonte MacLean, Leona Motyer, Yoohyun Kim, Gabrielle Alama
 * @version 1.0
 */

import utilities.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import appDomain.Algorithms;

import shapes.*;
import appDomain.Algorithms;


/**
 * Main application class that handles execution.
 * 
 */

public class AppDriver
{
	/**
	 * main Method used to collect and use user inputs via command
	 * line arguments, create an array of Shape3D objects, and test
	 * the performance of 6 different sorting algorithms.
	 * 
	 * Error messages are used to handle invalid user inputs and exceptions. 
	 * When an error message is displayed, the program will end so the user 
	 * can immediately enter new command line arguments.
	 * 
	 * Used the -f"res\shapes1".txt as the file for creating shapes
	 * 
	 * @param args the String array containing the command line arguments
	 * @throws StringIndexOutOfBoundsException 
	 */
	
	public static void main( String[] args )
	{
		String filePath = "";
		String shapePropType = "";
		String sortType = "";
		
		// Check if command line arguments were entered
		if (args.length > 0) {
			for (int i=0; i < args.length; i++) {
				
				// Check for flag string:
				// - Exception thrown if the command line arguments aren't 2 characters i.e. flag
				
				// Check for filePath, shapePropType and sortType:
				// - Exception thrown if they don't contain characters after the first two i.e. -f
				
				// Any time a check fails, an error message will be displayed and the String that 
				// caused the failure will be displayed
				try {
					String flag = args[i].substring(0, 2); 
					if (flag.equalsIgnoreCase("-F") && args[i].length() > 2) { 
		
				        filePath = args[i].substring(2); 
				        System.out.println("File Path Selected: " + filePath);
				    }
				    else if (flag.equalsIgnoreCase("-T") && args[i].length() > 2) {
				    	shapePropType = args[i].substring(2).toLowerCase();
				    	
				    	if (shapePropType.equalsIgnoreCase("v") 
				    			|| shapePropType.equalsIgnoreCase("h")
				    			|| shapePropType.equalsIgnoreCase("a")) {
				    		System.out.println("Shape Property Selected: " + shapePropType);
				    	}
				    	else {
				    		System.err.println("The CLA of " + args[i] + " can only "
				    				+ "have one of: \nv, h, a following -t");
				    		System.exit(0);
				    	}
				    	
				    }
				    else if (flag.equalsIgnoreCase("-S") && args[i].length() > 2) {
				    	sortType = args[i].substring(2).toLowerCase();
				    	
				    	if (sortType.equalsIgnoreCase("b") 
				    			|| sortType.equalsIgnoreCase("s")
				    			|| sortType.equalsIgnoreCase("i")
				    			|| sortType.equalsIgnoreCase("m")
				    			|| sortType.equalsIgnoreCase("q")
				    			|| sortType.equalsIgnoreCase("z")) {
				    		System.out.println("Sort Type Selected: " + sortType);
				    	}
				    	else {
				    		System.err.println("The CLA of " + args[i] + " can only "
				    				+ "have one of: \nb, s, i, m, q, z following -s");
				    		System.exit(0);
				    	}
				    	
				    }
				    else {
				    	System.err.println("Command Line Argument of: " + args[i] + " is invalid"
								+ "\nPlease match the following argument format:\n"
								+ "-f<file_path> -t<criterion> -s<algorithm>\n"
								+ "Where criterion: v, h, or a and "
								+ "algorithm: b, s, i, m, q, z");
				    	System.exit(0);
				    }
				}
				catch (StringIndexOutOfBoundsException e) {
					System.err.println("Command Line Argument of: " + args[i] + " is invalid"
							+ "\nPlease match the following argument format:\n"
							+ "-f<file_path> -t<criterion> -s<algorithm>\n"
							+ "Where criterion: v, h, or a and "
							+ "algorithm: b, s, i, m, q, z");
					System.exit(0);
				}
			}
		}
		else {
			System.err.println("Missing Command Line Arguments");
			System.exit(0);
		}
		
		
		Shape3D[] shapes = generateShapes(filePath);
		

		int count = 1;
		if (shapes.length != 0) {
						
			System.out.println("\n\n\n" + sortTypeToString(sortType) + " Sorted Shapes: " );
			
			System.out.println(sortTypeToString(sortType) 
					+ " Sort run time was: " 
					+ (Test.testSort(shapes, sortType, shapePropType)) 
					+ " milliseconds");
			
		}
		else {
			System.err.println("File found but had no shapes");
			System.exit(0);
		}
	}
	
	/**
	 * Method to return the full word string of the sortType parameter  
	 * 
	 * @param sortType the type of sorting algorithm selected via command line argument.
	 * 
	 * @return String the full word corresponding to the sortType parameter
	 */
	public static String sortTypeToString(String sortType) {
		switch (sortType.toLowerCase()) {
			case "s":
				return "Selection";
			case "i":
				return "Insertion";
			case "m":
				return "Merge";
			case "q":
				return "Quick";
			case "z":
				return "Heap";
			default:
				return "Bubble";
		}
	}
	
	/**
	 * Method to create the array of Shape3D objects
	 * 
	 * @param filePath the file path string used to locate the shapes file
	 * 
	 * @throws NumberFormatException if the first line in the file cannot
	 * be parsed into a integer
	 * 
	 * @return Shape3D[] an array of Shape3D objects 
	 */
	public static Shape3D[] generateShapes(String filePath) {
		int numberOfShapes = 0;
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			
			if (!lines.isEmpty()) {
				
		        try {
		        	numberOfShapes = Integer.parseInt(lines.get(0));
		        } 
		        catch (NumberFormatException e) {
		            System.err.println("Invalid shape count on the first line of: " + lines.get(0));
		        }
		        
		        Shape3D[] shapes = new Shape3D[numberOfShapes];
		        
		        for (int i = 1; i < numberOfShapes + 1; i++) {
		        	String line = lines.get(i);
		        	if (line != null && !line.trim().isEmpty()) {
		        		String[] parts = line.split(" ");
		        		
		        		String type = parts[0].toLowerCase();
		        		
		        		try {
		                    double param1 = Double.parseDouble(parts[1]);
		                    double param2 = Double.parseDouble(parts[2]);
		                    
		                    switch (type) {
									case "cone":
			                            shapes[i - 1] = new Cone(param1, param2);
			                            break;
			                        case "cylinder":
			                            shapes[i - 1] = new Cylinder(param1, param2);
			                            break;
			                        case "octagonalprism":
			                            shapes[i - 1] = new OctagonalPrism(param1, param2);
			                            break;
			                        case "pentagonalprism":
			                            shapes[i - 1] = new PentagonalPrism(param1, param2);
			                            break;
			                        case "pyramid":
			                            shapes[i - 1] = new Pyramid(param1, param2);
			                            break;
			                        case "squareprism":
			                            shapes[i - 1] = new SquarePrism(param1, param2);
			                            break;
			                        case "triangularprism":
			                            shapes[i - 1] = new TriangularPrism(param1, param2);
			                            break;
			                        default:
			                        	System.err.println("Skipping unknown shape type: " + type);	
			                        break;
		                    }
		        		}
		        		catch (NumberFormatException e) {
		        			System.err.println("Parameters: " + parts[1] + "or" + parts[2] + "are not valid decimals");
		        		}
		        	}
		        	
		        }
		        System.out.println("\n\nShapes count is: " + shapes.length);
		        return shapes;
			}
		}
		catch(IOException e){
			System.err.println("The file titled \'" + filePath + "\' was not found");
			System.exit(0);
		}
		Shape3D[] emptyShapes = new Shape3D[0];
		return emptyShapes;
	}

}
