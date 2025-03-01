package shapes;


/**
 * Represents an Octagonal Prism, a subclass of Shape3D.
 * 
 * An octagonal prism is defined by its height (inherited) and the length of one edge of its octagonal base.
 * This class provides methods to compute its volume and base area.
 */
public class OctagonalPrism extends Shape3D {
    private double edge;

    
    /**
     * Constructs an Octagonal Prism with a specified height and edge length.
     * 
     * @param height The height of the octagonal prism.
     * @param edge The length of one edge of the octagonal base.
     */
    public OctagonalPrism(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    
    /**
     * Returns the length of one edge of the octagonal prism's base.
     * 
     * @return The edge length of the base.
     */
    public double getEdge() {
        return edge;
    }

    
    /**
     * Calculates and returns the base area of the octagonal prism.
     * 
     * Formula: 2 * (1 + sqrt(2)) * edge²
     * 
     * @return The base area of the octagonal prism.
     */
    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * edge * edge;
    }

    
    /**
     * Calculates and returns the volume of the octagonal prism.
     * 
     * Formula: base area * height
     * 
     * @return The volume of the octagonal prism.
     */
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    
    /**
     * Returns a string representation of the octagonal prism, including its height and edge length.
     * 
     * @return A formatted string representing the octagonal prism.
     */
    @Override
    public String toString() {
        return super.toString() + " [edge=" + edge + "]";
    }
}
