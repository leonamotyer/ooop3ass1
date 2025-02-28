package appDomain;

import utilities.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import appDomain.Algorithms;

import shapes.*;
import appDomain.Algorithms;

public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub
		String filePath = "";
		String shapePropType = "";
		String sortType = "";
		
		
		//reading command line arguments
		if (args.length > 0) {
			for (int i=0; i < args.length; i++) {
				try {
					// Check for flag string:
					// - Exception thrown if the command line arguments aren't 2 characters i.e. flag
					// Check for filePath, shapePropType and sortType:
					// - Exception thrown if the "" "" "" don't contain characters after the first two i.e. 
					String flag = args[i].substring(0, 2); 
					if (flag.equalsIgnoreCase("-F") && args[i].length() > 2) { 
		
				        filePath = args[i].substring(2); 
				        System.out.println("File Path Selected: " + filePath);
				    }
				    else if (flag.equalsIgnoreCase("-T") && args[i].length() > 2) {
				    	shapePropType = args[i].substring(2);
				    	
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
				    	sortType = args[i].substring(2);
				    	
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
		
		// Used to test correct File I/O implementation
		// Delete before submission
		int count = 1;
		if (shapes.length != 0) {
			System.out.println("\nPre Sorted Shapes:");
			
			if (shapes.length > 1000) {
				int thousand = 1000;
				System.out.println("First Element is: " + shapes[0].toString());
				for (int i = 0; i < 20; i++) {
					System.out.println(thousand + "-th Element is: " + shapes[thousand].toString());
					thousand += 1000;
				}
				System.out.println("Last Element is: " + shapes[shapes.length-1].toString());
				
			}
			else {
				for (Shape3D shape : shapes) {
					System.out.println(count + ". " + shape.toString());
					count += 1;
				}
			}
			
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
	
	public static String sortTypeToString(String sortType) {
		switch (sortType) {
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
		        System.out.println("Shapes count is: " + shapes.length);
		        return shapes;
			}
		}
		catch(IOException e){
			System.err.println("The file titled \'" + filePath + "\' was not found");
		}
		Shape3D[] emptyShapes = new Shape3D[0];
		return emptyShapes;
	}

}
