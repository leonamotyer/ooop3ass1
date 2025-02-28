package shapes;

/**
 * Represents a Pentagonal Prism, a subclass of Shape3D.
 * 
 * A pentagonal prism is defined by its height (inherited) and the length of one edge of its pentagonal base.
 * This class provides methods to compute its volume and base area.
 */
public class PentagonalPrism extends Shape3D {
    private double edge;

    
    /**
     * Constructs a Pentagonal Prism with a specified height and edge length.
     * 
     * @param height The height of the pentagonal prism.
     * @param edge The length of one edge of the pentagonal base.
     */
    public PentagonalPrism(double height, double edge) {
        super(height);
        this.edge = edge;
    }

    
    /**
     * Returns the length of one edge of the pentagonal prism's base.
     * 
     * @return The edge length of the base.
     */
    public double getEdge() {
        return edge;
    }

    
    /**
     * Calculates and returns the base area of the pentagonal prism.
     * 
     * Formula: (5/4) * edge² * tan(54°)
     * 
     * @return The base area of the pentagonal prism.
     */
    @Override
    public double getBaseArea() {
        return (5 * edge * edge * Math.tan(Math.toRadians(54))) / 4.0;
    }

    
    /**
     * Calculates and returns the volume of the pentagonal prism.
     * 
     * Formula: base area * height
     * 
     * @return The volume of the pentagonal prism.
     */
    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    
    /**
     * Returns a string representation of the pentagonal prism, including its height and edge length.
     * 
     * @return A formatted string representing the pentagonal prism.
     */
    @Override
    public String toString() {
        return super.toString() + " [edge=" + edge + "]";
    }
}

