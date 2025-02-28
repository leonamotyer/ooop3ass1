package shapes;

/**
 * Represents a Pyramid, a subclass of Shape3D.
 * 
 * A pyramid is defined by its height (inherited) and the length of one edge of its square base.
 * This class provides methods to compute its volume and base area.
 */
public class Pyramid extends Shape3D {
    private double edge;

    
    /**
     * Constructs a Pyramid with a specified height and edge length.
     * 
     * @param height The height of the pyramid.
     * @param edge The length of one edge of the square base.
     */
    public Pyramid(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    
    /**
     * Returns the length of one edge of the pyramid's base.
     * 
     * @return The edge length of the base.
     */
    public double getEdge() {
        return edge;
    }

    
    /**
     * Calculates and returns the volume of the pyramid.
     * 
     * Formula: (1/3) * base area * height
     * 
     * @return The volume of the pyramid.
     */
    @Override
    public double getVolume() {
        return (edge * edge * height) / 3.0;
    }

    
    /**
     * Calculates and returns the base area of the pyramid.
     * 
     * Formula: edge²
     * 
     * @return The base area of the pyramid.
     */
    @Override
    public double getBaseArea() {
        return edge * edge;
    }

    
    /**
     * Returns a string representation of the pyramid, including its height and edge length.
     * 
     * @return A formatted string representing the pyramid.
     */
    @Override
    public String toString() {
        return super.toString() + " [edge=" + edge + "]";
    }
}
