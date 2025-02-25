package appDomain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape3D;
import shapes.SquarePrism;
import shapes.TriangularPrism;


public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub
		String filePath = "";
		String shapePropType = "";
		String sortType = "";
		String numberOfShapes = "";
		
		ArrayList<Shape3D> shapes = new ArrayList<>();
		
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
			try {
				Files.lines(Paths.get(filePath)).forEach(line -> {
					if (line != null && !line.trim().isEmpty()) {
						String[] parts = line.split(" ");
						if (parts.length == 3) {
							switch (parts[0].toLowerCase()) {
								case "cone":
									shapes.add( new Cone(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
									break;
								case "cylinder":
									shapes.add( new Cylinder(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
									break;
								case "octagonalprism":
									shapes.add( new OctagonalPrism(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
									break;
								case "pentagonalprism":
									shapes.add( new PentagonalPrism(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
									break;
								case "pyramid":
									shapes.add( new Pyramid(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
									break;
								case "squareprism":
									shapes.add( new SquarePrism(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
									break;
								case "triangularprism":
									shapes.add( new TriangularPrism(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
									break;
							}
							
						}
						else {}
					}
	    			else {
	                    System.err.println("Invalid line format: " + line);
	                }
				});
			}
			catch(IOException e){
				System.err.println("The file titled " + filePath + " was not found");
			}
			
		}
		
		// Used to test correct File I/O implementation
		// Delete before submission
		for (Shape3D shape : shapes) {
			System.out.println(shape.toString());
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

}
