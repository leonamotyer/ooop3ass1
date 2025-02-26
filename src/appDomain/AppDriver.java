package appDomain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import shapes.*;


public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub
		String filePath = "";
		String shapePropType = "";
		String sortType = "";
		
		
		if (args.length > 0) {
			for (int i=0; i < args.length; i++) {
				try {
					// Check for flag string:
					// - Exception thrown if the command line arguments aren't 2 characters i.e. flag
					// Check for filePath, shapePropType and sortType:
					// - Exception thrown if the "" "" "" don't contain characters after the first two i.e. 
					String flag = args[i].substring(0, 2); 
					if (flag.equalsIgnoreCase("-F")) { 
		
				        filePath = args[i].substring(2); 
				        
				        // Used to ensure correct retrieval of command line args
				        // Delete before submission
				        System.out.println("File Path: " + filePath);
				    }
				    else if (flag.equalsIgnoreCase("-T")) {
				    	shapePropType = args[i].substring(2);
				    	
				    	// Used to ensure correct retrieval of command line args
				        // Delete before submission
				    	System.out.println("Shape Property: " + shapePropType);
				    }
				    else if (flag.equalsIgnoreCase("-S")) {
				    	sortType = args[i].substring(2);
				    	
				    	// Used to ensure correct retrieval of command line args
				        // Delete before submission
				    	System.out.println("Sort Type: " + sortType);
				    }
				    else {}
				}
				catch (StringIndexOutOfBoundsException e) {
					System.err.println("Command Line Argument (index: " + i + ") is invalid");
				}
			}
		}
		
		
		if (!filePath.isEmpty()) {
			Shape3D[] shapes = generateShapes(filePath);
			
			// Used to test correct File I/O implementation
			// Delete before submission
			int count = 1;
			if (shapes.length != 0) {
    			for (Shape3D shape : shapes) {
    				System.out.println(count + ". " + shape.toString());
    				count += 1;
    			}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

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
			System.err.println("The file titled " + filePath + " was not found");
		}
		Shape3D[] emptyShapes = new Shape3D[0];
		return emptyShapes;
	}

}
