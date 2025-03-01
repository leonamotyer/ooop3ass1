package shapes;

/**
 * Represents a Cylinder, a subclass of Shape3D.
 * 
 * A cylinder is defined by its height (inherited) and radius.
 * This class provides methods to compute its volume and base area.
 */
public class Cylinder extends Shape3D {
    private double radius;

    /**
     * Constructs a Cylinder with a specified height and radius.
     * 
     * @param height The height of the cylinder.
     * @param radius The radius of the base of the cylinder.
     */
    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    /**
     * Returns the radius of the cylinder's base.
     * 
     * @return The radius of the cylinder.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calculates and returns the volume of the cylinder.
     * 
     * Formula: π * r² * h
     * 
     * @return The volume of the cylinder.
     */
    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    /**
     * Calculates and returns the base area of the cylinder.
     * 
     * Formula: π * r²
     * 
     * @return The base area of the cylinder.
     */
    @Override
    public double getBaseArea() {
        return Math.PI * radius * radius;
    }
    
    /**
     * Returns a string representation of the cylinder, including its height and radius.
     * 
     * @return A formatted string representing the cylinder.
     */
    @Override
    public String toString() {
        return super.toString() + " [radius=" + radius + "]";
    }
}
