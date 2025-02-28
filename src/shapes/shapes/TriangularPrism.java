package shapes;

/**
 * Represents a Triangular Prism, a subclass of Shape3D.
 * 
 * A triangular prism is defined by its height (inherited) and the length of one edge of its triangular base.
 * This class provides methods to compute its volume and base area.
 */
public class TriangularPrism extends Shape3D {
    private double edge;

    
    /**
     * Constructs a Triangular Prism with a specified height and edge length.
     * 
     * @param height The height of the triangular prism.
     * @param edge The length of one edge of the triangular base.
     */
    public TriangularPrism(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    
    /**
     * Returns the length of one edge of the triangular prism's base.
     * 
     * @return The edge length of the base.
     */
    public double getEdge() {
        return edge;
    }
    
    
    /**
     * Calculates and returns the base area of the triangular prism.
     * 
     * Formula: (√3 / 4) * edge²
     * 
     * @return The base area of the triangular prism.
     */
    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4.0) * edge * edge;
    }

    
    /**
     * Calculates and returns the volume of the triangular prism.
     * 
     * Formula: base area * height
     * 
     * @return The volume of the triangular prism.
     */
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    
    /**
     * Returns a string representation of the triangular prism, including its height and edge length.
     * 
     * @return A formatted string representing the triangular prism.
     */
    @Override
    public String toString() {
        return super.toString() + " [edge=" + edge + "]";
    }
}
