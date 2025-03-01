package shapes;

/**
 * Represents a Square Prism, a subclass of Shape3D.
 * 
 * A square prism is defined by its height (inherited) and the length of one edge of its square base.
 * This class provides methods to compute its volume and base area.
 */
public class SquarePrism extends Shape3D {
    private double edge;

    
    /**
     * Constructs a Square Prism with a specified height and edge length.
     * 
     * @param height The height of the square prism.
     * @param edge The length of one edge of the square base.
     */
    public SquarePrism(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    
    /**
     * Returns the length of one edge of the square prism's base.
     * 
     * @return The edge length of the base.
     */
    public double getEdge() {
        return edge;
    }

    
    /**
     * Calculates and returns the volume of the square prism.
     * 
     * Formula: base area * height
     * 
     * @return The volume of the square prism.
     */
    @Override
    public double getBaseArea() {
        return edge * edge;
    }

    
    /**
     * Calculates and returns the base area of the square prism.
     * 
     * Formula: edge²
     * 
     * @return The base area of the square prism.
     */
    @Override
    public double getVolume() {
        return edge * edge * height;
    }

    
    /**
     * Returns a string representation of the square prism, including its height and edge length.
     * 
     * @return A formatted string representing the square prism.
     */
    @Override
    public String toString() {
        return super.toString() + " [edge=" + edge + "]";
    }
}

